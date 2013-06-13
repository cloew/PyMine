package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class DefuseCarefullyButton extends DroneActionButton {

	public DefuseCarefullyButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(2, level, TextureWrapper.GetInstance().getDefuseCarefullyButtonTexture(), vertexBufferObjectManager);
	}
	
	@Override
	protected void performGameAction() {
		drone.defuseCarefully();
	}

}
