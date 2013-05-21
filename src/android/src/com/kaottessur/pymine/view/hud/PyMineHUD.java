package com.kaottessur.pymine.view.hud;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class PyMineHUD extends HUD {

	public PyMineHUD(final Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		ScanButton scanButton = new ScanButton(level, vertexBufferObjectManager);
		DefuseButton defuseButton = new DefuseButton(level, vertexBufferObjectManager);
	    
	    registerTouchArea(scanButton);
	    registerTouchArea(defuseButton);
	    attachChild(scanButton);
	    attachChild(defuseButton);
	}
}
