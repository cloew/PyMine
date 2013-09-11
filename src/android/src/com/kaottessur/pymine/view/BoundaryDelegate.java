package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;

import com.kaottessur.pymine.GridLocationInterface;
import com.kaottessur.pymine.view.level.DroneSprite;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class BoundaryDelegate {
	public static int SQUARES_PER_ROW = 5;
	public static int SQUARES_PER_COLUMN = 4;
	
	private int firstRow = 0;
	private int firstColumn = 0;
	
	public int getVisibleRow(GridLocationInterface gridLocation) {
		return gridLocation.getRow() - firstRow;
	}
	
	public int getVisibleColumn(GridLocationInterface gridLocation) {
		return gridLocation.getColumn() - firstColumn;
	}
	
	public void setSpriteVisibility(GridSquareSprite sprite) {
		setSpriteVisibility(sprite, sprite.getGridSquare());
	}
	
	public void setSpriteVisibility(DroneSprite sprite) {
		setSpriteVisibility(sprite, sprite.getDrone());
	}
	
	public void setSpriteVisibility(Sprite sprite, GridLocationInterface gridLocation) {
		sprite.setVisible(withinBoundaries(gridLocation));
	}
	
	public boolean withinBoundaries(GridLocationInterface gridLocation) {
		return isVisibleRow(gridLocation) && isVisibleColumn(gridLocation);
	}
	
	public boolean isVisibleRow(GridLocationInterface gridLocation) {
		return isVisiblePosition(gridLocation.getRow(), firstRow, SQUARES_PER_ROW);
	}
	
	public boolean isVisibleColumn(GridLocationInterface gridLocation) {
		return isVisiblePosition(gridLocation.getColumn(), firstColumn, SQUARES_PER_COLUMN);
	}
	
	public boolean isVisiblePosition(int dronePosition, int lowestPosition, int size) {
		return (dronePosition >= lowestPosition && dronePosition < lowestPosition+size);
	}
}
