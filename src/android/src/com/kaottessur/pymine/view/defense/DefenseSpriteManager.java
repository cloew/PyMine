package com.kaottessur.pymine.view.defense;

public class DefenseSpriteManager {
	private static DefenseSpriteManager instance;
	
	public static DefenseSpriteManager GetInstance() {
		if (instance == null)
			instance = new DefenseSpriteManager();
		return instance;
	}
	
	private DefenseSpriteManager() {
		
	}

}
