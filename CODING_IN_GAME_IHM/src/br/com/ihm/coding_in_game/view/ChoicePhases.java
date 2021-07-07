package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;

public class ChoicePhases extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelbackground, labelTitle, labelNamePlayer;
	private JButton buttonClose, buttonPhase1, buttonPhase2, buttonPhase3, buttonPhase4, butttonLock;
	private JTextField textFieldNamePlayer;
	private ImageIcon imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked,
			imgButtonPhase01Normal, imgButtonPhase01Click, imgButtonPhase01Hover, imgButtonPhase02Normal,
			imgButtonPhase02Click, imgButtonPhase02Hover, imgButtonPhase03Normal, imgButtonPhase03Click,
			imgButtonPhase03Hover, imgButtonPhase04Normal, imgButtonPhase04Click, imgButtonPhase04Hover,

			imgButtonLock;
	private Player player;
	private WindowDialog windowDialog;

	public ChoicePhases(Player player, WindowDialog windowDialog) {

		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		this.player = player;
		this.windowDialog = windowDialog;

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));

		imgButtonPhase01Normal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_phase01.png"));

		imgButtonPhase01Hover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_phase01.png"));

		imgButtonPhase01Click = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_phase01.png"));

		imgButtonLock = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_phase.png"));
		
		
		
		imgButtonPhase02Normal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_phase02.png"));

		imgButtonPhase02Hover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_phase02.png"));

		imgButtonPhase02Click = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_phase02.png"));
		

		imgButtonPhase03Normal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_phase03.png"));

		imgButtonPhase03Hover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_phase03.png"));

		imgButtonPhase03Click = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_phase03.png"));
		
		
		imgButtonPhase04Normal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_phase04.png"));

		imgButtonPhase04Hover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_phase04.png"));

		imgButtonPhase04Click = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_phase04.png"));

		
		
		
		
		
		

		labelbackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelbackground.setBounds(0, 0, 616, 500);

		int width = 116;
		int height = 119;
		int margin = 120;
		int x = 70, y = 140;

		labelNamePlayer = new JLabel("NOME");
		labelNamePlayer.setBounds(x + 2, y, 50, 20);
		labelNamePlayer.setFont(Util.FONT_CONTENT_INVENTORY);

		textFieldNamePlayer = new JTextField();
		textFieldNamePlayer.setBounds(x, y + 30, 340, 30);
		textFieldNamePlayer.setFont(Util.FONT_CONTENT_INVENTORY);

		y += 90;
		buttonPhase1 = new JButton(imgButtonPhase01Normal);
		buttonPhase1.setContentAreaFilled(false);
		buttonPhase1.setBorder(null);
		buttonPhase1.setBounds(x, y, width, height);
		buttonPhase1.setCursor(Util.CURSOR);
		buttonPhase1.setToolTipText("<html><center><strong>IR PARA FASE 01</strong></center></html>");

		x += margin;

		buttonPhase2 = new JButton(imgButtonLock);
		buttonPhase2.setContentAreaFilled(false);
		buttonPhase2.setBorder(null);
		buttonPhase2.setBounds(x, y, width, height);
		buttonPhase2.setCursor(Util.CURSOR);
		buttonPhase2.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");

		x += margin;

		buttonPhase3 = new JButton(imgButtonLock);
		buttonPhase3.setContentAreaFilled(false);
		buttonPhase3.setBorder(null);
		buttonPhase3.setBounds(x, y, width, height);
		buttonPhase3.setCursor(Util.CURSOR);
		buttonPhase3.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");

		x += margin;

		buttonPhase4 = new JButton(imgButtonLock);
		buttonPhase4.setContentAreaFilled(false);
		buttonPhase4.setBorder(null);
		buttonPhase4.setBounds(x, y, width, height);
		buttonPhase4.setCursor(Util.CURSOR);
		buttonPhase4.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");

		labelTitle = new JLabel("FASES");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(240, 30, 150, 50);

		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(280, 435, 50, 52);
		buttonClose.setCursor(Util.CURSOR);
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		add(labelNamePlayer);
		add(textFieldNamePlayer);
		add(buttonPhase1);
		add(buttonPhase2);
		add(buttonPhase3);
		add(buttonPhase4);
		add(labelTitle);
		add(buttonClose);
		add(labelbackground);

		setVisible(false);

	}

	public JLabel getLabelbackground() {
		return labelbackground;
	}

	public void setLabelbackground(JLabel labelbackground) {
		this.labelbackground = labelbackground;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JButton getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	public JButton getButtonPhase1() {
		return buttonPhase1;
	}

	public void setButtonPhase1(JButton buttonPhase1) {
		this.buttonPhase1 = buttonPhase1;
	}

	public JButton getButtonPhase2() {
		return buttonPhase2;
	}

	public void setButtonPhase2(JButton buttonPhase2) {
		this.buttonPhase2 = buttonPhase2;
	}

	public JButton getButtonPhase3() {
		return buttonPhase3;
	}

	public void setButtonPhase3(JButton buttonPhase3) {
		this.buttonPhase3 = buttonPhase3;
	}

	public JButton getButtonPhase4() {
		return buttonPhase4;
	}

	public void setButtonPhase4(JButton buttonPhase4) {
		this.buttonPhase4 = buttonPhase4;
	}

	public JButton getButttonLock() {
		return butttonLock;
	}

	public void setButttonLock(JButton butttonLock) {
		this.butttonLock = butttonLock;
	}

	public JLabel getLabelNamePlayer() {
		return labelNamePlayer;
	}

	public void setLabelNamePlayer(JLabel labelNamePlayer) {
		this.labelNamePlayer = labelNamePlayer;
	}

	public JTextField getTextFieldNamePlayer() {
		return textFieldNamePlayer;
	}

	public void setTextFieldNamePlayer(JTextField textFieldNamePlayer) {
		this.textFieldNamePlayer = textFieldNamePlayer;
	}

	public JTextField getTextNamePlayer() {
		return textFieldNamePlayer;
	}

	public void setTextNamePlayer(JTextField textNamePlayer) {
		this.textFieldNamePlayer = textNamePlayer;
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

	public ImageIcon getImgButtonCloseLocked() {
		return imgButtonCloseLocked;
	}

	public void setImgButtonCloseLocked(ImageIcon imgButtonCloseLocked) {
		this.imgButtonCloseLocked = imgButtonCloseLocked;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ImageIcon getImgButtonPhase01Normal() {
		return imgButtonPhase01Normal;
	}

	public void setImgButtonPhase01Normal(ImageIcon imgButtonPhase01Normal) {
		this.imgButtonPhase01Normal = imgButtonPhase01Normal;
	}

	public ImageIcon getImgButtonPhase01Click() {
		return imgButtonPhase01Click;
	}

	public void setImgButtonPhase01Click(ImageIcon imgButtonPhase01Click) {
		this.imgButtonPhase01Click = imgButtonPhase01Click;
	}

	public ImageIcon getImgButtonPhase01Hover() {
		return imgButtonPhase01Hover;
	}

	public void setImgButtonPhase01Hover(ImageIcon imgButtonPhase01Hover) {
		this.imgButtonPhase01Hover = imgButtonPhase01Hover;
	}

	public ImageIcon getImgButtonLock() {
		return imgButtonLock;
	}

	public void setImgButtonLock(ImageIcon imgButtonLock) {
		this.imgButtonLock = imgButtonLock;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public ImageIcon getImgButtonPhase02Normal() {
		return imgButtonPhase02Normal;
	}

	public void setImgButtonPhase02Normal(ImageIcon imgButtonPhase02Normal) {
		this.imgButtonPhase02Normal = imgButtonPhase02Normal;
	}

	public ImageIcon getImgButtonPhase02Click() {
		return imgButtonPhase02Click;
	}

	public void setImgButtonPhase02Click(ImageIcon imgButtonPhase02Click) {
		this.imgButtonPhase02Click = imgButtonPhase02Click;
	}

	public ImageIcon getImgButtonPhase02Hover() {
		return imgButtonPhase02Hover;
	}

	public void setImgButtonPhase02Hover(ImageIcon imgButtonPhase02Hover) {
		this.imgButtonPhase02Hover = imgButtonPhase02Hover;
	}

	public ImageIcon getImgButtonPhase03Normal() {
		return imgButtonPhase03Normal;
	}

	public void setImgButtonPhase03Normal(ImageIcon imgButtonPhase03Normal) {
		this.imgButtonPhase03Normal = imgButtonPhase03Normal;
	}

	public ImageIcon getImgButtonPhase03Click() {
		return imgButtonPhase03Click;
	}

	public void setImgButtonPhase03Click(ImageIcon imgButtonPhase03Click) {
		this.imgButtonPhase03Click = imgButtonPhase03Click;
	}

	public ImageIcon getImgButtonPhase03Hover() {
		return imgButtonPhase03Hover;
	}

	public void setImgButtonPhase03Hover(ImageIcon imgButtonPhase03Hover) {
		this.imgButtonPhase03Hover = imgButtonPhase03Hover;
	}

	public ImageIcon getImgButtonPhase04Normal() {
		return imgButtonPhase04Normal;
	}

	public void setImgButtonPhase04Normal(ImageIcon imgButtonPhase04Normal) {
		this.imgButtonPhase04Normal = imgButtonPhase04Normal;
	}

	public ImageIcon getImgButtonPhase04Click() {
		return imgButtonPhase04Click;
	}

	public void setImgButtonPhase04Click(ImageIcon imgButtonPhase04Click) {
		this.imgButtonPhase04Click = imgButtonPhase04Click;
	}

	public ImageIcon getImgButtonPhase04Hover() {
		return imgButtonPhase04Hover;
	}

	public void setImgButtonPhase04Hover(ImageIcon imgButtonPhase04Hover) {
		this.imgButtonPhase04Hover = imgButtonPhase04Hover;
	}
	
	

}
