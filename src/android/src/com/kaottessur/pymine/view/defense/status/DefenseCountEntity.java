package com.kaottessur.pymine.view.defense.status;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import com.kaottessur.pymine.defense.DefenseInterface;
import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.defense.DefenseTextureWrapper;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class DefenseCountEntity extends Entity {
	private Level level;
	private Class<? extends DefenseInterface> defenseClass;
	
	public DefenseCountEntity(float x, float y, Level level, Class<? extends DefenseInterface> defenseClass) {
		super(x, y);
		setLevel(level);
		this.defenseClass = defenseClass;
		
		addSprite();
		setupText();
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	private void addSprite() {
		Sprite sprite = new Sprite(0, 0, DefenseTextureWrapper.getNormalTexture(defenseClass), SceneManager.GetVertexBufferObjectManager());
		attachChild(sprite);
	}
	
	private void setupText() {
		int count = level.getDefenseCount(defenseClass);
		Text countText = new Text(80, 12, TextureWrapper.GetInstance().GetGameFont(), Integer.toString(count), SceneManager.GetVertexBufferObjectManager());
		attachChild(countText);
	}
}
