package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.level.Drone;

public class FragileMine extends Mine {
	@Override
	public boolean isFragile() {
		return true;
	}
	
	@Override
	public void defuse(Drone drone) {
		tryToDetonate(drone);
	}
}
