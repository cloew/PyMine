package com.kaottessur.pymine.view.hud;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;

public class PyMineHUD extends HUD {

	public PyMineHUD(final Drone drone, VertexBufferObjectManager vertexBUfferObjectManager) {
		super();
		
		final Rectangle left = new Rectangle(680, 0, 120, 120, vertexBUfferObjectManager)
	    {
	        public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
	        {
	            if (touchEvent.isActionUp())
	            {
	            	drone.scan();
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
            		drone.defuse();
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
