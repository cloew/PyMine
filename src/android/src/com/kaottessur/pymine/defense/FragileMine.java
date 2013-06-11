package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;

public class FragileMine extends Mine {
	@Override
	public boolean isFragile() {
		return true;
	}
	
	@Override
	public int getPowerRating() {
		return Power.CAREFUL_DEFUSE_POWER;
	}
	
	@Override
	public void defuse(Drone drone) {
		tryToDetonate(drone);
	}
}
