package com.kaottessur.pymine.view.defense;

import com.kaottessur.pymine.defense.AntiDroneTurret;
import com.kaottessur.pymine.defense.DefenseInterface;

public class AntiDroneTurretSprite extends DefenseSprite {

	public AntiDroneTurretSprite(AntiDroneTurret antiDroneTurret) {
		super(AntiDroneTurret.class, antiDroneTurret);
	}

	@Override
	protected void update(float secondsElapsed) {
		// Do Nothing
	}

	@Override
	protected Class<? extends DefenseInterface> getDefenseClass() {
		return AntiDroneTurret.class;
	}

	@Override
	protected String getDeactivatedFilename() {
		return null;
	}

	@Override
	protected String getActiveFilename() {
		return null;
	}

}
