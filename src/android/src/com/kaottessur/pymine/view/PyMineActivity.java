package com.kaottessur.pymine.view;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class PyMineActivity extends SimpleBaseGameActivity {
	private static int CAMERA_WIDTH = 800;
	private static int CAMERA_HEIGHT = 480;
	
	private LevelSelection levelSelection;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, 
		    new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		String[] resourceFilenames = {"DefusedMine1.png", "Drone2.png", "GridSquare.png", "Mine1.png", "ScannedGridSquare.png"};
		TextureWrapper textureWrapper = TextureWrapper.Initialize(getFontManager(), getTextureManager(), getAssets());
		for (String resourceFilename : resourceFilenames)
			textureWrapper.GetTexture(resourceFilename);
	}

	@Override
	protected Scene onCreateScene() {
		levelSelection = new LevelSelection();
		SceneManager.Initialize(this, mEngine, levelSelection, getVertexBufferObjectManager());
		return SceneManager.GetInstance().getFirstScene();
	}

}
