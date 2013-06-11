package com.kaottessur.pymine.defense;

import java.util.List;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class Worm extends Defense {

	@Override
	public boolean isVisible() {
		return true;
	}

	public int getPowerRating() {
		return Power.EMP_POWER;
	}
	
	@Override
	public void scan(Drone drone) {
		// Do Nothing	
	}

	@Override
	public void defuse(Drone drone) {
		// Do Nothing
	}

	@Override
	public void defuseCarefully(Drone drone) {
		// Do Nothing
	}

	@Override
	public void hitByEMP(Drone drone) {
		deactivate();
	}
	
	public void update(Drone drone, Minefield minefield) {
		if (!deactivated) {
			tryToMove(minefield);
		}
	}
	
	private void tryToMove(Minefield minefield) {
		move(minefield);
	}
	
	private void move(Minefield minefield) {
		List<GridSquare> adjacentSquares = minefield.getAdjacentGridSquares(gridSquare, false);
		
	}
}
