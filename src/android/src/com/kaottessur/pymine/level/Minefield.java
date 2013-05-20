package com.kaottessur.pymine.level;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.adder.DefenseAdderInterface;

public class Minefield {
	private int rows;
	private int columns;
	
	private Drone drone;
	private List<List<GridSquare>> gridSquares;
	
	
	public Minefield(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		populateGridSquares();
		addDefenses();
	}
	
	private void populateGridSquares() {
		drone = new Drone(this);
		gridSquares = new ArrayList<List<GridSquare>>();
		
		for (int row = 0; row < rows; row++) {
			gridSquares.add(new ArrayList<GridSquare>());
			for (int column = 0; column < columns; column++) {
				GridSquare gridSquare = new GridSquare(row, column);
				gridSquares.get(row).add(gridSquare);
			}
		}
	}
	
	private void addDefenses() {
		DefenseInterface mine = new Mine();
		DefenseAdderInterface defenseAdder = mine.getDefenseAdder();
		defenseAdder.addDefense(mine, this);
	}
	
	public void scan(int row, int column, Drone drone) {
		GridSquare gridSquare = getGridSquareAt(row, column);
		gridSquare.scan(drone);
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
	
	public List<GridSquare> getAdjacentGridSquares(GridSquare centerSquare, boolean includeCenter) {
		List<GridSquare> adjacentGridSquares = new ArrayList<GridSquare>();
		
		for (int row = centerSquare.getRow()-1; row < centerSquare.getRow()+1; row++) {
			for (int column = centerSquare.getColumn()-1; column < centerSquare.getColumn()+1; column++) {
				GridSquare gridSquare = getGridSquareAt(row, column);
				
				if (!includeCenter || gridSquare == centerSquare)
					continue;
				
				adjacentGridSquares.add(gridSquare);
			}
		}
		
		return adjacentGridSquares;
	}
}
