package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
public class LevelSelectionScene extends Scene {
	private LevelDetailsScene detailsScene;
	
	public LevelSelectionScene(final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		addLevelOverviewTexts(levelSelection, vertexBufferObjectManager);
		
		detailsScene = new LevelDetailsScene(this, levelSelection, vertexBufferObjectManager);
		attachChild(detailsScene);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
		
		setTouchAreaBindingOnActionDownEnabled(true);
	}
	
	private void addLevelOverviewTexts(final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		for (int i = 0; i < levelSelection.getLevelCount(); i++) {
			LevelOverviewText overview = new LevelOverviewText(levelSelection, i, vertexBufferObjectManager);
			attachChild(overview);
			registerTouchArea(overview);
		}
	}
}
