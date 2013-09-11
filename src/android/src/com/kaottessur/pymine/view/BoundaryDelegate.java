package com.kaottessur.pymine.view;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class BoundaryDelegate {
	public static int SQUARES_PER_ROW = 5;
	public static int SQUARES_PER_COLUMN = 4;
	
	private int firstRow = 0;
	private int firstColumn = 0;
	
	public void setGridSquareVisibility(GridSquareSprite gridSquareSprite) {
		gridSquareSprite.setVisible(withinBoundaries(gridSquareSprite.getGridSquare()));
	}
	
	public boolean withinBoundaries(GridSquare gridSquare) {
		return isVisibleRow(gridSquare) && isVisibleColumn(gridSquare);
	}
	
	public boolean isVisibleRow(GridSquare gridSquare) {
		return isVisiblePosition(gridSquare.getRow(), firstRow, SQUARES_PER_ROW);
	}
	
	public boolean isVisibleColumn(GridSquare gridSquare) {
		return isVisiblePosition(gridSquare.getColumn(), firstColumn, SQUARES_PER_COLUMN);
	}
	
	public boolean isVisiblePosition(int dronePosition, int lowestPosition, int size) {
		return (dronePosition >= lowestPosition && dronePosition < lowestPosition+size);
	}
}
