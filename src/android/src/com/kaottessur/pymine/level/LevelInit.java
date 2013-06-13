package com.kaottessur.pymine.level;

import java.util.HashMap;
import java.util.Map;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;

public class LevelInit {
	public String name;
	public int rows;
	public int columns;
	
	public Map<Class<? extends DefenseInterface>, Integer> defenseCounts;
	
	
	public LevelInit() {
		name = "1";
		rows = 4;
		columns = 5;
		defenseCounts = new HashMap<Class<? extends DefenseInterface>, Integer>();
		defenseCounts.put(Mine.class, 4);
		defenseCounts.put(ReverseMine.class, 2);
		defenseCounts.put(Worm.class, 1);
	}

	public LevelInit(String name, int rows, int columns) {
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.defenseCounts = new HashMap<Class<? extends DefenseInterface>, Integer>();
	}
	
	public void setDefenseCount(Class<? extends DefenseInterface> defenseClass, Integer count) {
		defenseCounts.put(defenseClass, count);
	}
	
}
