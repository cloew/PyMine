package com.kaottessur.pymine.defense;

import java.util.List;
import java.util.Random;

import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class Worm extends Defense {
	private Random randomGenerator;
	private boolean attacking = false;
	
	public Worm() {
		super();
		randomGenerator = new Random();
	}
	
	@Override
	public boolean isVisible() {
		return super.isVisible() || attacking;
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
		System.out.println("Updating Worm");
		if (!deactivated) {
			tryToAttack(drone);
			tryToMove(minefield);
		}
	}
	
	private void tryToMove(Minefield minefield) {
		if (!attacking)
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
				squareToMoveTo.setDefense(this);
				setGridSquare(squareToMoveTo);
				System.out.println(String.format("Worm is at: %d:%d", squareToMoveTo.getRow(), squareToMoveTo.getColumn()));
				break;
			}
		}
	}
	
	private void tryToAttack(Drone drone) {
		if (!attacking) {
			attacking = droneInGridSquare(drone);
		}
		
		else if (attacking) {
			if (droneInGridSquare(drone)) {
				drone.destroy();
			}
			attacking = false;
		}
	}
	
	private boolean droneInGridSquare(Drone drone) {
		return drone.getRow() == gridSquare.getRow() && drone.getColumn() == gridSquare.getColumn();
	}
}
