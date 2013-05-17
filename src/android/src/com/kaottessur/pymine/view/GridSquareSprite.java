package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class GridSquareSprite extends Sprite {
	private boolean scanned = false;
	private DroneSprite droneSprite;

	public GridSquareSprite(float x, float y, VertexBufferObjectManager vertexBufferObjectManager, DroneSprite droneSprite) {
		super(x, y, TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"), vertexBufferObjectManager);
		setScale(4);
		this.droneSprite = droneSprite;
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        if (!scanned)
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("ScannedGridSquare.png"));
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"));
        scanned = !scanned;
        droneSprite.setPosition(getX(), getY());
        return true;
    }
}
