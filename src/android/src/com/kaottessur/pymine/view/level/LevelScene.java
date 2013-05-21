package com.kaottessur.pymine.view.level;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.TextureWrapper;

public class LevelScene extends Scene {
	private Level level;
	private MinefieldScene minefieldScene;
	
	
	public LevelScene(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.level = level;
		minefieldScene = new MinefieldScene(this, level.getMinefield(), level.getDrone(), vertexBufferObjectManager);
		attachChild(minefieldScene);
		/*Text wonText = new Text(0, 0,TextureWrapper.GetInstance().GetCompletionFont(), 
				"You Won!", vertexBufferObjectManager);
		wonText.setVisible(false);
		attachChild(wonText);*/
	}
}
