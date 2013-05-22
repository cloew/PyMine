package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;

public class ReverseMineSprite extends MineSprite {
	
	public ReverseMineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super("ReverseMine.png", mine, vertexBufferObjectManager);
	}
	
	@Override
	protected String getDeactivatedFilename() {
		return "DefusedReverseMine.png";
	}
	
	@Override
	protected String getActiveFilename() {
		return "ReverseMine.png";
	}
}
