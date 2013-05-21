package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;

public class Level {
	private Drone drone;
	private Minefield minefield;
	private List<DefenseInterface> defenses;

	public Level() {
		reset();
	}
	
	public void reset() {
		minefield = new Minefield(4, 5);
		drone = new Drone(minefield);
		defenses = new ArrayList<DefenseInterface>();
		
		for (int i = 0; i < 1; i++) {
			DefenseInterface defense = new Mine();
			addDefense(defense);
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
