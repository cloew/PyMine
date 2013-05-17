package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class DroneSprite extends Sprite {
	
	
	public DroneSprite(float x, float y, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y, TextureWrapper.GetInstance().GetTextureRegion("Drone2.png"), vertexBufferObjectManager);
		setScale(4);
	}
}
