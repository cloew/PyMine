package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;

import com.kaottessur.pymine.level.selection.LevelSelection;

public class LevelSelectionScene extends Scene {
	private LevelDetailsScene detailsScene;
	private LevelSelection levelSelection;
	
	public LevelSelectionScene(final LevelSelection levelSelection) {
		super();
		
		this.levelSelection = levelSelection;
		addLevelOverviewTexts(levelSelection);
		
		detailsScene = new LevelDetailsScene(this, levelSelection);
		attachChild(detailsScene);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
		
		setTouchAreaBindingOnActionDownEnabled(true);
	}
	
	private void addLevelOverviewTexts(final LevelSelection levelSelection) {
		for (int i = 0; i < levelSelection.getLevelCount(); i++) {
			LevelOverviewText overview = new LevelOverviewText(levelSelection, i);
			attachChild(overview);
			registerTouchArea(overview);
		}
	}
	
	public void resetLevels() {
		levelSelection.resetLevels();
	}
}
