package com.kaottessur.pymine.level.selection;

import java.util.List;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.LevelFactory;

public class LevelSelection {
	private List<Level> levels;
	private int selectedIndex;
	
	public LevelSelection() {
		levels = LevelFactory.GetLevels();
		selectedIndex = 0;
	}
	
	public Level getSelectedLevel() {
		return levels.get(selectedIndex);
	}
	
	public int getSelectedIndex() {
		return selectedIndex;
	}
	
	public Level getLevelAt(int index) {
		return levels.get(index);
	}
	
	public void selectLevel(int index) {
		selectedIndex = index;
	}
	
	public int getLevelCount() {
		return levels.size();
	}
}
