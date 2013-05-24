package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.SceneManager;

public class LevelSelectionScene extends Scene {
	//private final LevelSelection levelSelection;
	
	public LevelSelectionScene(final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		//this.levelSelection = levelSelection;
		
		LevelOverviewText overview = new LevelOverviewText(levelSelection, 0, vertexBufferObjectManager);
		attachChild(overview);
		registerTouchArea(overview);
		
		Rectangle playButton = new Rectangle(400, 240, 100, 100, vertexBufferObjectManager)
		{
	        public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
	        {
	            if (touchEvent.isActionUp())
	            {
	            	SceneManager.GetInstance().runLevelScene(levelSelection.getSelectedLevel());
	            }
	            return true;
	        };
	    };
		playButton.setColor(.5f, .5f, .5f);
		attachChild(playButton);
		registerTouchArea(playButton);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
	}
}
