package com.kaottessur.pymine.view.defense;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.Worm;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.GridSquare;
import com.kaottessur.pymine.level.Minefield;
import com.kaottessur.pymine.view.defense.helper.DefenseSpriteManager;

public class WormSprite extends DefenseSprite {
	private Worm worm;
	private Drone drone;
	private Minefield minefield;
	
	private float secondsSinceLastUpdate = 0;
	private final static int TICKS_PER_SECOND = 20;
	private final static float SECONDS_PER_GAME_TICK = (float) 1.0/TICKS_PER_SECOND;
	
	public WormSprite(Worm worm, Drone drone, Minefield minefield) {
		super(Worm.class, worm);
		this.worm = worm;
		this.drone = drone;
		this.minefield = minefield;
	}

	@Override
	protected void update(float secondsElapsed) {
		secondsSinceLastUpdate += secondsElapsed;
		if (secondsSinceLastUpdate > SECONDS_PER_GAME_TICK ) {
			updateAndMoveWorm();
			setAlphaValue();
			secondsSinceLastUpdate -= SECONDS_PER_GAME_TICK;
		}
	}
	
	private void updateAndMoveWorm() {
		GridSquare previousSquare = worm.getGridSquare();
		worm.update(drone, minefield);
		DefenseSpriteManager.GetInstance().moveDefenseToNewGridSquare(this, previousSquare, worm.getGridSquare());
	}
	
	private void setAlphaValue() {
		if (worm.shouldBeSolid())
			setAlpha(1);
		else
			setAlpha(worm.getTicksTowardsAttack()/(float) Worm.TICKS_TO_ATTACK);
	}
	
	@Override protected Class<? extends DefenseInterface> getDefenseClass() {
		return Worm.class;
	}
}
