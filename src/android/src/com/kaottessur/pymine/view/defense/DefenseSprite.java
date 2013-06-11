package com.kaottessur.pymine.view.defense;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.view.GridPositionHelper;
import com.kaottessur.pymine.view.TextureWrapper;

public abstract class DefenseSprite extends Sprite {
	protected DefenseInterface defense;
	
	public DefenseSprite(DefenseInterface defense, VertexBufferObjectManager vertexBufferObjectManager) {
		this("Mine1.png", defense, vertexBufferObjectManager);
	}
	
	public DefenseSprite(String textureFilename, DefenseInterface defense, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, TextureWrapper.GetInstance().GetTextureRegion(textureFilename), vertexBufferObjectManager);
		this.defense = defense;
		setScale(4);
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
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(getDeactivatedFilename()));
        	setVisible(true);
		}
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(getActiveFilename()));
	}
	
	protected abstract void update(float secondsElapsed);
	protected abstract String getDeactivatedFilename();
	protected abstract String getActiveFilename();
	
	protected void moveToCurrentGridSquareLocation() {
		setPosition(GridPositionHelper.GetXLocation(defense.getGridSquare()), GridPositionHelper.GetYLocation(defense.getGridSquare()));
	}
	
	public DefenseInterface getDefense() {
		return defense;
	}
}
