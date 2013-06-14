package com.kaottessur.pymine.view.defense;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;

public class ReverseMineSprite extends MineSprite {
	
	public ReverseMineSprite(Mine mine) {
		super(ReverseMine.class, mine);
	}
	
	@Override protected Class<? extends DefenseInterface> getDefenseClass() {
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
