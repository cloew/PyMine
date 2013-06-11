package com.kaottessur.pymine.view.level;

import java.util.ArrayList;
import java.util.List;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.defense.DefenseViewFactory;

public class LevelScene extends Scene {
	private Level level;
	private MinefieldScene minefieldScene;
	private List<DefenseSprite> defenseSprites;
	
	private CompletionText wonText;
	private CompletionText lostText;
	
	
	public LevelScene(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.level = level;
		level.reset();
		minefieldScene = new MinefieldScene(this, level.getMinefield(), level.getDrone(), vertexBufferObjectManager);
		attachChild(minefieldScene);
		addDefenseSprites(vertexBufferObjectManager);
		
		wonText = new CompletionText("You Won!", vertexBufferObjectManager);
		attachChild(wonText);
		lostText = new CompletionText("Game Over", vertexBufferObjectManager);
		attachChild(lostText);
		registerUpdate();
	}
	
	private void addDefenseSprites(VertexBufferObjectManager vertexBufferObjectManager) {
		defenseSprites = new ArrayList<DefenseSprite>();
		
		for (DefenseInterface defense : level.getDefenses()) {
			DefenseSprite defenseSprite = DefenseViewFactory.getDefenseView(defense, level.getDrone(), level.getMinefield(), vertexBufferObjectManager);
			defenseSprites.add(defenseSprite);
			attachChild(defenseSprite);
		}
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
