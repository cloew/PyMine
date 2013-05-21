package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class DefuseButton extends HUDButton {

	public DefuseButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(BUTTON_SIZE, level, vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		drone.defuse();
	}

}
