package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class DroneSprite extends Sprite {
	
	
	public DroneSprite(VertexBufferObjectManager vertexBufferObjectManager) {
		super(32, 32, TextureWrapper.GetInstance().GetTextureRegion("Drone2.png"), vertexBufferObjectManager);
		setScale(4);
	}
}
