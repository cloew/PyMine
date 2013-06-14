package com.kaottessur.pymine.view.defense;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;

public class MineSprite extends DefenseSprite {
	protected Mine mine;
	
	public MineSprite(Mine mine) {
		this(Mine.class, mine);
	}
	
	public MineSprite(Class<? extends DefenseInterface> defenseClass, Mine mine) {
		super(defenseClass, mine);
		this.mine = mine;
	}
	
	@Override
	protected void update(float secondsElapsed) {
		// Don't do anything
	}
	
	@Override protected Class<? extends DefenseInterface> getDefenseClass() {
		return Mine.class;
	}
}
