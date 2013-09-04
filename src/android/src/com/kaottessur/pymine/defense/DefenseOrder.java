package com.kaottessur.pymine.defense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DefenseOrder {
	public Map<Class<? extends DefenseInterface>, Integer> defenseCounts;
	static List<Class<? extends DefenseInterface> > defenseOrder = new ArrayList<Class<? extends DefenseInterface> >();
	
	static {
		defenseOrder.add(Mine.class);
		defenseOrder.add(ReverseMine.class);
		defenseOrder.add(FragileMine.class);
		defenseOrder.add(AntiDroneMine.class);
		defenseOrder.add(AntiDroneTurret.class);
		defenseOrder.add(Worm.class);
	}

}
