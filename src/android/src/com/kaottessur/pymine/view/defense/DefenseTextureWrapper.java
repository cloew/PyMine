package com.kaottessur.pymine.view.defense;

import java.util.HashMap;
import java.util.Map;

import org.andengine.opengl.texture.region.ITextureRegion;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.defense.FragileMine;
import com.kaottessur.pymine.defense.Mine;
import com.kaottessur.pymine.defense.ReverseMine;
import com.kaottessur.pymine.defense.Worm;
import com.kaottessur.pymine.view.TextureWrapper;

public class DefenseTextureWrapper {
	
	private static Map<Class<? extends DefenseInterface>, String> defenseClassToNormalFilename = new HashMap<Class<? extends DefenseInterface>, String>();
	private static Map<Class<? extends DefenseInterface>, String> defenseClassToDeactivatedFilename = new HashMap<Class<? extends DefenseInterface>, String>();
	
	static {
		defenseClassToNormalFilename.put(FragileMine.class, "FragileMine.png");
		defenseClassToNormalFilename.put(Mine.class, "Mine1.png");
		defenseClassToNormalFilename.put(ReverseMine.class, "ReverseMine.png");
		defenseClassToNormalFilename.put(Worm.class, "Worm.png");
		
		defenseClassToDeactivatedFilename.put(FragileMine.class, "DefusedFragileMine.png");
		defenseClassToDeactivatedFilename.put(Mine.class, "DefusedMine1.png");
		defenseClassToDeactivatedFilename.put(ReverseMine.class, "DefusedReverseMine.png");
		defenseClassToDeactivatedFilename.put(Worm.class, "Worm.png");
	}
	
	public static ITextureRegion getNormalTexture(Class<? extends DefenseInterface> defenseClass) {
		return TextureWrapper.GetInstance().GetTextureRegion(defenseClassToNormalFilename.get(defenseClass));
	}
	
	public static ITextureRegion getDeactivatedTexture(Class<? extends DefenseInterface> defenseClass) {
		return TextureWrapper.GetInstance().GetTextureRegion(defenseClassToDeactivatedFilename.get(defenseClass));
	}
}
