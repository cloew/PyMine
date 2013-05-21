package com.kaottessur.pymine.level.rating;

import com.kaottessur.pymine.level.Level;

public class PowerRating extends Rating {
	private int power;
	
	public PowerRating(Level level, int power) {
		super(level);
		this.power = power;
	}
	
	public void usePower(int amount) {
		if (!level.finished())
			power -= amount;
	}
	
	public int getPower() {
		return power;
	}

	@Override
	public void checkAwarded() {
		awarded = (power >= 15);
	}

}
