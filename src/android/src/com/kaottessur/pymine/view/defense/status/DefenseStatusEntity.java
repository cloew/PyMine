package com.kaottessur.pymine.view.defense.status;

import java.util.Set;

import org.andengine.entity.Entity;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.DefenseOrder;
import com.kaottessur.pymine.level.Level;

public class DefenseStatusEntity extends Entity {

	public DefenseStatusEntity(float x, float y, Level level) {
		super(x, y);
		
		int row = 0;
		Set<Class<? extends DefenseInterface> > levelDefenseClasses = level.getDefenseClasses(); 
		for (Class<? extends DefenseInterface> defenseClass : DefenseOrder.defenseOrder) {
			if (levelDefenseClasses.contains(defenseClass)) {
				DefenseCountEntity defenseCount = new DefenseCountEntity(0, 64*row, level, defenseClass);
				attachChild(defenseCount);
				row++;
			}
		}
	}
}
