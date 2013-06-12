package com.kaottessur.pymine.view.texture;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.util.adt.io.in.IInputStreamOpener;

import com.kaottessur.pymine.view.texture.ButtonTexture;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;

public class TextureWrapper {
	private static TextureWrapper instance = null;
	private Map<String, ITexture> textures;
	private TextureManager textureManager;
	private AssetManager assetManager;
	private FontManager fontManager;
	
	private ButtonTexture scanButtonTexture;
	private ButtonTexture defuseButtonTexture;
	private ButtonTexture defuseCarefullyButtonTexture;
	private ButtonTexture empButtonTexture;
	
	public static TextureWrapper Initialize(FontManager fontManager, TextureManager textureManager, AssetManager assetManager) {
		instance = new TextureWrapper(fontManager, textureManager, assetManager);
		return instance;
	}
	
	public static TextureWrapper GetInstance() {
		return instance;
	}
	
	private TextureWrapper(FontManager fontManager, TextureManager textureManager, AssetManager assetManager) {
		textures = new HashMap<String, ITexture>();
		this.fontManager = fontManager;
		this.textureManager = textureManager;
		this.assetManager = assetManager;

		scanButtonTexture = new ButtonTexture("ScanButton.png", "ScanButton_Pressed.png", assetManager, textureManager);
		defuseButtonTexture = new ButtonTexture("DefuseButton.png", "DefuseButton_Pressed.png", assetManager, textureManager);
		defuseCarefullyButtonTexture = new ButtonTexture("DefuseCarefullyButton.png", "DefuseCarefullyButton_Pressed.png", assetManager, textureManager);
		empButtonTexture = new ButtonTexture("EMPButton.png", "EMPButton_Pressed.png", assetManager, textureManager);
	}
	
	public ButtonTexture getScanButtonTexture() {
		return scanButtonTexture;
	}
	
	public ButtonTexture getDefuseButtonTexture() {
		return defuseButtonTexture;
	}
	
	public ButtonTexture getDefuseCarefullyButtonTexture() {
		return defuseCarefullyButtonTexture;
	}
	
	public ButtonTexture getEMPButtonTexture() {
		return empButtonTexture;
	}
	
	
	public ITextureRegion GetTextureRegion(final String filename) {
		ITexture texture = GetTexture(filename);
		
		if (texture != null)
			return TextureRegionFactory.extractFromTexture(texture);
		return null;
	}
	
	public ITexture GetTexture(final String filename) {
		try {
			if (!textures.containsKey(filename))
				LoadTexture(filename);
			return textures.get(filename);
		} catch (IOException e) {
		    return null;
		}
	}
	
	public IFont GetGameFont() {
		IFont font =  FontFactory.create(fontManager, textureManager, 32, 32,
				Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 32, Color.WHITE);
		font.load();
		return font;
	}
	
	public IFont GetCompletionFont() {
		IFont font =  FontFactory.create(fontManager, textureManager, 64, 800,
				Typeface.create(Typeface.DEFAULT, Typeface.NORMAL), 32, Color.WHITE);
		font.load();
		return font;
	}

	private void LoadTexture(final String filename) throws IOException {
		ITexture texture = new BitmapTexture(textureManager, new IInputStreamOpener() {
	        @Override
	        public InputStream open() throws IOException {
	            return assetManager.open(filename);
	        }
	    });
		texture.load();
		textures.put(filename, texture);
	}
}
