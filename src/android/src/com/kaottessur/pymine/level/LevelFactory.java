package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.AntiDroneMine;
import com.kaottessur.pymine.defense.FragileMine;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;

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
		otherLevelInit.setDefenseCount(ReverseMine.class, 1);
		addLevel(otherLevelInit);
		
		LevelInit levelInit3 = new LevelInit("3", 4, 5);
		levelInit3.setDefenseCount(Mine.class, 10);
		levelInit3.setDefenseCount(ReverseMine.class, 2);
		addLevel(levelInit3);
		
		LevelInit levelInit4 = new LevelInit("4", 4, 5);
		levelInit4.setDefenseCount(Mine.class, 8);
		levelInit4.setDefenseCount(ReverseMine.class, 2);
		levelInit4.setDefenseCount(FragileMine.class, 2);
		addLevel(levelInit4);
		
		LevelInit levelInit5 = new LevelInit("5", 4, 5);
		levelInit5.setDefenseCount(AntiDroneMine.class, 1);
		addLevel(levelInit5);
		
		LevelInit levelInit6 = new LevelInit("6", 5, 6);
		levelInit6.setDefenseCount(Mine.class, 10);
		levelInit6.setDefenseCount(ReverseMine.class, 4);
		levelInit6.setDefenseCount(FragileMine.class, 2);
		addLevel(levelInit6);
		
		LevelInit levelInit7 = new LevelInit("7", 3, 3);
		levelInit7.setDefenseCount(FragileMine.class, 2);
		addLevel(levelInit7);
		
		LevelInit levelInit8 = new LevelInit("8", 4, 5);
		levelInit8.setDefenseCount(Mine.class, 4);
		levelInit8.setDefenseCount(ReverseMine.class, 2);
		levelInit8.setDefenseCount(Worm.class, 10);
		addLevel(levelInit8);
	}
	
	public List<Level> getLevels() {
		return levels;
	}
	
	private void addLevel(LevelInit levelInit) {
		levels.add(new Level(levelInit));
	}
}
