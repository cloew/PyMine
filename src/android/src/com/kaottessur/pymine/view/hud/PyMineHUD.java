package com.kaottessur.pymine.view.hud;

import java.util.ArrayList;
import java.util.List;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;

public class PyMineHUD extends HUD {

	public PyMineHUD(final Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		List<HUDButton> hudButtons = new ArrayList<HUDButton>();
		hudButtons.add(new ScanButton(level, vertexBufferObjectManager));
		hudButtons.add(new DefuseButton(level, vertexBufferObjectManager));
		hudButtons.add(new DefuseCarefullyButton(level, vertexBufferObjectManager));
		hudButtons.add(new EMPButton(level, vertexBufferObjectManager));
		
		
		for (HUDButton hudButton : hudButtons) {
			registerTouchArea(hudButton);
			attachChild(hudButton);
		}
	}
}
