package com.kaottessur.pymine.level.clue;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class FragilityClue extends SubClue {
	private int distance = -1;
	@SuppressLint("UseSparseArrays")
	private Map<Integer, Integer> distances = new HashMap<Integer, Integer>(); 
	
	public FragilityClue() {
		
	}
	
	public int getDistance() {
		return distance;
	}
	
	/**
	 * 
	 * @return Number of Fragile Defenses at the Clue's smallest distance
	 */
	public int getCount() {
		if (distance != -1) {
			return distances.get(distance);
		}
		else {
			return 0;
		}
	}
	
	@Override
	public void update(Minefield minefield, int gridRow, int gridColumn) {
		distance = -1;
	
		for (int row = 0; row < minefield.getRowCount(); row++) {
			for (int column = 0; column < minefield.getColumnCount(); column++) {
				GridSquare square = minefield.getGridSquareAt(row, column);
				if (square.isFragile())
				{
					int rowDistance = Math.abs(square.getRow()-gridRow);
					int columnDistance = Math.abs(square.getColumn()-gridColumn);
					int adjacencyDistance = getAdjacencyDistance(rowDistance, columnDistance);
					
					if (distances.containsKey(adjacencyDistance)) {
						int count = distances.get(adjacencyDistance);
						distances.put(adjacencyDistance, count+1);
					}
					else {
						distances.put(adjacencyDistance, 1);
					}
					
					if (distance == -1 || adjacencyDistance < distance)
						distance = adjacencyDistance;
				}
			}
		}
	}
	
	private int getAdjacencyDistance(int rowDistance, int columnDistance) {
		if (rowDistance < columnDistance)
			return columnDistance;
		else
			return rowDistance;
	}
}
