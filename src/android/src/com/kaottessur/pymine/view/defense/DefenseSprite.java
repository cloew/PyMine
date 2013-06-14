package com.kaottessur.pymine.view.defense;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.view.GridPositionHelper;
import com.kaottessur.pymine.view.SceneManager;

public abstract class DefenseSprite extends Sprite {
	protected DefenseInterface defense;
	
	public DefenseSprite(Class<?  extends DefenseInterface> defenseClass, DefenseInterface defense) {
		super(0, 0, DefenseTextureWrapper.getNormalTexture(defenseClass), SceneManager.GetVertexBufferObjectManager());
		this.defense = defense;
		setVisible(false);
		moveToCurrentGridSquareLocation();
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
				update(pSecondsElapsed);
				setProperTexture();
				setVisible(defense.isVisible());
			}
		});
	}
	
	private void setProperTexture() {
		if (defense.isDeactivated()) {
        	setTextureRegion(DefenseTextureWrapper.getDeactivatedTexture(getDefenseClass()));
        	setVisible(true);
		}
        else
        	setTextureRegion(DefenseTextureWrapper.getNormalTexture(getDefenseClass()));
	}
	
	protected abstract void update(float secondsElapsed);
	protected abstract Class<?  extends DefenseInterface> getDefenseClass();
	protected abstract String getDeactivatedFilename();
	protected abstract String getActiveFilename();
	
	protected void moveToCurrentGridSquareLocation() {
		setPosition(GridPositionHelper.GetXLocation(defense.getGridSquare()), GridPositionHelper.GetYLocation(defense.getGridSquare()));
	}
	
	public DefenseInterface getDefense() {
		return defense;
	}
}
