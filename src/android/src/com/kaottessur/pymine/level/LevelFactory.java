package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;

public class LevelFactory {
	private static LevelFactory instance;
	private List<Level> levels;
	
	public static LevelFactory GetInstance() {
		if (instance == null)
			instance = new LevelFactory();
		return instance;
	}
	
	public static List<Level> GetLevels() {
		return GetInstance().getLevels();
	}
	
	private LevelFactory() {
		levels = new ArrayList<Level>();
		
		LevelInit levelInit = new LevelInit("1", 4, 5);
		levelInit.setDefenseCount(Mine.class, 4);
		addLevel(levelInit);
		
		LevelInit otherLevelInit = new LevelInit("2", 4, 5);
		otherLevelInit.setDefenseCount(Mine.class, 4);
		otherLevelInit.setDefenseCount(ReverseMine.class, 2);
		addLevel(otherLevelInit);
	}
	
	public List<Level> getLevels() {
		return levels;
	}
	
	private void addLevel(LevelInit levelInit) {
		levels.add(new Level(levelInit));
	}
}
