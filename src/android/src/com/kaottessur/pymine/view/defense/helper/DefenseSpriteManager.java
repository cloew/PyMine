package com.kaottessur.pymine.view.defense.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class DefenseSpriteManager {
	private static DefenseSpriteManager instance;
	
	private List<DefenseSprite> defenseSprites;
	private Map<GridSquare, GridSquareSprite> gridSquareSprites;
	
	public static DefenseSpriteManager GetInstance() {
		if (instance == null)
			instance = new DefenseSpriteManager();
		return instance;
	}
	
	public DefenseSpriteManager() {
		defenseSprites = new ArrayList<DefenseSprite>();
		gridSquareSprites = new HashMap<GridSquare, GridSquareSprite>();
	}
	
	public void addDefense(DefenseSprite defenseSprite) {
		defenseSprites.add(defenseSprite);
	}
	
	public void addGridSquare(GridSquareSprite gridSquareSprite) {
		gridSquareSprites.put(gridSquareSprite.getGridSquare(), gridSquareSprite);
	}
	
	public void moveDefenseToNewGridSquare(final DefenseSprite defenseSprite, final GridSquare original, final GridSquare destination) {
		if (original != destination && gridSquareSprites.containsKey(original) && gridSquareSprites.containsKey(destination)) {
			SceneManager.RunOnUIThread(new Runnable() {
				
				@Override
				public void run() {
					GridSquareSprite originalSprite = gridSquareSprites.get(original);
					GridSquareSprite destinationSprite = gridSquareSprites.get(destination);
					
					originalSprite.detachChild(defenseSprite);
					destinationSprite.attachChild(defenseSprite);
				}
			});
		}
	}
}
