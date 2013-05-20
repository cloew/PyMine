package com.kaottessur.pymine.view;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;

public class DroneSprite extends Sprite {
	private Drone drone;
	
	public DroneSprite(Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super(GridPositionHelper.GetXLocation(drone), GridPositionHelper.GetYLocation(drone), 
				TextureWrapper.GetInstance().GetTextureRegion("Drone2.png"), vertexBufferObjectManager);
		setScale(4);
		this.drone = drone;
		registerUpdate();
	}
	
	public void moveTo(GridSquare gridSquare) {
		drone.move(gridSquare.getRow(), gridSquare.getColumn());
		setPosition(GridPositionHelper.GetXLocation(drone), GridPositionHelper.GetYLocation(drone));
	}
	
	private void registerUpdate() {
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				setPosition(GridPositionHelper.GetXLocation(drone), GridPositionHelper.GetYLocation(drone));
			}
		});
	}
	
	public Drone getDrone() {
		return drone;
	}
}
