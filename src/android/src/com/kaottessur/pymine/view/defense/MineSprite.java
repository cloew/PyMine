package com.kaottessur.pymine.view.defense;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.view.TextureWrapper;

public class MineSprite extends Sprite {
	private Mine mine;
	
	public MineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, TextureWrapper.GetInstance().GetTextureRegion("Mine1.png"), vertexBufferObjectManager);
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
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("DefusedMine1.png"));
        	setVisible(true);
		}
        else
        	setTextureRegion(TextureWrapper.GetInstance().GetTextureRegion("Mine1.png"));
	}
}
