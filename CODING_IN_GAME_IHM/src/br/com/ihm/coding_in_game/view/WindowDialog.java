package br.com.ihm.coding_in_game.view;

import java.awt.Color;

public class WindowDialog extends Window {
	private static final long serialVersionUID = 1L;
	private ContentHelp contentHelp;
	private ConfirmExit confirmExit;
	private Settings settings;

	public WindowDialog(int width, int height) {
		super(width, height);
		setBackground(new Color(0, 0, 0, 0));
		contentHelp = new ContentHelp(this);
		confirmExit = new ConfirmExit(this);
		settings = new Settings(this);

		add(contentHelp);
		add(confirmExit);
		add(settings);
		setVisible(false);

	}

	public ContentHelp getContentHelp() {
		return contentHelp;
	}

	public void setContentHelp(ContentHelp contentHelp) {
		this.contentHelp = contentHelp;
	}

	public ConfirmExit getConfirmExit() {
		return confirmExit;
	}

	public void setConfirmExit(ConfirmExit confirmExit) {
		this.confirmExit = confirmExit;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

}
