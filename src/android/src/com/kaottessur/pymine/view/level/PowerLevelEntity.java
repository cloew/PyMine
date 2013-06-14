package com.kaottessur.pymine.view.level;

import org.andengine.entity.Entity;
import org.andengine.entity.text.Text;

import android.annotation.SuppressLint;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class PowerLevelEntity extends Entity {
	private Drone drone;
	private int maxPowerLevel;
	private Text powerLevelText;

	PowerLevelEntity(float x, float y, Drone drone) {
		super(x, y);
		this.drone = drone;
		maxPowerLevel = drone.getPower();
		
		powerLevelText = new Text(0, 0, TextureWrapper.GetInstance().GetCompletionFont(), getPowerString(), SceneManager.GetVertexBufferObjectManager());
		attachChild(powerLevelText);
	}
	
	@SuppressLint("DefaultLocale")
	private String getPowerString() {
		return String.format("%d/%d", drone.getPower(), maxPowerLevel);
	}
}
