package com.kaottessur.pymine.view.level;

import org.andengine.entity.text.Text;

import com.kaottessur.pymine.view.SceneManager;
import com.kaottessur.pymine.view.texture.TextureWrapper;

public class CompletionText extends Text {

	public CompletionText(String text) {
		super(400, 240, TextureWrapper.GetInstance().GetCompletionFont(), text, SceneManager.GetVertexBufferObjectManager());
		setVisible(false);
	}	
}
