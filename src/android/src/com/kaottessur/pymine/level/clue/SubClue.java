package com.kaottessur.pymine.level.clue;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class SubClue {
	protected boolean reverse = false;
	
	public SubClue() {
		
	}
	
	public void update(Minefield minefield, int gridRow, int gridColumn) {
		
	}
	
	public void updateFromAdjacentSquare(GridSquare gridSquare) {
		
	}
	
	public void reverseReading() {
		reverse = true;
	}
}
