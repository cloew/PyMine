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
	
	public void scan(Drone drone) {
		tryToDetonate(drone);
	}
	
	public void defuse(Drone drone) {
		deactivated = true;
	}
	
	private void tryToDetonate(Drone drone) {
		if (!deactivated)
			drone.destroy();
	}
}
