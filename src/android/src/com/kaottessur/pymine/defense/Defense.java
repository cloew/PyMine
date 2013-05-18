package com.kaottessur.pymine.defense;

public abstract class Defense {
	protected boolean deactivated = false;
	
	public Defense() {
		
	}
	
	public boolean isDeactivated() {
		return deactivated;
	}
}
