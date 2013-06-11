package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;

public class Mine extends Defense {

	@Override
	public boolean isMine() {
		return true;
	}
	
	@Override
	public int getPowerRating() {
		return Power.DEFUSE_POWER;
	}

	@Override
	public void scan(Drone drone) {
		tryToDetonate(drone);
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
		tryToDetonate(drone);
	}
	
	@Override
	public void droneEnteredGridSquare(Drone drone) {
		// Do Nothing
	}
	
	protected void tryToDetonate(Drone drone) {
		if (!deactivated)
			drone.destroy();
	}
}
