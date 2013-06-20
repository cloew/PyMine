package com.kaottessur.pymine.view.defense;

import com.kaottessur.pymine.defense.AntiDroneMine;
import com.kaottessur.pymine.defense.DefenseInterface;

public class AntiDroneMineSprite extends DefenseSprite {

	public AntiDroneMineSprite(DefenseInterface defense) {
		super(AntiDroneMine.class, defense);
	}

	@Override
	protected void update(float secondsElapsed) {
		// Do Nothing
	}

	@Override
	protected Class<? extends DefenseInterface> getDefenseClass() {
		return AntiDroneMine.class;
	}

}
