package com.kaottessur.pymine.view.hud;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;

public abstract class HUDButton extends Rectangle {
	protected Drone drone;
	
	public HUDButton(float y, Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, y, 120, 120, vertexBufferObjectManager);
		this.drone = drone;
	}
	
	@Override
	public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
    {
        if (touchEvent.isActionUp())
        {
        	performButtonAction();
        }
        return true;
    };
    
    protected abstract void performButtonAction();
}
