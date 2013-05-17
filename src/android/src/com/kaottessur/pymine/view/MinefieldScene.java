package com.kaottessur.pymine.view;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Minefield;

public class MinefieldScene extends Scene {
	private DroneSprite droneSprite;
	private Minefield minefield;
	
	MinefieldScene(Minefield minefield, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		this.minefield = minefield;
		droneSprite = new DroneSprite(32, 32, vertexBufferObjectManager);

		for (int row = 0; row < this.minefield.getRowCount(); row++) {
			for (int column = 0; column < this.minefield.getColumnCount(); column++) {
				GridSquareSprite gridSquareSprite = new GridSquareSprite(32+(column*64), 32+(row*64), vertexBufferObjectManager, droneSprite);
				attachChild(gridSquareSprite);
				registerTouchArea(gridSquareSprite);
			}
		}
		attachChild(droneSprite);
	}
}
