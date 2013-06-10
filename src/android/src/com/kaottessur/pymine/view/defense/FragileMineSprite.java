package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;

public class FragileMineSprite extends MineSprite {

	public FragileMineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super("FragileMine.png", mine, vertexBufferObjectManager);
	}
	
	@Override
	protected String getDeactivatedFilename() {
		return "DefusedFragileMine.png";
	}
	
	@Override
	protected String getActiveFilename() {
		return "FragileMine.png";
	}
}