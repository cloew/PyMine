package com.kaottessur.pymine.view.defense.helper;

import java.util.ArrayList;
import java.util.List;

import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class DefenseSpriteManager {
	private static DefenseSpriteManager instance;
	
	private List<DefenseSprite> defenseSprites;
	private List<GridSquareSprite> gridSquareSprites;
	
	static DefenseSpriteManager GetInstance() {
		if (instance == null)
			instance = new DefenseSpriteManager();
		return instance;
	}
	
	public DefenseSpriteManager() {
		defenseSprites = new ArrayList<DefenseSprite>();
		gridSquareSprites = new ArrayList<GridSquareSprite>();
	}
	
	public void addDefense(DefenseSprite defense) {
		defenseSprites.add(defense);
	}
	
	public void addGridSquare(GridSquareSprite gridSquare) {
		gridSquareSprites.add(gridSquare);
	}
}
