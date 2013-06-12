package com.kaottessur.pymine.view.hud;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.ButtonTexture;

public abstract class HUDButton extends ButtonSprite {
	public static final int BUTTON_SIZE = 120;
	protected Drone drone;
	protected Level level;
	
	public HUDButton(int row, Level level, ButtonTexture buttonTexture, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, BUTTON_SIZE*row, buttonTexture.getRegularTextureRegion(), buttonTexture.getPressedTextureRegion(), vertexBufferObjectManager);
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
    
    protected void performButtonAction() {
    	if (level.finished()) {
    		SceneManager.GetInstance().runLevelSelectionScene();
    	} else {
    		performGameAction();
    	}
    }
    
    protected abstract void performGameAction();
}
