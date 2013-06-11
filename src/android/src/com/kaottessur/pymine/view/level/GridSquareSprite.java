package com.kaottessur.pymine.view.level;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.GridPositionHelper;
import com.kaottessur.pymine.view.TextureWrapper;
import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.level.clue.ClueView;

public class GridSquareSprite extends Sprite {
	private DroneSprite droneSprite;
	private GridSquare gridSquare;
	
	private DefenseSprite defenseSprite = null;
	private ClueView clueView;
	
	private final static String GRID_SQUARE_IMAGE_FILENAME = "GridSquare.png";
	private final static String SCANNED_GRID_SQUARE_IMAGE_FILENAME = "ScannedGridSquare.png";

	public GridSquareSprite(VertexBufferObjectManager vertexBufferObjectManager, DroneSprite droneSprite, GridSquare gridSquare) {
		super(GridPositionHelper.GetXLocation(gridSquare), GridPositionHelper.GetYLocation(gridSquare), 
				TextureWrapper.GetInstance().GetTextureRegion(GRID_SQUARE_IMAGE_FILENAME), vertexBufferObjectManager);
		//setScale(4);
		this.droneSprite = droneSprite;
		this.gridSquare = gridSquare;
		
		clueView = new ClueView(gridSquare.getClue(), getVertexBufferObjectManager());
		attachChild(clueView);
		registerUpdate();
		
	}
	
	private void registerUpdate() {
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				setProperTexture();
				if (defenseSprite != null && gridSquare.isScanned())
					defenseSprite.setVisible(true);
			}
		});
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		if (touchEvent.isActionDown() ) {
			droneSprite.getDrone().tryToMove(gridSquare);
		}
        return true;
    }
	
	private void setProperTexture() {
		if (gridSquare.isScanned())
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(SCANNED_GRID_SQUARE_IMAGE_FILENAME));
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(GRID_SQUARE_IMAGE_FILENAME));
	}

	public GridSquare getGridSquare() {
		return gridSquare;
	}
}
