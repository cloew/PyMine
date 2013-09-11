package com.kaottessur.pymine.view;

import com.kaottessur.pymine.GridLocationInterface;

public class GridPositionHelper {
	public static final int X_OFFSET = 32;
	public static final int Y_OFFSET = 32;
	
	public static final int X_SIZE = 64;
	public static final int Y_SIZE = 64;
	
	public static float GetXLocation(GridLocationInterface gridLocation, BoundaryDelegate boundaryDelegate) {
		int column = boundaryDelegate.getVisibleColumn(gridLocation);
		return X_OFFSET + column*X_SIZE;
	}
	
	public static float GetYLocation(GridLocationInterface gridLocation, BoundaryDelegate boundaryDelegate) {
		int row = boundaryDelegate.getVisibleRow(gridLocation);
		return Y_OFFSET + row*Y_SIZE;
	}
}
