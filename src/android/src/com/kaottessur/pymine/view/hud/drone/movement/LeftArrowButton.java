package com.kaottessur.pymine.view.hud.drone.movement;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.BoundaryDelegate;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class LeftArrowButton extends MovementButton {

	public LeftArrowButton(float x, float y, Level level, VertexBufferObjectManager vertexBufferObjectManager, BoundaryDelegate boundaryDelegate) {
		super(x, y, level, TextureWrapper.GetInstance().getLeftMovementButtonTexture(), vertexBufferObjectManager, boundaryDelegate);
	}

	@Override
	protected void move() {
		drone.moveLeft();
	}
}
