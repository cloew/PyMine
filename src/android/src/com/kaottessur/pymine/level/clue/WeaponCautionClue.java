package com.kaottessur.pymine.level.clue;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class WeaponCautionClue extends SubClue {
	private boolean nearWeapons = false;
	
	public boolean isNearWeaponry() {
		return nearWeapons;
	}
	
	@Override
	public void update(Minefield minefield, int gridRow, int gridColumn) {
		nearWeapons = false;
	}
	
	@Override
	public void updateFromAdjacentSquare(GridSquare gridSquare) {
		if (gridSquare.mined()) {
			nearWeapons = true;
		}
	}
}
