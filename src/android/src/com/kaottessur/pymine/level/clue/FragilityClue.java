package com.kaottessur.pymine.level.clue;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class FragilityClue extends SubClue {
	private int distance = -1;
	
	public FragilityClue() {
		
	}
	
	public int getDistance() {
		return distance;
	}
	
	@Override
	public void update(Minefield minefield, int gridRow, int gridColumn) {
		distance = -1;
		System.out.println("Updating Fragility Clue");
		
		for (int row = 0; row < minefield.getRowCount(); row++) {
			for (int column = 0; column < minefield.getColumnCount(); column++) {
				GridSquare square = minefield.getGridSquareAt(row, column);
				if (square.isFragile())
				{
					System.out.println("Found a fragile square");
					int rowDistance = Math.abs(square.getRow()-gridRow);
					int columnDistance = Math.abs(square.getColumn()-gridColumn);
					int adjacencyDistance = getAdjacencyDistance(rowDistance, columnDistance);
					if (distance < adjacencyDistance)
						distance = adjacencyDistance;
				}
			}
		}
		
		System.out.println(String.format("Distance at Row: %d and Column: %d is %d", gridRow, gridColumn, distance));
	}
	
	private int getAdjacencyDistance(int rowDistance, int columnDistance) {
		if (rowDistance < columnDistance)
			return columnDistance;
		else
			return rowDistance;
	}
}
