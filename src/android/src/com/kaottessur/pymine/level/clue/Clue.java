package com.kaottessur.pymine.level.clue;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class Clue {
	private AdjacencyClue adjacencyClue;
	private List<SubClue> subClues;
	
	public Clue() {
		subClues = new ArrayList<SubClue>();
		adjacencyClue = new AdjacencyClue();
		subClues.add(adjacencyClue);
	}
	
	public void populate(Minefield minefield, int gridRow, int gridColumn) {
		for (SubClue subClue : subClues)
			subClue.update();
		populateFromAdjacentGridSquares(minefield, gridRow, gridColumn);
	}
	
	public void populateFromAdjacentGridSquares(Minefield minefield, int gridRow, int gridColumn) {
		GridSquare currentSquare = minefield.getGridSquareAt(gridRow, gridColumn);
		
		for (GridSquare gridSquare : minefield.getAdjacentGridSquares(currentSquare, true)) {
			if (gridSquare == currentSquare)
				continue;
			for (SubClue subClue : subClues)
				subClue.updateFromAdjacentSquare(gridSquare);
		}
	}
}
