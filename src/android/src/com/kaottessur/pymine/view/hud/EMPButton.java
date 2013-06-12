package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.TextureWrapper;

public class EMPButton extends HUDButton {
	
	public EMPButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(3, level, TextureWrapper.GetInstance().getEMPButtonTexture(), vertexBufferObjectManager);
	}

	@Override
	protected void performGameAction() {
		drone.performEMP();
	}

}
