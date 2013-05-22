package com.kaottessur.pymine.view.defense;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.view.TextureWrapper;

public class MineSprite extends Sprite {
	protected Mine mine;
	
	public MineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		this("Mine1.png", mine, vertexBufferObjectManager);
	}
	
	public MineSprite(String textureFilename, Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, TextureWrapper.GetInstance().GetTextureRegion(textureFilename), vertexBufferObjectManager);
		this.mine = mine;
		setVisible(false);
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
			}
		});
	}
	
	private void setProperTexture() {
		if (mine.isDeactivated()) {
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(getDeactivatedFilename()));
        	setVisible(true);
		}
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion(getActiveFilename()));
	}
	
	protected String getDeactivatedFilename() {
		return "DefusedMine1.png";
	}
	
	protected String getActiveFilename() {
		return "Mine1.png";
	}
}
