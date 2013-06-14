package com.kaottessur.pymine.view.defense;

import org.andengine.entity.Entity;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;

public class DefenseStatusEntity extends Entity {

	public DefenseStatusEntity(float x, float y, Level level) {
		super(x, y);
		
		int row = 0;
		for (Class<? extends DefenseInterface> defenseClass : level.getDefenseClasses()) {
			DefenseCountEntity defenseCount = new DefenseCountEntity(0, 64*row, level, defenseClass);
			attachChild(defenseCount);
			row++;
		}
	}
}
