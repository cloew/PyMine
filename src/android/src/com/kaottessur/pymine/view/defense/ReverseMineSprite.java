package com.kaottessur.pymine.view.defense;

import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;

public class ReverseMineSprite extends MineSprite {
	
	public ReverseMineSprite(Mine mine, VertexBufferObjectManager vertexBufferObjectManager) {
		super(ReverseMine.class, mine, vertexBufferObjectManager);
	}
	
	@Override protected Class<?> getDefenseClass() {
		return ReverseMine.class;
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
