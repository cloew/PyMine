package com.kaottessur.pymine.view.hud;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class PyMineHUD extends HUD {

	public PyMineHUD(VertexBufferObjectManager vertexBUfferObjectManager) {
		super();
		
		final Rectangle left = new Rectangle(680, 0, 120, 120, vertexBUfferObjectManager)
	    {
	        public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
	        {
	            if (touchEvent.isActionUp())
	            {
	                // move player left
	            	System.out.println("Left action called");
	            }
	            return true;
	        };
	    };
	    
	    final Rectangle right = new Rectangle(680, 120, 120, 120, vertexBUfferObjectManager)
	    {
	        public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
	        {
	            if (touchEvent.isActionUp())
	            {
	                // move player right
	            	System.out.println("Right action called");
	            }
	            return true;
	        };
	    };
	    
	    registerTouchArea(left);
	    registerTouchArea(right);
	    attachChild(left);
	    attachChild(right);
	}
}
