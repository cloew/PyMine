package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.level.Drone;

public interface DefenseInterface {

	public DefenseAdderInterface getDefenseAdder();
	
	public boolean isDeactivated();
	public boolean isMine();
	public boolean reverseReadings();
	public int getPowerRating();
	
	
	public void scan(Drone drone);
	public void defuse(Drone drone);
	public void defuseCarefully(Drone drone);
}
