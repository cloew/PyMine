package com.kaottessur.pymine.view.hud.drone.action;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class DefuseButton extends DroneActionButton {

	public DefuseButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(1, level, TextureWrapper.GetInstance().getDefuseButtonTexture(), vertexBufferObjectManager);
	}

	@Override
	protected void performGameAction() {
		drone.defuse();
	}

}
