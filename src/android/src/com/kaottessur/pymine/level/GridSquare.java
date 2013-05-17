package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;

public class GridSquare implements GridLocationInterface {
	private int row;
	private int column;
	private boolean scanned = false;
	
	public GridSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean isScanned() {
		return scanned;
	}
	
	public void scan() {
		scanned = !scanned;
	}
}
