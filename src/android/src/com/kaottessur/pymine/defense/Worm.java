package com.kaottessur.pymine.defense;

import java.util.List;
import java.util.Random;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class Worm extends Defense {
	private Random randomGenerator;
	
	public Worm() {
		super();
		randomGenerator = new Random();
	}
	
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
		while (adjacentSquares.size() > 0) {
			int index = randomGenerator.nextInt(adjacentSquares.size());
			GridSquare squareToMoveTo = adjacentSquares.get(index);
			
			if (squareToMoveTo.hasDefense() || squareToMoveTo.getColumn() == 0) {
				adjacentSquares.remove(squareToMoveTo);
			} else {
				// Remove Defense from original square
				squareToMoveTo.setDefense(this);
				setGridSquare(squareToMoveTo);
				break;
			}
		}
	}
}
