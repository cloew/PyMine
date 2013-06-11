package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Worm;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;

public class WormSprite extends DefenseSprite {
	private Worm worm;
	private Drone drone;
	private Minefield minefield;
	
	private float secondsSinceLastUpdate = 0;
	private final static int TICKS_PER_SECOND = 20;
	private final static float SECONDS_PER_GAME_TICK = (float) 1.0/TICKS_PER_SECOND;
	
	public WormSprite(Worm worm, Drone drone, Minefield minefield, VertexBufferObjectManager vertexBufferObjectManager) {
		super("Worm.png", worm, vertexBufferObjectManager);
		this.worm = worm;
		this.drone = drone;
		this.minefield = minefield;
	}

	@Override
	protected void update(float secondsElapsed) {
		secondsSinceLastUpdate += secondsElapsed;
		if (secondsSinceLastUpdate > SECONDS_PER_GAME_TICK ) {
			worm.update(drone, minefield);
			moveToCurrentGridSquareLocation();
			secondsSinceLastUpdate -= SECONDS_PER_GAME_TICK;
		}
	}

	@Override
	protected String getDeactivatedFilename() {
		return "Worm.png";
	}

	@Override
	protected String getActiveFilename() {
		return "Worm.png";
	}

}
