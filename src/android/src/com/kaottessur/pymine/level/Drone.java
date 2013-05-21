package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;

public class Drone implements GridLocationInterface {
	private int row;
	private int column;
	private boolean destroyed = false;
	
	private Minefield minefield;
	
	public Drone(Minefield minefield) {
		row = 0;
		column = 0;
		this.minefield = minefield;
	}
	
	public void tryToMove(GridSquare gridSquare) {
		GridSquare currentSquare = minefield.getGridSquareAt(row, column);
		if (minefield.getCardinallyAdjacentGridSquares(currentSquare).contains(gridSquare))
			move(gridSquare.getRow(), gridSquare.getColumn());
	}
	
	public void move(int newRow, int newColumn) {
		row = newRow;
		column = newColumn;
	}
	
	public void scan() {
		minefield.scan(row, column, this);
	}
	
	public void defuse() {
		minefield.defuse(row, column, this);
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
	
	public void destroy() {
		destroyed = true;
		System.out.println("Destroyed the drone");
	}
}
