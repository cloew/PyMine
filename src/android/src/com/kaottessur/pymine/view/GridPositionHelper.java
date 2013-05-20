package com.kaottessur.pymine.view;

import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.TextureManager;

import android.graphics.Typeface;

import com.kaottessur.pymine.GridLocationInterface;

public class GridPositionHelper {
	public static final int X_OFFSET = 32;
	public static final int Y_OFFSET = 32;
	
	public static final int X_SIZE = 64;
	public static final int Y_SIZE = 64;
	
	static float GetXLocation(GridLocationInterface gridLocation) {
		return X_OFFSET + gridLocation.getColumn()*X_SIZE;
	}
	
	static float GetYLocation(GridLocationInterface gridLocation) {
		return Y_OFFSET + gridLocation.getRow()*Y_SIZE;
	}
}
