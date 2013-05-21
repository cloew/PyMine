package com.kaottessur.pymine.view.level;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class LevelScene extends Scene {
	private Level level;
	private MinefieldScene minefieldScene;
	
	private CompletionText wonText;
	
	
	public LevelScene(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.level = level;
		minefieldScene = new MinefieldScene(this, level.getMinefield(), level.getDrone(), vertexBufferObjectManager);
		attachChild(minefieldScene);
		
		wonText = new CompletionText("You Won!", vertexBufferObjectManager);
		attachChild(wonText);
	}
}
