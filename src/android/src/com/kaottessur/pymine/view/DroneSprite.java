package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;

public class DroneSprite extends Sprite {
	private Drone drone;
	
	public DroneSprite(Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super(GridPositionHelper.GetXLocation(drone), GridPositionHelper.GetYLocation(drone), TextureWrapper.GetInstance().GetTextureRegion("Drone2.png"), vertexBufferObjectManager);
		setScale(4);
		this.drone = drone;
	}
	
	public void moveTo(GridSquare gridSquare) {
		drone.move(gridSquare.getRow(), gridSquare.getColumn());
		setPosition(GridPositionHelper.GetXLocation(drone), GridPositionHelper.GetYLocation(drone));
	}
}
