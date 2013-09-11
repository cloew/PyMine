package com.kaottessur.pymine.view.hud.drone.movement;

import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.BoundaryDelegate;
import com.kaottessur.pymine.view.hud.HUDButton;
import com.kaottessur.pymine.view.texture.ButtonTexture;

public abstract class MovementButton extends HUDButton {
	private BoundaryDelegate boundaryDelegate;
	
	public MovementButton(float x, float y, Level level,
			ButtonTexture buttonTexture,
			VertexBufferObjectManager vertexBufferObjectManager, BoundaryDelegate boundaryDelegate) {
		super(x, y, level, buttonTexture, vertexBufferObjectManager);
		this.boundaryDelegate = boundaryDelegate;
	}

	@Override
	protected void performButtonAction() {
		// Do Nothing
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		if (touchEvent.isActionDown() ) {
			move();
			boundaryDelegate.updateBoundary(drone);
		}
		return super.onAreaTouched(touchEvent, x, y);
    }
	
	protected abstract void move(); 

}
