package com.kaottessur.pymine.level;

import java.util.HashMap;
import java.util.Map;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;

public class LevelInit {
	public int rows;
	public int columns;
	
	public Map<Class<? extends DefenseInterface>, Integer> defenseCounts;
	
	
	public LevelInit() {
		rows = 4;
		columns = 5;
		defenseCounts = new HashMap<Class<? extends DefenseInterface>, Integer>();
		defenseCounts.put(Mine.class, 4);
	}

}
