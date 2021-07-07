package br.com.ihm.coding_in_game.view;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Start extends Panel {

	private static final long serialVersionUID = 1L;
	private JButton buttonStartGame, buttonSettings, buttonHelp, buttonClose;
	private JLabel background;
	private ImageIcon imgButtonHelpNomal, imgButtonHelpHover, imgButtonHelpClick, imgButtonPlayNormal,
			imgButtonPlayHover, imgButtonPlayClick, imgButtonSettingsNormal, imgButtonSettingsHover,
			imgButtonSettingsClick, imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick;
	private boolean isInit = true;

	public Start() {

		setBounds(0, 0, WindowMain.WIDTH, WindowMain.HEIGHT);
		System.out.println(WindowMain.WIDTH);
		System.out.println(WindowMain.HEIGHT);

		imgButtonPlayNormal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_play_start.png"));
		imgButtonPlayHover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_play_start.png"));
		imgButtonPlayClick = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_play_start.png"));

		imgButtonCloseNormal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_close_start.png"));
		imgButtonCloseHover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_close_start.png"));
		imgButtonCloseClick = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_close_start.png"));

		imgButtonHelpNomal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_help_start.png"));
		imgButtonHelpHover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_help_start.png"));
		imgButtonHelpClick = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_help_start.png"));

		imgButtonSettingsNormal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_settings_start.png"));
		imgButtonSettingsHover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_settings_start.png"));
		imgButtonSettingsClick = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_settings_start.png"));

		int x = 95, y = 545;
		int margin = 150;
		int width = 116, height = 119;

		buttonSettings = new JButton(imgButtonSettingsNormal);
		buttonSettings.setBounds(x, y, width, height);
		buttonSettings.setToolTipText("<html><center><strong>CONFIGURAÇÕESES</strong></center></html>");
		buttonSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonSettings.setOpaque(false);
		buttonSettings.setContentAreaFilled(false);
		buttonSettings.setBorderPainted(false);

		x += margin;
		buttonHelp = new JButton(imgButtonHelpNomal);
		buttonHelp.setBounds(x, y, width, height);
		buttonHelp.setToolTipText("<html><center><strong>AJUDA</strong></center></html>");
		buttonHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonHelp.setOpaque(false);
		buttonHelp.setContentAreaFilled(false);
		buttonHelp.setBorderPainted(false);

		x += margin;
		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setBounds(x, y, width, height);
		buttonClose.setToolTipText("<html><center><strong>FECHAR</strong></center></html>");
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonClose.setOpaque(false);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorderPainted(false);

		x += margin;
		buttonStartGame = new JButton(imgButtonPlayNormal);
		buttonStartGame.setBounds(x, y, width, height);
		buttonStartGame.setToolTipText("<html><center><strong>INICIAR JOGO</strong></center></html>");
		buttonStartGame.setCursor(new Cursor(Cursor.HAND_CURSOR));

		buttonStartGame.setOpaque(false);
		buttonStartGame.setContentAreaFilled(false);
		buttonStartGame.setBorderPainted(false);

		background = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/background_main.jpeg")));
		background.setBounds(0, 0, WindowMain.WIDTH, WindowMain.HEIGHT);

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

	public JButton getButtonStartGame() {
		return buttonStartGame;
	}

	public void setButtonStartGame(JButton buttonStartGame) {
		this.buttonStartGame = buttonStartGame;
	}

	public JButton getButtonSettings() {
		return buttonSettings;
	}

	public void setButtonSettings(JButton buttonSettings) {
		this.buttonSettings = buttonSettings;
	}

	public JButton getButtonHelp() {
		return buttonHelp;
	}

	public void setButtonHelp(JButton buttonHelp) {
		this.buttonHelp = buttonHelp;
	}

	public JButton getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	public ImageIcon getImgButtonHelpNomal() {
		return imgButtonHelpNomal;
	}

	public void setImgButtonHelpNomal(ImageIcon imgButtonHelpNomal) {
		this.imgButtonHelpNomal = imgButtonHelpNomal;
	}

	public ImageIcon getImgButtonHelpHover() {
		return imgButtonHelpHover;
	}

	public void setImgButtonHelpHover(ImageIcon imgButtonHelpHover) {
		this.imgButtonHelpHover = imgButtonHelpHover;
	}

	public ImageIcon getImgButtonHelpClick() {
		return imgButtonHelpClick;
	}

	public void setImgButtonHelpClick(ImageIcon imgButtonHelpClick) {
		this.imgButtonHelpClick = imgButtonHelpClick;
	}

	public ImageIcon getImgButtonPlayNormal() {
		return imgButtonPlayNormal;
	}

	public void setImgButtonPlayNormal(ImageIcon imgButtonPlayNormal) {
		this.imgButtonPlayNormal = imgButtonPlayNormal;
	}

	public ImageIcon getImgButtonPlayHover() {
		return imgButtonPlayHover;
	}

	public void setImgButtonPlayHover(ImageIcon imgButtonPlayHover) {
		this.imgButtonPlayHover = imgButtonPlayHover;
	}

	public ImageIcon getImgButtonPlayClick() {
		return imgButtonPlayClick;
	}

	public void setImgButtonPlayClick(ImageIcon imgButtonPlayClick) {
		this.imgButtonPlayClick = imgButtonPlayClick;
	}

	public ImageIcon getImgButtonSettingsNormal() {
		return imgButtonSettingsNormal;
	}

	public void setImgButtonSettingsNormal(ImageIcon imgButtonSettingsNormal) {
		this.imgButtonSettingsNormal = imgButtonSettingsNormal;
	}

	public ImageIcon getImgButtonSettingsHover() {
		return imgButtonSettingsHover;
	}

	public void setImgButtonSettingsHover(ImageIcon imgButtonSettingsHover) {
		this.imgButtonSettingsHover = imgButtonSettingsHover;
	}

	public ImageIcon getImgButtonSettingsClick() {
		return imgButtonSettingsClick;
	}

	public void setImgButtonSettingsClick(ImageIcon imgButtonSettingsClick) {
		this.imgButtonSettingsClick = imgButtonSettingsClick;
	}

	public ImageIcon getImgButtonCloseNormal() {
		return imgButtonCloseNormal;
	}

	public void setImgButtonCloseNormal(ImageIcon imgButtonCloseNormal) {
		this.imgButtonCloseNormal = imgButtonCloseNormal;
	}

	public ImageIcon getImgButtonCloseHover() {
		return imgButtonCloseHover;
	}

	public void setImgButtonCloseHover(ImageIcon imgButtonCloseHover) {
		this.imgButtonCloseHover = imgButtonCloseHover;
	}

	public ImageIcon getImgButtonCloseClick() {
		return imgButtonCloseClick;
	}

	public void setImgButtonCloseClick(ImageIcon imgButtonCloseClick) {
		this.imgButtonCloseClick = imgButtonCloseClick;
	}



}
