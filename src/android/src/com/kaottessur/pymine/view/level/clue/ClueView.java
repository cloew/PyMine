package com.kaottessur.pymine.view.level.clue;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.level.clue.Clue;
import com.kaottessur.pymine.view.TextureWrapper;

public class ClueView extends Text {
	private Clue clue;
		
	public ClueView(Clue clue, VertexBufferObjectManager vertexBufferObjectManager) {
		super(32, 0, TextureWrapper.GetInstance().GetGameFont(), "", 1, vertexBufferObjectManager);
		
		this.clue = clue;
		registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
				// Do Nothing
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				updateClueViewText();
				updateTextColor();
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
	
	private void updateTextColor() {
		int distance = clue.getFragilityClue().getDistance();
		if (distance == -1) {
			setColor(0, 0, 0);
		} else if (distance <= 1) {
			setColor((float) 244.0/255, 0, 0);
		} else if (distance < 4) {
			setColor((float) 244.0/255, (float) 244.0/255, 0);
		} else {
			setColor(0, (float) 154.0/255, 0);
		}
	}
}
