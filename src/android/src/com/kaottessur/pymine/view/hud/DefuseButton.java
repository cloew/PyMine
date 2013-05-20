package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;

public class DefuseButton extends HUDButton {

	public DefuseButton(Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super(BUTTON_SIZE, drone, vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		drone.defuse();
	}

}
