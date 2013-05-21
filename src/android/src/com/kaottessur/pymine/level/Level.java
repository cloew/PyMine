package com.kaottessur.pymine.level;

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
}
