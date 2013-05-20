package com.kaottessur.pymine.view;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.view.defense.MineSprite;
import com.kaottessur.pymine.view.level.clue.ClueView;

public class GridSquareSprite extends Sprite {
	private DroneSprite droneSprite;
	private GridSquare gridSquare;
	
	private MineSprite mineSprite;
	private ClueView clueView;

	public GridSquareSprite(VertexBufferObjectManager vertexBufferObjectManager, DroneSprite droneSprite, GridSquare gridSquare) {
		super(GridPositionHelper.GetXLocation(gridSquare), GridPositionHelper.GetYLocation(gridSquare), 
				TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"), vertexBufferObjectManager);
		setScale(4);
		this.droneSprite = droneSprite;
		this.gridSquare = gridSquare;
		if (gridSquare.hasDefense()) {
			mineSprite = new MineSprite((Mine) gridSquare.getDefense(), vertexBufferObjectManager);
			attachChild(mineSprite);
		}
		
		clueView = new ClueView(gridSquare.getClue(), TextureWrapper.GetInstance().GetGameFont(), getVertexBufferObjectManager());
		attachChild(clueView);
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		if (touchEvent.isActionUp() ) {
			droneSprite.moveTo(gridSquare);
			setProperTexture();
		}
        return true;
    }
	
	private void setProperTexture() {
		if (gridSquare.isScanned())
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("ScannedGridSquare.png"));
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("GridSquare.png"));
        gridSquare.scan(droneSprite.getDrone());
        if (mineSprite != null)
        	mineSprite.setVisible(true);
	}
}
