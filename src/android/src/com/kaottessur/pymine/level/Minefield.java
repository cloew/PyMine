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
	
	public void scan(int row, int column, Drone drone) {
		GridSquare gridSquare = getGridSquareAt(row, column);
		gridSquare.scan(drone);
	}
	
	public void defuse(int row, int column, Drone drone) {
		GridSquare gridSquare = getGridSquareAt(row, column);
		gridSquare.defuse(drone);
	}
	
	public void defuseCarefully(int row, int column, Drone drone) {
		GridSquare gridSquare = getGridSquareAt(row, column);
		gridSquare.defuseCarefully(drone);
	}
	
	public int getRowCount() {
		return rows;
	}
	
	public int getColumnCount() {
		return columns;
	}
	
	public GridSquare getGridSquareAt(int row, int column) {
		try {
			return gridSquares.get(row).get(column);
		} catch(ArrayIndexOutOfBoundsException e) {
			return null;
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public List<GridSquare> getAdjacentGridSquares(GridSquare centerSquare, boolean includeCenter) {
		List<GridSquare> adjacentGridSquares = new ArrayList<GridSquare>();
		
		for (int row = centerSquare.getRow()-1; row <= centerSquare.getRow()+1; row++) {
			for (int column = centerSquare.getColumn()-1; column <= centerSquare.getColumn()+1; column++) {
				GridSquare gridSquare = getGridSquareAt(row, column);
				
				if (!includeCenter && gridSquare == centerSquare)
					continue;
				
				if (gridSquare != null)
					adjacentGridSquares.add(gridSquare);
			}
		}
		
		return adjacentGridSquares;
	}
	
	public List<GridSquare> getCardinallyAdjacentGridSquares(GridSquare centerSquare) {
		List<GridSquare> adjacentGridSquares = new ArrayList<GridSquare>();
		
		for (int row = centerSquare.getRow()-1; row <= centerSquare.getRow()+1; row+=2) {
			GridSquare gridSquare = getGridSquareAt(row, centerSquare.getColumn());
			if (gridSquare != null)
				adjacentGridSquares.add(gridSquare);
		}
		
		for (int column = centerSquare.getColumn()-1; column <= centerSquare.getColumn()+1; column+=2) {
			GridSquare gridSquare = getGridSquareAt(centerSquare.getRow(), column);
			if (gridSquare != null)
				adjacentGridSquares.add(gridSquare);
		}
		
		return adjacentGridSquares;
	}
}
