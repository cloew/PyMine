package com.kaottessur.pymine.view.level.clue;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.clue.Clue;

public class ClueView extends Text {
	private Clue clue;
		
	public ClueView(Clue clue, IFont font, VertexBufferObjectManager vertexBufferObjectManager) {
		super(10, 0, font, "", 1, vertexBufferObjectManager);
		
		this.clue = clue;
		registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				updateClueViewText();
			}
		});
	}
	
	public void updateClueViewText() {
		int numberOfAdjacentMines = clue.getAdjacencyClue().getClueReading();
		if (numberOfAdjacentMines > 0)
			setText(Integer.toString(numberOfAdjacentMines));
		else
			setText("");
	}
}
