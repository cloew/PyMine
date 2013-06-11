package com.kaottessur.pymine.view.hud;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.Button;
import com.kaottessur.pymine.view.SceneManager;

public abstract class HUDButton extends Button {
	public static final int BUTTON_SIZE = 120;
	protected Drone drone;
	protected Level level;
	
	public HUDButton(int row, Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, BUTTON_SIZE*row, BUTTON_SIZE, BUTTON_SIZE, vertexBufferObjectManager);
		this.level = level;
		drone = level.getDrone();
	}
    
	@Override
    protected void performButtonAction() {
    	if (level.finished()) {
    		SceneManager.GetInstance().runLevelSelectionScene();
    	} else {
    		performGameAction();
    	}
    }
    
    protected abstract void performGameAction();
}
