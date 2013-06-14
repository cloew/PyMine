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
	
	@Override
	public boolean isVisible() {
		return visible || deactivated;
	}
	
	@Override
	public boolean isDeactivated() {
		return deactivated;
	}
	
	@Override
	public boolean isMine() {
		return false;
	}
	
	@Override
	public boolean isWeapon() {
		return false;
	}
	
	@Override
	public boolean isFragile() {
		return false;
	}
	
	@Override
	public boolean reverseReadings() {
		return false;
	}
	
	@Override
	public DefenseAdderInterface getDefenseAdder() {
		return new StandardDefenseAdder();
	}
	
	@Override
	public void setGridSquare(GridSquare gridSquare) {
		if (this.gridSquare != null)
			this.gridSquare.removeDefense();
		this.gridSquare = gridSquare;
	}
	
	@Override
	public GridSquare getGridSquare() {
		return gridSquare;
	}
	
	public void deactivate() {
		deactivated = true;
		reveal();
	}
	
	@Override
	public void reveal() {
		visible = true;
	}
}
