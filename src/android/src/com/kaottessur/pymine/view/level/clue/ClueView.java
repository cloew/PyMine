package com.kaottessur.pymine.view.level.clue;

import org.andengine.entity.Entity;

import com.kaottessur.pymine.level.clue.Clue;

public class ClueView extends Entity {
	private AdjacencyClueText adjacencyClueText;
		
	public ClueView(Clue clue) {
		super(0, 0);
		adjacencyClueText = new AdjacencyClueText(clue);
		attachChild(adjacencyClueText);
	}
}
