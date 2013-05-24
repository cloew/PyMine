package com.kaottessur.pymine.view;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public abstract class Button extends Rectangle {

	public Button(float x, float y, float width, float height, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y, width, height, vertexBufferObjectManager);
		setColor(.5f, .5f, .5f);
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
