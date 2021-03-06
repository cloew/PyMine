package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;
import com.kaottessur.pymine.Power;
import com.kaottessur.pymine.level.rating.PowerRating;

public class Drone implements GridLocationInterface {
	private int row;
	private int column;
	private boolean destroyed = false;
	
	private Minefield minefield;
	private PowerRating powerRating;
	
	public Drone(Minefield minefield, PowerRating powerRating) {
		row = 0;
		column = 0;
		
		this.minefield = minefield;
		this.powerRating = powerRating;
	}
	
	public void moveDown() {
		tryToMove(row+1, column);
	}
	
	public void moveLeft() {
		tryToMove(row, column-1);
	}
	
	public void moveRight() {
		tryToMove(row, column+1);
	}
	
	public void moveUp() {
		tryToMove(row-1, column);
	}
	
	public void tryToMove(GridSquare gridSquare) {
		GridSquare currentSquare = minefield.getGridSquareAt(row, column);
		if (minefield.getCardinallyAdjacentGridSquares(currentSquare).contains(gridSquare))
			move(gridSquare);
	}
	
	public void tryToMove(int newRow, int newColumn) {
		if (validRow(newRow) && validColumn(newColumn)) {
			GridSquare newSquare = minefield.getGridSquareAt(newRow, newColumn);
			move(newSquare);
		}
	}
	
	public void move(GridSquare gridSquare) {
		move(gridSquare.getRow(), gridSquare.getColumn());
		gridSquare.droneEntered(this);
	}
	
	public void move(int newRow, int newColumn) {
		row = newRow;
		column = newColumn;
	}
	
	public void scan() {
		powerRating.usePower(Power.SCAN_POWER);
		minefield.scan(row, column, this);
	}
	
	public void defuse() {
		powerRating.usePower(Power.DEFUSE_POWER);
		minefield.defuse(row, column, this);
	}
	
	public void defuseCarefully() {
		powerRating.usePower(Power.CAREFUL_DEFUSE_POWER);
		minefield.defuseCarefully(row, column, this);
	}
	
	public void performEMP() {
		powerRating.usePower(Power.EMP_POWER);
		minefield.performEMP(row, column, this);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Minefield getMinefield() {
		return minefield;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public boolean hasPower() {
		return powerRating.getPower() > 0;
	}
	
	public int getPower() {
		return powerRating.getPower();
	}
	
	public void destroy() {
		destroyed = true;
		System.out.println("Destroyed the drone");
	}
	
	private boolean validRow(int newRow) {
		return newRow >= 0 && newRow < minefield.getRowCount();
	}
	
	private boolean validColumn(int newColumn) {
		return newColumn >= 0 && newColumn < minefield.getColumnCount();
	}
}
