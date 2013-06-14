package com.kaottessur.pymine.view.level.selection;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

import com.kaottessur.pymine.level.selection.LevelSelection;
import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class LevelOverviewText extends Rectangle {
	private LevelSelection levelSelection;
	private int index;
	private Text nameText;
	
	
	public LevelOverviewText(LevelSelection levelSelection, int index) {
		super(50+100*(index%3), 50+100*(index/3), 50, 50, SceneManager.GetVertexBufferObjectManager());
		
		nameText = new Text(0, 0, TextureWrapper.GetInstance().GetCompletionFont(), levelSelection.getLevelAt(index).getName(), SceneManager.GetVertexBufferObjectManager());
		attachChild(nameText);
		
		this.levelSelection = levelSelection;
		this.index = index;
		
		setColor(.75f, .75f, .75f);
	}
	
	@Override
    public boolean onAreaTouched(TouchEvent touchEvent, float x, float y) {
		levelSelection.selectLevel(index);
        return true;
    }
}
