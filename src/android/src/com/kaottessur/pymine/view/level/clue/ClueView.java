package com.kaottessur.pymine.view.level.clue;

import org.andengine.entity.text.Text;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class ClueView extends Text {
		
	public ClueView(IFont font, VertexBufferObjectManager vertexBufferObjectManager) {
		super(0, 0, font, "", vertexBufferObjectManager);
	}
}
