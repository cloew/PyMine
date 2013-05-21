package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;

public class Level {
	private LevelInit levelInit;
	private Drone drone;
	private Minefield minefield;
	private List<DefenseInterface> defenses;

	public Level(LevelInit levelInit) {
		this.levelInit = levelInit;
		reset();
	}
	
	public void reset() {
		minefield = new Minefield(levelInit.rows, levelInit.columns);
		drone = new Drone(minefield);
		defenses = new ArrayList<DefenseInterface>();
		
		addDefenses();
	}
	
	private void addDefenses() {
		for (Class<? extends DefenseInterface> defenseClass : levelInit.defenseCounts.keySet()) {
			for (int i = 0; i < levelInit.defenseCounts.get(defenseClass); i++) {
				try {
					DefenseInterface defense = defenseClass.newInstance();
					addDefense(defense);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void addDefense(DefenseInterface defense) {
		defenses.add(defense);
		DefenseAdderInterface defenseAdder = defense.getDefenseAdder();
		defenseAdder.addDefense(defense, minefield);
	}
	
	public boolean finished() {
		return lost() || won();
	}
	
	public boolean lost() {
		return drone.isDestroyed();
	}
	
	public boolean won() {
		for (DefenseInterface defense : defenses) {
			if (!defense.isDeactivated())
				return false;
		}
		return true;
	}
	
	public Drone getDrone() {
		return drone;
	}
	
	public Minefield getMinefield() {
		return minefield;
	}
}
