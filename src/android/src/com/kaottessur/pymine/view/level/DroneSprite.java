package com.kaottessur.pymine.view.level;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.BoundaryDelegate;
import com.kaottessur.pymine.view.GridPositionHelper;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class DroneSprite extends Sprite {
	private BoundaryDelegate boundaryDelegate;
	private Drone drone;
	
	public DroneSprite(Drone drone, BoundaryDelegate boundaryDelegate) {
		super(GridPositionHelper.GetXLocation(drone, boundaryDelegate), GridPositionHelper.GetYLocation(drone, boundaryDelegate), 
				TextureWrapper.GetInstance().GetTextureRegion("Drone2.png"), SceneManager.GetVertexBufferObjectManager());
		this.drone = drone;
		registerUpdate();
		setAlpha(.5f);
		this.boundaryDelegate = boundaryDelegate;
	}
	
	public void moveTo(GridSquare gridSquare) {
		drone.move(gridSquare.getRow(), gridSquare.getColumn());
		boundaryDelegate.updateBoundary(drone);
		setPosition(GridPositionHelper.GetXLocation(drone, boundaryDelegate), GridPositionHelper.GetYLocation(drone, boundaryDelegate));
	}
	
	private void registerUpdate() {
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				updatePositionAndVisibility();
			}
		});
	}
	
	public Drone getDrone() {
		return drone;
	}
	
	private void updatePositionAndVisibility() {
		boundaryDelegate.setSpriteVisibility(this);
		setX(GridPositionHelper.GetXLocation(drone, boundaryDelegate));
		setY(GridPositionHelper.GetYLocation(drone, boundaryDelegate));
	}
}
