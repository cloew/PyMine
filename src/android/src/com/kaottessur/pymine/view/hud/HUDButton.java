package com.kaottessur.pymine.view.hud;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.SceneManager;

public abstract class HUDButton extends Rectangle {
	public static final int BUTTON_SIZE = 120;
	protected Drone drone;
	protected Level level;
	
	public HUDButton(float y, Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, y, BUTTON_SIZE, BUTTON_SIZE, vertexBufferObjectManager);
		this.level = level;
		drone = level.getDrone();
		setColor(.5f, .5f, .5f);
	}
	
	@Override
	public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
    {
        if (touchEvent.isActionUp())
        {
        	if (level.finished()) {
        		SceneManager.GetInstance().runLevelSelectionScene();
        	} else {
        		performButtonAction();
        	}
        }
        return true;
    };
    
    protected abstract void performButtonAction();
}
