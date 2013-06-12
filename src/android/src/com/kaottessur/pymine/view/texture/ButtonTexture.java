package com.kaottessur.pymine.view.texture;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.res.AssetManager;

public class ButtonTexture {
	private BuildableBitmapTextureAtlas bitmapTextureAtlas;
	private ITextureRegion regularTextureRegion;
	private ITextureRegion pressedTextureRegion;
	
	public ButtonTexture(String regularTextureFilename, String pressedTextureFilename, AssetManager assetManager, TextureManager textureManager) {
		bitmapTextureAtlas = new BuildableBitmapTextureAtlas(textureManager, 512, 512);
		regularTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, assetManager, regularTextureFilename);
		pressedTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(bitmapTextureAtlas, assetManager, pressedTextureFilename);
		
		try {
			this.bitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			this.bitmapTextureAtlas.load();
		} catch (TextureAtlasBuilderException e) {
			System.out.println("OMG It exploded!");
		}
	}
	
	public ITextureRegion getRegularTextureRegion() {
		return regularTextureRegion;
	}
	
	public ITextureRegion getPressedTextureRegion() {
		return pressedTextureRegion;
	}
}
