package com.kaottessur.pymine.view.hud.drone.movement;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.hud.HUDButton;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class RightArrowButton extends HUDButton {

	public RightArrowButton(float x, float y, Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y, level, TextureWrapper.GetInstance().getLeftMovementButtonTexture(), vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		drone.moveRight();
	}

}
