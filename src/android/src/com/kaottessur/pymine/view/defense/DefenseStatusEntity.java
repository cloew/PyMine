package com.kaottessur.pymine.view.defense;

import org.andengine.entity.Entity;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;

public class DefenseStatusEntity extends Entity {

	public DefenseStatusEntity(float x, float y, Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y);
		
		int row = 0;
		for (Class<? extends DefenseInterface> defenseClass : level.getDefenseClasses()) {
			DefenseCountEntity defenseCount = new DefenseCountEntity(0, 64*row, level, defenseClass, vertexBufferObjectManager);
			attachChild(defenseCount);
			row++;
		}
	}
}
