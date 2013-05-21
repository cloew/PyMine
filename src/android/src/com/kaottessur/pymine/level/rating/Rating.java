package com.kaottessur.pymine.level.rating;

import com.kaottessur.pymine.level.Level;

public abstract class Rating {
	protected boolean awarded = false;
	protected Level level;
	
	public Rating(Level level) {
		this.level = level;
	}
	
	public boolean isAwarded() {
		return awarded;
	}
	
	public abstract void checkAwarded();
}
