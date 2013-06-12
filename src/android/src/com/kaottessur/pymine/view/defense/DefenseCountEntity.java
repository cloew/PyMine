package com.kaottessur.pymine.view.defense;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.view.TextureWrapper;

public class DefenseCountEntity extends Entity {
	private Level level;
	private Class<?> defenseClass;
	
	public DefenseCountEntity(float x, float y, Level level, Class<?> defenseClass, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y);
		setLevel(level);
		this.defenseClass = defenseClass;
		
		addSprite(vertexBufferObjectManager);
		setupText(vertexBufferObjectManager);
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	private void addSprite(VertexBufferObjectManager vertexBufferObjectManager) {
		Sprite sprite = new Sprite(0, 0, DefenseTextureWrapper.getNormalTexture(defenseClass), vertexBufferObjectManager);
		attachChild(sprite);
	}
	
	private void setupText(VertexBufferObjectManager vertexBufferObjectManager) {
		int count = level.getDefenseCount(defenseClass);
		Text countText = new Text(80, 12, TextureWrapper.GetInstance().GetGameFont(), Integer.toString(count), vertexBufferObjectManager);
		attachChild(countText);
	}
}
