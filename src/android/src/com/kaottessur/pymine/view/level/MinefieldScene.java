package com.kaottessur.pymine.view.level;

import org.andengine.entity.scene.Scene;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;
import com.kaottessur.pymine.view.BoundaryDelegate;

public class MinefieldScene extends Scene {
	private BoundaryDelegate boundaryDelegate;
	private DroneSprite droneSprite;
	private Minefield minefield;
	
	public MinefieldScene(Scene parent, Minefield minefield, Drone drone) {
		super();
		
		this.minefield = minefield;
		boundaryDelegate = new BoundaryDelegate();
		droneSprite = new DroneSprite(drone, boundaryDelegate);

		for (int row = 0; row < this.minefield.getRowCount(); row++) {
			for (int column = 0; column < this.minefield.getColumnCount(); column++) {
				GridSquareSprite gridSquareSprite = new GridSquareSprite(droneSprite, minefield.getGridSquareAt(row, column), minefield, boundaryDelegate);
				attachChild(gridSquareSprite);
				parent.registerTouchArea(gridSquareSprite);
			}
		}
		attachChild(droneSprite);
	}
}
