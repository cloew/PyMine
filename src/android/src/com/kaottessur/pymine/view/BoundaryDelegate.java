package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;

import com.kaottessur.pymine.GridLocationInterface;
import com.kaottessur.pymine.level.Minefield;
import com.kaottessur.pymine.view.level.DroneSprite;
import com.kaottessur.pymine.view.level.GridSquareSprite;

public class BoundaryDelegate {
	public static int SQUARES_PER_ROW = 5;
	public static int SQUARES_PER_COLUMN = 4;
	
	private int firstRow = 0;
	private int firstColumn = 0;
	
	private Minefield minefield;
	
	public BoundaryDelegate(Minefield minefield) {
		this.minefield = minefield;
	}
	
	public void updateBoundary(GridLocationInterface gridLocation) {
		System.out.println("Updating Boundary");
		int row = gridLocation.getRow();
		int column = gridLocation.getColumn();
		
		updateRow(row);
		updateColumn(column);
	}
	
	public void updateRow(int row) {
		if (lower(row, firstRow)) {
			System.out.println("Moving Row Up");
			firstRow = row-1;
		}
		
		if (upper(row, firstRow+SQUARES_PER_COLUMN, minefield.getRowCount())) {
			System.out.println("Moving Row Down");
			firstRow += 1;
		}
	}
	
	public void updateColumn(int column) {
		if (lower(column, firstColumn)) {
			System.out.println("Moving Column Left");
			firstColumn -= 1;
		}
		
		if (upper(column, firstColumn+SQUARES_PER_ROW, minefield.getColumnCount())) {
			System.out.println("Moving Column Right");
			firstColumn += 1;
		}
	}
	
	public boolean lower(int position, int front) {
		return (position == front && front > 0);
	}
	
	public boolean upper(int position, int back, int size) {
		return (position == back-1 && size-back+1 > 0);
	}
	
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
		return isVisiblePosition(gridLocation.getRow(), firstRow, SQUARES_PER_COLUMN);
	}
	
	public boolean isVisibleColumn(GridLocationInterface gridLocation) {
		return isVisiblePosition(gridLocation.getColumn(), firstColumn, SQUARES_PER_ROW);
	}
	
	public boolean isVisiblePosition(int dronePosition, int lowestPosition, int size) {
		return (dronePosition >= lowestPosition && dronePosition < lowestPosition+size);
	}
}
