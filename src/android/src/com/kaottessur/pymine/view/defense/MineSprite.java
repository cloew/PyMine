package com.kaottessur.pymine.view.defense;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.view.TextureWrapper;

public class MineSprite extends Sprite {
	private Mine mine;
	
	public MineSprite(float x, float y, Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, TextureWrapper.GetInstance().GetTextureRegion("Mine1.png"), vertexBufferObjectManager);
		this.mine = mine;
		setVisible(false);
	}
}
