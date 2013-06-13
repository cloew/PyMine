package com.kaottessur.pymine.view;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.Level;
import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.hud.PyMineHUD;
import com.kaottessur.pymine.view.level.LevelScene;
import com.kaottessur.pymine.view.level.selection.LevelSelectionScene;

public class SceneManager {
	private static SceneManager instance = null;
	
	private PyMineActivity activity;
	private Engine engine;
	private LevelSelectionScene levelSelectionScene;
	private VertexBufferObjectManager vertexBufferObjectManager;
	
	public static SceneManager Initialize(PyMineActivity activity, Engine engine, LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		instance = new SceneManager(activity, engine, levelSelection, vertexBufferObjectManager);
		return instance;
	}
	
	public static SceneManager GetInstance() {
		return instance;
	}
	
	public static void RunOnUIThread(Runnable action) {
		instance.runOnUIThread(action);
	}
	
	private SceneManager(PyMineActivity activity, Engine engine, LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		this.activity = activity;
		this.engine = engine;
		this.vertexBufferObjectManager = vertexBufferObjectManager;
		
		levelSelectionScene = new LevelSelectionScene(levelSelection, vertexBufferObjectManager);
	}
	
	public void runOnUIThread(Runnable action) {
		activity.runOnUiThread(action);
	}
	
	public Scene getFirstScene() {
		return levelSelectionScene;
	}
	
	public void runLevelSelectionScene() {
		engine.setScene(levelSelectionScene);
		engine.getCamera().setHUD(new HUD());
	}
	
	public void runLevelScene(Level level) {
		LevelScene levelScene = new LevelScene(level, vertexBufferObjectManager);
		engine.setScene(levelScene);
		createGameHUD(level);
	}
	
	private void createGameHUD(Level level)
	{
	    HUD gameHUD = new PyMineHUD(level, vertexBufferObjectManager);
	    engine.getCamera().setHUD(gameHUD);
	}
}
