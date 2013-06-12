package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.Entity;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;

public class LevelDetailsScene extends Entity {
	
	public LevelDetailsScene(Scene parent, final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		setPosition(400, 0);
		
		Button playButton = new Button(20, 240, 100, 100, vertexBufferObjectManager)
		{
	        public void performButtonAction()
	        {
	            SceneManager.GetInstance().runLevelScene(levelSelection.getSelectedLevel());
	        };
	    };
		attachChild(playButton);
		parent.registerTouchArea(playButton);
	}
}
