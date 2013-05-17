package com.kaottessur.pymine.view;

import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class MinefieldScene extends Scene {
	private DroneSprite droneSprite;
	final static int ROWS = 4;
	final static int COLUMNS = 5;
	
	MinefieldScene(VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		
		droneSprite = new DroneSprite(32, 32, vertexBufferObjectManager);

		for (int row = 0; row < ROWS; row++) {
			for (int column = 0; column < COLUMNS; column++) {
				GridSquareSprite gridSquareSprite = new GridSquareSprite(32+(column*64), 32+(row*64), vertexBufferObjectManager, droneSprite);
				attachChild(gridSquareSprite);
				registerTouchArea(gridSquareSprite);
			}
		}
		attachChild(droneSprite);
	}
}
