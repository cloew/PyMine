package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.TextureWrapper;

public class LevelOverviewText extends Text {
	private LevelSelection levelSelection;
	private int index;
	
	
	public LevelOverviewText(LevelSelection levelSelection, int index, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, TextureWrapper.GetInstance().GetCompletionFont(), levelSelection.getLevelAt(index).getName(), vertexBufferObjectManager);
		
		this.levelSelection = levelSelection;
		this.index = index;
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		if (touchEvent.isActionDown() ) {
			levelSelection.selectLevel(index);
		}
        return true;
    }
}