package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

public class Minefield {
	private int rows;
	private int columns;
	
	private List<List<GridSquare>> gridSquares;
	
	
	public Minefield(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		populateGridSquares();
	}
	
	private void populateGridSquares() {
		gridSquares = new ArrayList<List<GridSquare>>();
		
		for (int row = 0; row < rows; row++) {
			gridSquares.add(new ArrayList<GridSquare>());
			for (int column = 0; column < columns; column++) {
				GridSquare gridSquare = new GridSquare(row, column);
				gridSquares.get(row).add(gridSquare);
			}
		}
	}
}
