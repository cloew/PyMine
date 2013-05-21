package com.kaottessur.pymine.view.level;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;

public class MinefieldScene extends Scene {
	private DroneSprite droneSprite;
	private Minefield minefield;
	
	public MinefieldScene(Minefield minefield, Drone drone, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.minefield = minefield;
		droneSprite = new DroneSprite(drone, vertexBufferObjectManager);

		for (int row = 0; row < this.minefield.getRowCount(); row++) {
			for (int column = 0; column < this.minefield.getColumnCount(); column++) {
				GridSquareSprite gridSquareSprite = new GridSquareSprite(vertexBufferObjectManager, droneSprite, minefield.getGridSquareAt(row, column));
				attachChild(gridSquareSprite);
				registerTouchArea(gridSquareSprite);
			}
		}
		attachChild(droneSprite);
	}
}
