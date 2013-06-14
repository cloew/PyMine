package com.kaottessur.pymine.view.hud.drone.action;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.hud.HUDButton;
import com.kaottessur.pymine.view.texture.ButtonTexture;

public abstract class DroneActionButton extends HUDButton {
	public static final int BUTTON_SIZE = 120;

	public DroneActionButton(int row, Level level, ButtonTexture buttonTexture, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, BUTTON_SIZE*row, level, buttonTexture, vertexBufferObjectManager);
	}

	@Override
	protected void performButtonAction() {
    	if (level.finished()) {
    		level.reset();
    		SceneManager.GetInstance().runLevelSelectionScene();
    	} else {
    		performGameAction();
    	}
    }
	
	protected abstract void performGameAction();
}
