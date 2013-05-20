package com.kaottessur.pymine.view.hud;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;

public class PyMineHUD extends HUD {

	public PyMineHUD(final Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		ScanButton scanButton = new ScanButton(drone, vertexBufferObjectManager);
		DefuseButton defuseButton = new DefuseButton(drone, vertexBufferObjectManager);
	    
	    registerTouchArea(scanButton);
	    registerTouchArea(defuseButton);
	    attachChild(scanButton);
	    attachChild(defuseButton);
	}
}
