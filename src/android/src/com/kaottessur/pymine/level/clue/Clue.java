package com.kaottessur.pymine.level.clue;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;

public class Clue {
	private AdjacencyClue adjacencyClue;
	private FragilityClue fragilityClue;
	private WeaponCautionClue weaponCautionClue;
	private List<SubClue> subClues;
	
	public Clue() {
		subClues = new ArrayList<SubClue>();
		adjacencyClue = new AdjacencyClue();
		fragilityClue = new FragilityClue();
		weaponCautionClue = new WeaponCautionClue();
		
		subClues.add(adjacencyClue);
		subClues.add(fragilityClue);
		subClues.add(weaponCautionClue);
	}
	
	public void populate(Minefield minefield, int gridRow, int gridColumn) {
		for (SubClue subClue : subClues)
			subClue.update(minefield, gridRow, gridColumn);
		populateFromAdjacentGridSquares(minefield, gridRow, gridColumn);
	}
	
	public void populateFromAdjacentGridSquares(Minefield minefield, int gridRow, int gridColumn) {
		GridSquare currentSquare = minefield.getGridSquareAt(gridRow, gridColumn);
		
		for (GridSquare gridSquare : minefield.getAdjacentGridSquares(currentSquare, true)) {
			if (gridSquare.reversed()) {
				for (SubClue subClue : subClues)
					subClue.reverseReading();
			}
			if (gridSquare == currentSquare)
				continue;
			for (SubClue subClue : subClues)
				subClue.updateFromAdjacentSquare(gridSquare);
		}
	}
	
	public AdjacencyClue getAdjacencyClue() {
		return adjacencyClue;
	}
	
	public FragilityClue getFragilityClue() {
		return fragilityClue;
	}
	
	public WeaponCautionClue getWeaponCautionClue() {
		return weaponCautionClue;
	}
}
