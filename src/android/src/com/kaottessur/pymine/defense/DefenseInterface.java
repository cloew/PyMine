package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;

public interface DefenseInterface {

	public DefenseAdderInterface getDefenseAdder();
	public void setGridSquare(GridSquare gridSquare);
	public GridSquare getGridSquare();
	
	public boolean isVisible();
	public boolean isDeactivated();
	public boolean isMine();
	public boolean isFragile();
	public boolean reverseReadings();
	public int getPowerRating();
	
	public void reveal();
	
	
	public void scan(Drone drone);
	public void defuse(Drone drone);
	public void defuseCarefully(Drone drone);
	public void hitByEMP(Drone drone);
}
