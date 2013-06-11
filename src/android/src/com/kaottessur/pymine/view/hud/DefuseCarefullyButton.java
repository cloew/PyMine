package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class DefuseCarefullyButton extends HUDButton {

	public DefuseCarefullyButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(2, level, vertexBufferObjectManager);
	}
	
	@Override
	protected void performGameAction() {
		drone.defuseCarefully();
	}

}
