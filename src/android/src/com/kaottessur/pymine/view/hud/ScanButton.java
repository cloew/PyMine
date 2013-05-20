package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;

public class ScanButton extends HUDButton {

	public ScanButton(Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, drone, vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
		drone.scan();
	}

}
