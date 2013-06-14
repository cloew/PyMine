package com.kaottessur.pymine.view.level.selection;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;
import com.kaottessur.pymine.view.defense.status.DefenseStatusEntity;

public class LevelDetailsScene extends Entity {
	private Level level;
	private LevelSelection levelSelection;
	
	private DefenseStatusEntity defenseStatusEntity;
	private Text nameText;
	private Text gridDimensionsText;
	
	private Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			detachChild(defenseStatusEntity);
			addDefenseCounts();
		}
	};
	
	public LevelDetailsScene(Scene parent, final LevelSelection levelSelection) {
		super();
		setPosition(600, 0);
		
		this.levelSelection = levelSelection;
		level = levelSelection.getSelectedLevel();
		
		addHeader();
		addDefenseCounts();
		addPlayButton(parent);
		registerUpdate();
	}
	
	private void addHeader() {
		nameText = new Text(50, 0, TextureWrapper.GetInstance().GetCompletionFont(), level.getName(), SceneManager.GetVertexBufferObjectManager());
		attachChild(nameText);
		centerText(nameText, 100);
		gridDimensionsText = new Text(50, 50, TextureWrapper.GetInstance().GetCompletionFont(), getGridDimensionsString(), SceneManager.GetVertexBufferObjectManager());
		attachChild(gridDimensionsText);
		centerText(gridDimensionsText, 100);
	}
	
	private void addDefenseCounts() {
		defenseStatusEntity = new DefenseStatusEntity(50, 100, level);
		attachChild(defenseStatusEntity);
	}
	
	private void addPlayButton(Scene parent) {
		Button playButton = new Button(50, 400, 100, 50, SceneManager.GetVertexBufferObjectManager())
		{
	        public void performButtonAction()
	        {
	            SceneManager.GetInstance().runLevelScene(level);
	        };
	    };
		attachChild(playButton);
		parent.registerTouchArea(playButton);
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
				if (levelSelection.getSelectedLevel() != level) {
					level = levelSelection.getSelectedLevel();
					nameText.setText(level.getName());
					gridDimensionsText.setText(getGridDimensionsString());
					SceneManager.RunOnUIThread(runnable);
				}
			}
		});
	}
	
	private String getGridDimensionsString() {
		return Integer.toString(level.getMinefield().getRowCount()) + "x" + Integer.toString(level.getMinefield().getColumnCount());
	}
}
