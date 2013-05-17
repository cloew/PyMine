package com.kaottessur.pymine.level;

public class GridSquare {
	private int row;
	private int column;
	private boolean scanned = false;
	
	public GridSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
