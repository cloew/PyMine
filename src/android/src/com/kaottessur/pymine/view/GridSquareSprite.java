package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.GridSquare;

public class GridSquareSprite extends Sprite {
	private DroneSprite droneSprite;
	private GridSquare gridSquare;

	public GridSquareSprite(VertexBufferObjectManager vertexBufferObjectManager, DroneSprite droneSprite, GridSquare gridSquare) {
		super(GridPositionHelper.GetXLocation(gridSquare), GridPositionHelper.GetYLocation(gridSquare), 
				TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"), vertexBufferObjectManager);
		setScale(4);
		this.droneSprite = droneSprite;
		this.gridSquare = gridSquare;
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
		setProperTexture();
        droneSprite.moveTo(gridSquare);
        return true;
    }
	
	private void setProperTexture() {
		if (gridSquare.isScanned())
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("ScannedGridSquare.png"));
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"));
        gridSquare.scan();
	}
}
