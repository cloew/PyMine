package com.kaottessur.pymine.view.defense;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.FragileMine;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;

public class DefenseViewFactory {
	
	public static Sprite getDefenseView(DefenseInterface defense, VertexBufferObjectManager vertexBufferObjectManager) {
		if (defense.getClass() == Mine.class) {
			return new MineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == ReverseMine.class) {
			return new ReverseMineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == FragileMine.class) {
			return new FragileMineSprite((Mine) defense, vertexBufferObjectManager);
		} else if (defense.getClass() == Worm.class) {
			return new WormSprite((Worm) defense, vertexBufferObjectManager);
		}
		return null;
	}
	
}
