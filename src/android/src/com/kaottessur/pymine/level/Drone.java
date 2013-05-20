package com.kaottessur.pymine.level;

import com.kaottessur.pymine.GridLocationInterface;

public class Drone implements GridLocationInterface {
	private int row;
	private int column;
	private boolean destroyed = false;
	
	public Drone() {
		row = 0;
		column = 0;
	}
	
	public void move(int newRow, int newColumn) {
		row = newRow;
		column = newColumn;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void destroy() {
		destroyed = true;
		System.out.println("Destroyed the drone");
	}
}
