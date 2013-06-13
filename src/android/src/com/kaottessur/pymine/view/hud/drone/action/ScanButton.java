package com.kaottessur.pymine.view.hud.drone.action;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class ScanButton extends DroneActionButton {
	
	public ScanButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, level, TextureWrapper.GetInstance().getScanButtonTexture(), vertexBufferObjectManager);
	}

	@Override
	protected void performGameAction() {
		drone.scan();
	}

}
