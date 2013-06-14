package com.kaottessur.pymine.view.level.clue;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.sprite.Sprite;

import com.kaottessur.pymine.level.clue.Clue;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class WeaponCautionClue extends Sprite {
	private Clue clue;
	
	public WeaponCautionClue(Clue clue) {
		super(0, 0, TextureWrapper.GetInstance().GetTextureRegion("warning.gif"), SceneManager.GetVertexBufferObjectManager());
		this.clue = clue;
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
				setVisible(clue.getWeaponCautionClue().isNearWeaponry());
			}
		});
	}
}
