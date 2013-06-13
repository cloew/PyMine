package com.kaottessur.pymine.view.hud;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.texture.ButtonTexture;

public abstract class HUDButton extends ButtonSprite {
	protected Drone drone;
	protected Level level;
	
	public HUDButton(float x, float y, Level level, ButtonTexture buttonTexture, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y, buttonTexture.getRegularTextureRegion(), buttonTexture.getPressedTextureRegion(), vertexBufferObjectManager);
		this.level = level;
		drone = level.getDrone();
		
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
					float pTouchAreaLocalY) {
				performButtonAction();
				
			}
		});
	}
    
    protected abstract void performButtonAction();
}
