package com.kaottessur.pymine.view.level.selection;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;
import com.kaottessur.pymine.view.defense.DefenseCountEntity;

public class LevelDetailsScene extends Entity {
	private Level level;
	private LevelSelection levelSelection;
	
	private Text nameText;
	private Text gridDimensionsText;
	
	private Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			detachChild(nameText);
		}
	};
	
	public LevelDetailsScene(Scene parent, final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		setPosition(600, 0);
		
		this.levelSelection = levelSelection;
		level = levelSelection.getSelectedLevel();
		
		addHeader(vertexBufferObjectManager);
		addDefenseCounts(vertexBufferObjectManager);
		addPlayButton(parent, vertexBufferObjectManager);
		
		registerUpdate();
	}
	
	private void addHeader(VertexBufferObjectManager vertexBufferObjectManager) {
		nameText = new Text(50, 0, TextureWrapper.GetInstance().GetCompletionFont(), level.getName(), vertexBufferObjectManager);
		attachChild(nameText);
		centerText(nameText, 100);
		String text = Integer.toString(level.getMinefield().getRowCount()) + "x" + Integer.toString(level.getMinefield().getColumnCount());
		//addText(gridDimensionsText, 50, text, vertexBufferObjectManager);
		gridDimensionsText = new Text(50, 50, TextureWrapper.GetInstance().GetCompletionFont(), text, vertexBufferObjectManager);
		attachChild(gridDimensionsText);
		centerText(gridDimensionsText, 100);
	}
	
	private void addDefenseCounts(VertexBufferObjectManager vertexBufferObjectManager) {
		int row = 0;
		for (Class<? extends DefenseInterface> defenseClass : level.getDefenseClasses()) {
			DefenseCountEntity defenseCount = new DefenseCountEntity(50, 100+64*row, level, defenseClass, vertexBufferObjectManager);
			attachChild(defenseCount);
			row++;
		}
	}
	
	private void addPlayButton(Scene parent, VertexBufferObjectManager vertexBufferObjectManager) {
		Button playButton = new Button(50, 400, 100, 50, vertexBufferObjectManager)
		{
	        public void performButtonAction()
	        {
	            SceneManager.GetInstance().runLevelScene(level);
	        };
	    };
		attachChild(playButton);
		parent.registerTouchArea(playButton);
	}
	
	private void addText(Text textEntity, float y, String text, VertexBufferObjectManager vertexBufferObjectManager) {
		textEntity = new Text(50, y, TextureWrapper.GetInstance().GetCompletionFont(), text, vertexBufferObjectManager);
		attachChild(textEntity);
		centerText(textEntity, 100);
	}
	
	private void centerText(Text text, float centerX) {
		float width = text.getWidth();
		text.setPosition(centerX-width/2, text.getY());
	}
	
	private void registerUpdate() {
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				System.out.println(String.format("Selceted Level is: %d", levelSelection.getSelectedIndex()));
				if (levelSelection.getSelectedLevel() != level) {
					level = levelSelection.getSelectedLevel();
					nameText.setText(level.getName());
					gridDimensionsText.setText(Integer.toString(level.getMinefield().getRowCount()) + "x" + Integer.toString(level.getMinefield().getColumnCount()));
				}
				//activity.runOnUiThread(runnable);
			}
		});
	}
}
