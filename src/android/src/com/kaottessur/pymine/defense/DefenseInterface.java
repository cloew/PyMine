package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.level.Drone;

public interface DefenseInterface {

	public boolean isDeactivated();
	public DefenseAdderInterface getDefenseAdder();
	
	public void scan(Drone drone);
}
