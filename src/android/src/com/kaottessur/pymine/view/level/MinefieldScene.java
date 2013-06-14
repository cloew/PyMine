package com.kaottessur.pymine.view.level;

import org.andengine.entity.scene.Scene;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;

public class MinefieldScene extends Scene {
	private DroneSprite droneSprite;
	private Minefield minefield;
	
	public MinefieldScene(Scene parent, Minefield minefield, Drone drone) {
		super();
		
		this.minefield = minefield;
		droneSprite = new DroneSprite(drone);

		for (int row = 0; row < this.minefield.getRowCount(); row++) {
			for (int column = 0; column < this.minefield.getColumnCount(); column++) {
				GridSquareSprite gridSquareSprite = new GridSquareSprite(droneSprite, minefield.getGridSquareAt(row, column), minefield);
				attachChild(gridSquareSprite);
				parent.registerTouchArea(gridSquareSprite);
			}
		}
		attachChild(droneSprite);
	}
}
