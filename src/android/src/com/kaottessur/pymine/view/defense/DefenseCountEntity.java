package com.kaottessur.pymine.view.defense;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.LevelInit;
import com.kaottessur.pymine.view.TextureWrapper;

public class DefenseCountEntity extends Entity {
	private LevelInit levelInit;
	private Class<?> defenseClass;
	
	public DefenseCountEntity(float x, float y, LevelInit levelInit, Class<?> defenseClass, VertexBufferObjectManager vertexBufferObjectManager) {
		super(x, y);
		setLevelInit(levelInit);
		this.defenseClass = defenseClass;
		
		addSprite(vertexBufferObjectManager);
		setupText(vertexBufferObjectManager);
	}
	
	public void setLevelInit(LevelInit levelInit) {
		this.levelInit = levelInit;
	}
	
	private void addSprite(VertexBufferObjectManager vertexBufferObjectManager) {
		Sprite sprite = new Sprite(0, 0, TextureWrapper.GetInstance().GetTextureRegion("Mine1.png"), vertexBufferObjectManager);
		attachChild(sprite);
	}
	
	private void setupText(VertexBufferObjectManager vertexBufferObjectManager) {
		Text countText = new Text(80, 16, TextureWrapper.GetInstance().GetGameFont(), "1", vertexBufferObjectManager);
		attachChild(countText);
	}
}
