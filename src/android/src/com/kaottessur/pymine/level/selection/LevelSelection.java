package com.kaottessur.pymine.level.selection;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.level.Level;

public class LevelSelection {
	private List<Level> levels;
	private int selectedIndex;
	
	public LevelSelection() {
		levels = new ArrayList<Level>();
		selectedIndex = 0;
	}
	
	public Level getSelectedLevel() {
		return levels.get(selectedIndex);
	}
	
	public void selectLevel(int index) {
		selectedIndex = index;
	}
}
