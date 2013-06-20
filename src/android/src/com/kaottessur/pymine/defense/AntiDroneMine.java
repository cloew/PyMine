package com.kaottessur.pymine.defense;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;

public class AntiDroneMine extends Mine {
	private List<AntiDroneTurret> turrets;
	
	public AntiDroneMine() {
		turrets = new ArrayList<AntiDroneTurret>();
	}
	
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
	
	public void addTurret(AntiDroneTurret turret) {
		turrets.add(turret);
	}
	
	@Override
	public void deactivate() {
		super.deactivate();
		
		for (AntiDroneTurret turret : turrets) {
			turret.deactivate();
		}
	}
}
