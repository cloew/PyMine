package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Worm;

public class WormSprite extends DefenseSprite {
	private Worm worm;
	
	public WormSprite(Worm worm, VertexBufferObjectManager vertexBufferObjectManager) {
		super("Worm.png", worm, vertexBufferObjectManager);
	}

	@Override
	protected void update(float secondsElapsed) {
		// TODO Auto-generated method stub
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
