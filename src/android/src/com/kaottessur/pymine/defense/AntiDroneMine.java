package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;

public class AntiDroneMine extends Mine {
	
	@Override
	public int getPowerRating() {
		return Power.EMP_POWER*2;
	}
	
	@Override
	public void defuse(Drone drone) {
		deactivate();
	}

	@Override
	public void defuseCarefully(Drone drone) {
		deactivate();
	}

	@Override
	public void hitByEMP(Drone drone) {
		deactivate();
	}
}
