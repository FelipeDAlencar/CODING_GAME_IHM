package br.com.ihm.coding_in_game.view;

import java.awt.Color;

public class WindowHelp extends Window {
	private static final long serialVersionUID = 1L;
	private ContentHelp contentHelp;

	public WindowHelp(int width, int height) {
		super(width, height);
		setBackground(new Color(0, 0, 0, 0));
		contentHelp = new ContentHelp(this);

		add(contentHelp);
		setVisible(false);

	}

	public ContentHelp getContentHelp() {
		return contentHelp;
	}

	public void setContentHelp(ContentHelp contentHelp) {
		this.contentHelp = contentHelp;
	}

}
