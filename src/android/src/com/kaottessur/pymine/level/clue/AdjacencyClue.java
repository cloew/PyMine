package com.kaottessur.pymine.level.clue;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class AdjacencyClue extends SubClue {
	private int numberOfAdjacentMines = 0;
	
	public AdjacencyClue() {
		
	}
	
	@Override
	public void update(Minefield minefield, int gridRow, int gridColumn) {
		numberOfAdjacentMines = 0;
	}
	
	@Override
	public void updateFromAdjacentSquare(GridSquare gridSquare) {
		if (gridSquare.mined()) {
			numberOfAdjacentMines++;
		}
	}
	
	public int getClueReading() {
		if (reverse)
			return 8-numberOfAdjacentMines;
		else
			return numberOfAdjacentMines;
	}
}
