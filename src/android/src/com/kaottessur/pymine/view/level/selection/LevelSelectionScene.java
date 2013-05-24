package com.kaottessur.pymine.view.level.selection;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.hud.PyMineHUD;
import com.kaottessur.pymine.view.level.LevelScene;

public class LevelSelectionScene extends Scene {
	private final Engine engine;
	private final LevelSelection levelSelection;
	private VertexBufferObjectManager vertexBufferObjectManager;
	
	public LevelSelectionScene(final Engine engine, final LevelSelection levelSelection, VertexBufferObjectManager vertexBufferObjectManager) {
		super();
		this.engine = engine;
		this.levelSelection = levelSelection;
		this.vertexBufferObjectManager = vertexBufferObjectManager;
		
		LevelOverviewText overview = new LevelOverviewText(levelSelection, 0, vertexBufferObjectManager);
		attachChild(overview);
		registerTouchArea(overview);
		
		Rectangle playButton = new Rectangle(400, 240, 100, 100, vertexBufferObjectManager)
		{
	        public boolean onAreaTouched(TouchEvent touchEvent, float X, float Y)
	        {
	            if (touchEvent.isActionUp())
	            {
	            	LevelScene levelScene = new LevelScene(levelSelection.getSelectedLevel(), getVertexBufferObjectManager());
	                engine.setScene(levelScene);
	                createHUD();
	            }
	            return true;
	        };
	    };
		playButton.setColor(.5f, .5f, .5f);
		attachChild(playButton);
		registerTouchArea(playButton);
		
		setBackground(new Background(.75f, .75f, .75f, .75f));
	}
	
	private void createHUD()
	{
	    HUD yourHud = new PyMineHUD(levelSelection.getSelectedLevel(), vertexBufferObjectManager);
	    engine.getCamera().setHUD(yourHud);
	}
}
