package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.scene.Scene;

import com.kaottessur.pymine.level.selection.LevelSelection;

public class LevelSelectionScene extends Scene {
	private LevelSelection levelSelection;
	
	public LevelSelectionScene(LevelSelection levelSelection) {
		super();
		this.levelSelection = levelSelection;
	}
}
