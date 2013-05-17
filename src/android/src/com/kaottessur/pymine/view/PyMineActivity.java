package com.kaottessur.pymine.view;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.kaottessur.pymine.level.Minefield;

public class PyMineActivity extends SimpleBaseGameActivity {
	private static int CAMERA_WIDTH = 800;
	private static int CAMERA_HEIGHT = 480;
	
	private MinefieldScene minefieldScene;
	private Minefield minefield;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, 
		    new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		String[] resourceFilenames = {"Drone2.png", "GridSquare.png", "ScannedGridSquare.png"};
		TextureWrapper textureWrapper = TextureWrapper.Initialize(getTextureManager(), getAssets());
		for (String resourceFilename : resourceFilenames)
			textureWrapper.GetTexture(resourceFilename);
	}

	@Override
	protected Scene onCreateScene() {
		minefield = new Minefield(4, 5);
		minefieldScene = new MinefieldScene(minefield, getVertexBufferObjectManager());
		return minefieldScene;
	}

}
