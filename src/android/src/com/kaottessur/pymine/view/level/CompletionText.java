package com.kaottessur.pymine.view.level;

import org.andengine.entity.text.Text;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.kaottessur.pymine.view.TextureWrapper;

public class CompletionText extends Text {

	public CompletionText(String text, VertexBufferObjectManager vertexBufferObjectManager) {
		super(400, 240, TextureWrapper.GetInstance().GetCompletionFont(), text, vertexBufferObjectManager);
		setVisible(false);
	}
	
}
