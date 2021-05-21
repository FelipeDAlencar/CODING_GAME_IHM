package br.com.ihm.coding_in_game.view;


import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Start extends Panel {

	private static final long serialVersionUID = 1L;
	private JButton buttonStartGame, buttonSettings, buttonHelp, buttonClose;
	private JLabel background;
	private boolean isInit = true;

	public Start() {

		setBounds(0, 0, Window.WIDTH, Window.HEIGHT);

		int x = 95, y = 545;
		int margin = 150;
		int width = 76, height = 79;

		buttonSettings = new JButton("");
		buttonSettings.setBounds(x, y, width, height);
		buttonSettings.setToolTipText("Configurações");
		buttonSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonSettings.setOpaque(false);
		buttonSettings.setContentAreaFilled(false);
		buttonSettings.setBorderPainted(false);

		x += margin;
		buttonHelp = new JButton("");
		buttonHelp.setBounds(x, y, width, height);
		buttonHelp.setToolTipText("Ajuda");
		buttonHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		buttonHelp.setOpaque(false);
		buttonHelp.setContentAreaFilled(false);
		buttonHelp.setBorderPainted(false);

		x += margin;
		buttonClose = new JButton("");
		buttonClose.setBounds(x, y, width, height);
		buttonClose.setToolTipText("Fechar");
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonClose.setOpaque(false);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorderPainted(false);

		x += margin;
		buttonStartGame = new JButton("");
		buttonStartGame.setBounds(x, y, width, height);
		buttonStartGame.setToolTipText("Iniciar jogo");
		buttonStartGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonStartGame.setOpaque(false);
		buttonStartGame.setContentAreaFilled(false);
		buttonStartGame.setBorderPainted(false);

		background = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/background_main.jpeg")));

		System.out.println(Window.WIDTH);
		System.out.println(Window.HEIGHT);
		background.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);

		add(buttonStartGame);
		add(buttonSettings);
		add(buttonHelp);
		add(buttonClose);
		add(background);

	}

	public JButton getjButtonStartGame() {
		return buttonStartGame;
	}

	public void setjButtonStartGame(JButton jButtonStartGame) {
		this.buttonStartGame = jButtonStartGame;
	}

	public JButton getjButtonSettings() {
		return buttonSettings;
	}

	public void setjButtonSettings(JButton jButtonSettings) {
		this.buttonSettings = jButtonSettings;
	}

	public JButton getjButtonHelp() {
		return buttonHelp;
	}

	public void setjButtonHelp(JButton jButtonHelp) {
		this.buttonHelp = jButtonHelp;
	}

	public JButton getjButtonClose() {
		return buttonClose;
	}

	public void setjButtonClose(JButton jButtonClose) {
		this.buttonClose = jButtonClose;
	}

	public boolean isInit() {
		return isInit;
	}

	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}

}
