package com.kaottessur.pymine.view.level.clue;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.text.Text;

import com.kaottessur.pymine.level.clue.Clue;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class AdjacencyClueText extends Text {
	private Clue clue;
	
	public AdjacencyClueText(Clue clue) {
		super(40, 0, TextureWrapper.GetInstance().GetGameFont(), "", 1, SceneManager.GetVertexBufferObjectManager());
		this.clue = clue;
		registerUpdate();
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
		int count = clue.getFragilityClue().getCount();
		if (distance == -1) {
			setColor(0, 0, 0);
		} else if (distance <= 1) {
			if (count == 1)
				setColor((float) 227.0/255, (float) 68.0/255, (float) 20.0/255);
			else
				setColor((float) 196.0/255, 0, 0);
		} else if (distance < 4) {
			setColor((float) 244.0/255, (float) 244.0/255, 0);
		} else {
			setColor(0, (float) 154.0/255, 0);
		}
	}
	
	private void registerUpdate() {
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
}
