package com.kaottessur.pymine.level.clue;

import com.kaottessur.pymine.level.GridSquare;

public class AdjacencyClue extends SubClue {
	private int numberOfAdjacentMines = 0;
	
	public AdjacencyClue() {
		
	}
	
	public void update() {
		numberOfAdjacentMines = 0;
	}
	
	public void updateFromAdjacentSquare(GridSquare gridSquare) {
		if (gridSquare.mined()) {
			numberOfAdjacentMines++;
		}
	}
	
	public int getClueReading() {
		return numberOfAdjacentMines;
	}
}
