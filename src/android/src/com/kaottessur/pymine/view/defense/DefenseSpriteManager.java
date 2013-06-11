package com.kaottessur.pymine.view.defense;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class DefenseSpriteManager {
	private static DefenseSpriteManager instance;
	private List<DefenseSprite> defenseSprites;
	private List<GridSquareSprite> gridSquareSprites;
	
	public static DefenseSpriteManager GetInstance() {
		if (instance == null)
			instance = new DefenseSpriteManager();
		return instance;
	}
	
	private DefenseSpriteManager() {
		defenseSprites = new ArrayList<DefenseSprite>();
		gridSquareSprites = new ArrayList<GridSquareSprite>();
	}

	
	public void addDefenseSprite(DefenseSprite defenseSprite) {
		defenseSprites.add(defenseSprite);
	}
	
	public void addGridSquareSprite(GridSquareSprite gridSquareSprite) {
		gridSquareSprites.add(gridSquareSprite);
	}
	
	public void updateSpriteConnections() {
		// for each Defense Sprite
		// Find it's corresponding Grid Square Sprite
		// Check that grid Square is showing the Defense Sprite
	}
	
	public void updateSpriteConnection(GridSquare original, GridSquare destination, DefenseSprite defenseSprite) {
		GridSquareSprite originalSprite = findCorrespondingSprite(original);
		GridSquareSprite destinationSprite = findCorrespondingSprite(destination);

		originalSprite.detachChild(defenseSprite);
		destinationSprite.attachChild(defenseSprite);
	}
	
	private GridSquareSprite findCorrespondingSprite(GridSquare gridSquare) {
		for (GridSquareSprite gridSquareSprite : gridSquareSprites)
			if (gridSquareSprite.getGridSquare() == gridSquare)
				return gridSquareSprite;
		return gridSquareSprites.get(0);
	}
}
