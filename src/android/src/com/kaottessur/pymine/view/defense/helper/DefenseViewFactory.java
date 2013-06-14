package com.kaottessur.pymine.view.defense.helper;

import com.kaottessur.pymine.defense.AntiDroneTurret;
import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.FragileMine;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;
import com.kaottessur.pymine.level.Drone;
import com.kaottessur.pymine.level.Minefield;
import com.kaottessur.pymine.view.defense.AntiDroneTurretSprite;
import com.kaottessur.pymine.view.defense.DefenseSprite;
import com.kaottessur.pymine.view.defense.FragileMineSprite;
import com.kaottessur.pymine.view.defense.MineSprite;
import com.kaottessur.pymine.view.defense.ReverseMineSprite;
import com.kaottessur.pymine.view.defense.WormSprite;

public class DefenseViewFactory {
	
	public static DefenseSprite getDefenseView(DefenseInterface defense, Drone drone, Minefield minefield) {
		if (defense.getClass() == Mine.class) {
			return new MineSprite((Mine) defense);
		} else if (defense.getClass() == ReverseMine.class) {
			return new ReverseMineSprite((Mine) defense);
		} else if (defense.getClass() == FragileMine.class) {
			return new FragileMineSprite((Mine) defense);
		} else if (defense.getClass() == Worm.class) {
			return new WormSprite((Worm) defense, drone, minefield);
		} else if (defense.getClass() == AntiDroneTurret.class) {
			return new AntiDroneTurretSprite((AntiDroneTurret) defense);
		}
		return null;
	}
	
}
