package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

public class Minefield {
	private int rows;
	private int columns;
	
	private Drone drone;
	private List<List<GridSquare>> gridSquares;
	
	
	public Minefield(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		populateGridSquares();
	}
	
	private void populateGridSquares() {
		drone = new Drone();
		gridSquares = new ArrayList<List<GridSquare>>();
		
		for (int row = 0; row < rows; row++) {
			gridSquares.add(new ArrayList<GridSquare>());
			for (int column = 0; column < columns; column++) {
				GridSquare gridSquare = new GridSquare(row, column);
				gridSquares.get(row).add(gridSquare);
			}
		}
	}
	
	public int getRowCount() {
		return rows;
	}
	
	public int getColumnCount() {
		return columns;
	}
	
	public Drone getDrone() {
		return drone;
	}
	
	public GridSquare getGridSquareAt(int row, int column) {
		return gridSquares.get(row).get(column);
	}
}
