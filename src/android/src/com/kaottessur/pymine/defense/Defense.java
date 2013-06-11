package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.defense.adder.StandardDefenseAdder;
import com.kaottessur.pymine.level.GridSquare;

public abstract class Defense implements DefenseInterface {
	protected boolean visible = false;
	protected boolean deactivated = false;
	protected GridSquare gridSquare;
	
	public Defense() {
	}
	
	public boolean isVisible() {
		return visible || deactivated;
	}
	
	public boolean isDeactivated() {
		return deactivated;
	}
	
	public boolean isMine() {
		return false;
	}
	
	public boolean isFragile() {
		return false;
	}
	
	public boolean reverseReadings() {
		return false;
	}
	
	public DefenseAdderInterface getDefenseAdder() {
		return new StandardDefenseAdder();
	}
	
	public void setGridSquare(GridSquare gridSquare) {
		if (this.gridSquare != null)
			this.gridSquare.removeDefense();
		this.gridSquare = gridSquare;
	}
	
	public GridSquare getGridSquare() {
		return gridSquare;
	}
	
	public void deactivate() {
		deactivated = true;
		reveal();
	}
	
	public void reveal() {
		visible = true;
	}
}
