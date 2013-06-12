package com.kaottessur.pymine.level.selection;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.LevelInit;

public class LevelSelection {
	private List<Level> levels;
	private int selectedIndex;
	
	public LevelSelection() {
		levels = new ArrayList<Level>();
		LevelInit levelInit = new LevelInit();
		levels.add(new Level(levelInit));
		selectedIndex = 0;
	}
	
	public Level getSelectedLevel() {
		return levels.get(selectedIndex);
	}
	
	public Level getLevelAt(int index) {
		return levels.get(index);
	}
	
	public void selectLevel(int index) {
		selectedIndex = index;
	}
	
	
}
