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
	    
	    final Rectangle right = new Rectangle(680, 120, 120, 120, vertexBufferObjectManager)
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
	    
	    scanButton.setColor(.5f, .5f, .5f);
	    right.setColor(.5f, .5f, .5f);
	    
	    registerTouchArea(scanButton);
	    registerTouchArea(right);
	    attachChild(scanButton);
	    attachChild(right);
	}
}
