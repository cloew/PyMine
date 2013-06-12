package com.kaottessur.pymine.view.hud;

import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.TextureWrapper;

public class ScanButton extends ButtonSprite {
	private Level level;
	protected Drone drone;
	
	public ScanButton(Level level, VertexBufferObjectManager vertexBufferObjectManager) {
		super(680, 0, TextureWrapper.GetInstance().getScanButton(), 
				TextureWrapper.GetInstance().getPressedScanButton(), vertexBufferObjectManager);
		
		this.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
							float pTouchAreaLocalY) {
						performButtonAction();
						
					}
				}); 

		this.level = level;
		drone = level.getDrone();
	}
	
	//@Override
    protected void performButtonAction() {
    	if (level.finished()) {
    		SceneManager.GetInstance().runLevelSelectionScene();
    	} else {
    		performGameAction();
    	}
    }

	//@Override
	protected void performGameAction() {
		drone.scan();
	}

}
