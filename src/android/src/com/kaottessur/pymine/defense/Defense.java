package com.kaottessur.pymine.defense;

import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;
import com.kaottessur.pymine.defense.adder.StandardDefenseAdder;

public abstract class Defense implements DefenseInterface {
	protected boolean visible = false;
	protected boolean deactivated = false;
	
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
	
	public void deactivate() {
		deactivated = true;
		reveal();
	}
	
	public void reveal() {
		visible = true;
	}
}
