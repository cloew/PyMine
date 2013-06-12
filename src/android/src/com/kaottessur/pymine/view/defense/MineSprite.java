package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;

public class MineSprite extends DefenseSprite {
	protected Mine mine;
	
	public MineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		this(Mine.class, mine, vertexBufferObjectManager);
	}
	
	public MineSprite(Class<? extends DefenseInterface> defenseClass, Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super(defenseClass, mine, vertexBufferObjectManager);
		this.mine = mine;
	}
	
	@Override
	protected void update(float secondsElapsed) {
		// Don't do anything
	}
	
	@Override protected Class<? extends DefenseInterface> getDefenseClass() {
		return Mine.class;
	}
	
	@Override
	protected String getDeactivatedFilename() {
		return "DefusedMine1.png";
	}
	
	@Override
	protected String getActiveFilename() {
		return "Mine1.png";
	}
}
