package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class EMPButton extends HUDButton {
	
	public EMPButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(3, level, vertexBufferObjectManager);
	}

	@Override
	protected void performGameAction() {
		drone.performEMP();
	}

}
