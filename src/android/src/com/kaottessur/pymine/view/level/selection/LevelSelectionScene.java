package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
public class LevelSelectionScene extends Scene {
	private LevelDetailsScene detailsScene;
	
	public LevelSelectionScene(final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		LevelOverviewText overview = new LevelOverviewText(levelSelection, 0, vertexBufferObjectManager);
		attachChild(overview);
		registerTouchArea(overview);
		
		detailsScene = new LevelDetailsScene(this, levelSelection, vertexBufferObjectManager);
		attachChild(detailsScene);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
	}
}
