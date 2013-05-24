package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;

public class LevelSelectionScene extends Scene {
	
	public LevelSelectionScene(final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		LevelOverviewText overview = new LevelOverviewText(levelSelection, 0, vertexBufferObjectManager);
		attachChild(overview);
		registerTouchArea(overview);
		
		Button playButton = new Button(400, 240, 100, 100, vertexBufferObjectManager)
		{
	        public void performButtonAction()
	        {
	            SceneManager.GetInstance().runLevelScene(levelSelection.getSelectedLevel());
	        };
	    };
		attachChild(playButton);
		registerTouchArea(playButton);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
	}
}
