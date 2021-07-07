package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;

public class SelectPlayer extends Panel {

	private static final long serialVersionUID = 1L;

	private WindowDialog windowDialog;
	private JLabel labelbackground, labelTitle;
	private JButton buttonClose, buttonAddPlayer;
	private ImageIcon imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked,
			imgButtonAddPlayerNormal, imgButtonAddPlayerHover, imgButtonAddPlayerClick, imgButtonAddPlayerLocked;
	private ArrayList<JLabel> labelsPlayers;
	private JPanel panelPlayer;
	private JScrollPane scrollPane;

	public SelectPlayer(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;

		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		labelbackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelbackground.setBounds(0, 0, 616, 500);

		labelTitle = new JLabel("JOGADOR");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(210, 30, 250, 50);

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));

		imgButtonAddPlayerNormal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_add.png"));
		imgButtonAddPlayerHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_add.png"));
		imgButtonAddPlayerClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_add.png"));
		imgButtonAddPlayerLocked = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_locked_add.png"));

		buttonAddPlayer = new JButton(imgButtonAddPlayerNormal);
		buttonAddPlayer.setContentAreaFilled(false);
		buttonAddPlayer.setBorder(null);
		buttonAddPlayer.setBounds(416, 435, 50, 52);
		buttonAddPlayer.setCursor(Util.CURSOR);
		buttonAddPlayer.setToolTipText("<html><center><strong>ADICIONAR</strong></center></html>");

		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(150, 435, 50, 52);
		buttonClose.setCursor(Util.CURSOR);
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		initLabelsPlayer();

		add(buttonAddPlayer);
		add(buttonClose);
		add(labelTitle);
		add(scrollPane);
		add(labelbackground);
		setVisible(false);
	}

	public void initLabelsPlayer() {
		labelsPlayers = new ArrayList<>();

		if (Util.players != null) {
			for (Player player : Util.players) {
				JLabel label = new JLabel(player.getName() + " .......................... " + player.getScore());
				label.setForeground(new Color(0, 0, 0));
				label.setFont(Util.FONT_CONTENT);
				label.setCursor(Util.CURSOR);
				labelsPlayers.add(label);
			}
		}

		panelPlayer = new JPanel();
		panelPlayer.setBackground(new Color(0, 0, 0, 0));
		GridLayout layoutPanelPlayer = new GridLayout(100, 1);
		layoutPanelPlayer.setVgap(5);
		panelPlayer.setLayout(layoutPanelPlayer);

		for (JLabel label : labelsPlayers) {
			panelPlayer.add(label);
		}

		scrollPane = new JScrollPane(panelPlayer);
		scrollPane.setBounds(70, 145, 478, 255);

		// EXCLUDE BORDER AND TRANSPARENT
		scrollPane.getViewport().setOpaque(false);
		scrollPane.getViewport().setFocusable(false);
		scrollPane.getViewport().setForeground(new Color(0, 0, 0, 0));
		scrollPane.getViewport().setRequestFocusEnabled(false);
		scrollPane.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setFocusable(false);
		scrollPane.setForeground(new Color(0, 0, 0, 0));
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setToolTipText("<html><center><strong>SELECIONE SEU USERNAME</strong></center></html>");
		scrollPane.setEnabled(false);

	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
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

	public ArrayList<JLabel> getLabelsPlayers() {
		return labelsPlayers;
	}

	public void setLabelsPlayers(ArrayList<JLabel> labelsPlayers) {
		this.labelsPlayers = labelsPlayers;
	}

	public JPanel getPanelPlayer() {
		return panelPlayer;
	}

	public void setPanelPlayer(JPanel panelPlayer) {
		this.panelPlayer = panelPlayer;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getButtonAddPlayer() {
		return buttonAddPlayer;
	}

	public void setButtonAddPlayer(JButton buttonAddPlayer) {
		this.buttonAddPlayer = buttonAddPlayer;
	}

	public ImageIcon getImgButtonAddPlayerNormal() {
		return imgButtonAddPlayerNormal;
	}

	public void setImgButtonAddPlayerNormal(ImageIcon imgButtonAddPlayerNormal) {
		this.imgButtonAddPlayerNormal = imgButtonAddPlayerNormal;
	}

	public ImageIcon getImgButtonAddPlayerHover() {
		return imgButtonAddPlayerHover;
	}

	public void setImgButtonAddPlayerHover(ImageIcon imgButtonAddPlayerHover) {
		this.imgButtonAddPlayerHover = imgButtonAddPlayerHover;
	}

	public ImageIcon getImgButtonAddPlayerClick() {
		return imgButtonAddPlayerClick;
	}

	public void setImgButtonAddPlayerClick(ImageIcon imgButtonAddPlayerClick) {
		this.imgButtonAddPlayerClick = imgButtonAddPlayerClick;
	}

	public ImageIcon getImgButtonAddPlayerLocked() {
		return imgButtonAddPlayerLocked;
	}

	public void setImgButtonAddPlayerLocked(ImageIcon imgButtonAddPlayerLocked) {
		this.imgButtonAddPlayerLocked = imgButtonAddPlayerLocked;
	}

}
