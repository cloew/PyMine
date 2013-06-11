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
	
	private int ticksToAttack = 0;
	private int ticksToMove = 0;
	
	public static final int TICKS_TO_ATTACK = 20;
	public static final int TICKS_TO_MOVE = 20;
	
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
	
	@Override
	public void droneEnteredGridSquare(Drone drone) {
		startAttacking();
	}
	
	public void update(Drone drone, Minefield minefield) {
		System.out.println("Updating Worm");
		if (!deactivated && !visible) {
			tryToMove(minefield);
			tryToAttack(drone);
		}
	}
	
	private void tryToMove(Minefield minefield) {
		if (!attacking && ticksToMove == TICKS_TO_MOVE) {
			move(minefield);
			ticksToMove = 0;
		} else {
			ticksToMove += 1;
		}
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
				break;
			}
		}
	}
	
	private void tryToAttack(Drone drone) {
		if (!attacking && droneInGridSquare(drone)) {
			startAttacking();
		}
		
		else if (attacking) {
			if (ticksToAttack == TICKS_TO_ATTACK) {
				attack(drone);
			}
			ticksToAttack += 1;
		}
	}
	
	private void startAttacking() {
		ticksToAttack = 0;
		attacking = true;
	}
	
	private void attack(Drone drone) {
		if (droneInGridSquare(drone)) {
			drone.destroy();
		}
		attacking = false;
	}
	
	private boolean droneInGridSquare(Drone drone) {
		return drone.getRow() == gridSquare.getRow() && drone.getColumn() == gridSquare.getColumn();
	}
	
	public int getTicksTowardsAttack() {
		return ticksToAttack;
	}
}
