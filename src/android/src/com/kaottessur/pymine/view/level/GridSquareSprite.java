package com.kaottessur.pymine.view.level;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;
import com.kaottessur.pymine.view.BoundaryDelegate;
import com.kaottessur.pymine.view.GridPositionHelper;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;
import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.defense.helper.DefenseSpriteManager;
import com.kaottessur.pymine.view.defense.helper.DefenseViewFactory;
import com.kaottessur.pymine.view.level.clue.ClueView;

public class GridSquareSprite extends Sprite {
	private BoundaryDelegate boundaryDelegate;
	private DroneSprite droneSprite;
	private GridSquare gridSquare;
	
	private DefenseSprite defenseSprite = null;
	private ClueView clueView;
	
	private final static String GRID_SQUARE_IMAGE_FILENAME = "GridSquare.png";
	private final static String SCANNED_GRID_SQUARE_IMAGE_FILENAME = "ScannedGridSquare.png";

	public GridSquareSprite(DroneSprite droneSprite, GridSquare gridSquare, Minefield minefield, BoundaryDelegate boundaryDelegate) {
		super(GridPositionHelper.GetXLocation(gridSquare, boundaryDelegate), GridPositionHelper.GetYLocation(gridSquare, boundaryDelegate), 
				TextureWrapper.GetInstance().GetTextureRegion(GRID_SQUARE_IMAGE_FILENAME), SceneManager.GetVertexBufferObjectManager());
		this.droneSprite = droneSprite;
		this.gridSquare = gridSquare;
		
		addDefenseSprite(minefield);
		addClueView();
		
		DefenseSpriteManager.GetInstance().addGridSquare(this);
		registerUpdate();
		this.boundaryDelegate = boundaryDelegate;
	}
	
	private void registerUpdate() {
		registerUpdateHandler(new IUpdateHandler() {
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				updatePositionAndVisibility();
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
	
	private void addDefenseSprite(Minefield minefield) {
		if (gridSquare.hasDefense()) {
			DefenseSprite defenseSprite = DefenseViewFactory.getDefenseView(gridSquare.getDefense(), droneSprite.getDrone(), minefield);
			DefenseSpriteManager.GetInstance().addDefense(defenseSprite);
			attachChild(defenseSprite);
		}
	}
	
	private void addClueView() {
		clueView = new ClueView(gridSquare.getClue());
		attachChild(clueView);
	}
	
	private void updatePositionAndVisibility() {
		boundaryDelegate.setSpriteVisibility(this);
		setX(GridPositionHelper.GetXLocation(gridSquare, boundaryDelegate));
		setY(GridPositionHelper.GetYLocation(gridSquare, boundaryDelegate));
	}
}
