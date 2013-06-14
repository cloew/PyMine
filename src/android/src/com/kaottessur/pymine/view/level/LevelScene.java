package com.kaottessur.pymine.view.level;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.defense.status.DefenseStatusEntity;

public class LevelScene extends Scene {
	private Level level;
	private MinefieldScene minefieldScene;
	
	private CompletionText wonText;
	private CompletionText lostText;
	
	private DefenseStatusEntity defenseStatusEntity;
	
	
	public LevelScene(Level level) {
		super();
		
		this.level = level;
		level.reset();
		minefieldScene = new MinefieldScene(this, level.getMinefield(), level.getDrone());
		attachChild(minefieldScene);
		
		wonText = new CompletionText("You Won!");
		attachChild(wonText);
		lostText = new CompletionText("Game Over");
		attachChild(lostText);
		
		defenseStatusEntity = new DefenseStatusEntity(6*64, 0, level);
		attachChild(defenseStatusEntity);
		
		registerUpdate();
	}
		
	private void registerUpdate() {	
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				if (level.won())
					wonText.setVisible(true);
				else if (level.lost())
				{
					lostText.setVisible(true);
					level.revealDefenses();
				}
			}
		});
	}
}
