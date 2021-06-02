package br.com.ihm.coding_in_game.view;

import java.awt.Color;

public class WindowDialog extends Window {
	private static final long serialVersionUID = 1L;
	private ContentHelpDialog contentHelp;
	private ConfirmExitDialog confirmExit;
	private SettingsDialog settings;
	private GeneralContentDialog generalContentDialog;
	private WindowMain windowParent;

	public WindowDialog(int width, int height, WindowMain windowParent) {
		super(width, height);
		setBackground(new Color(0, 0, 0, 0));

		contentHelp = new ContentHelpDialog(this);
		confirmExit = new ConfirmExitDialog(this);
		settings = new SettingsDialog(this);

		generalContentDialog = new GeneralContentDialog(this);

		this.windowParent = windowParent;

		add(contentHelp);
		add(confirmExit);
		add(settings);
		add(generalContentDialog);
		
		setVisible(false);

	}

	public WindowMain getWindowParent() {
		return windowParent;
	}

	public void setWindowParent(WindowMain windowParent) {
		this.windowParent = windowParent;
	}

	public ContentHelpDialog getContentHelp() {
		return contentHelp;
	}

	public void setContentHelp(ContentHelpDialog contentHelp) {
		this.contentHelp = contentHelp;
	}

	public ConfirmExitDialog getConfirmExit() {
		return confirmExit;
	}

	public void setConfirmExit(ConfirmExitDialog confirmExit) {
		this.confirmExit = confirmExit;
	}

	public SettingsDialog getSettings() {
		return settings;
	}

	public void setSettings(SettingsDialog settings) {
		this.settings = settings;
	}

	public GeneralContentDialog getGeneralContentDialog() {
		return generalContentDialog;
	}

	public void setGeneralContentDialog(GeneralContentDialog generalContentDialog) {
		this.generalContentDialog = generalContentDialog;
	}

}
