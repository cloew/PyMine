package com.kaottessur.pymine.level.selection;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.LevelInit;

public class LevelSelection {
	private List<Level> levels;
	private int selectedIndex;
	
	public LevelSelection() {
		levels = new ArrayList<Level>();
		LevelInit levelInit = new LevelInit();
		
		LevelInit otherLevelInit = new LevelInit("2", 4, 5);
		otherLevelInit.setDefenseCount(Mine.class, 4);
		otherLevelInit.setDefenseCount(ReverseMine.class, 2);
		
		levels.add(new Level(levelInit));
		levels.add(new Level(otherLevelInit));
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
