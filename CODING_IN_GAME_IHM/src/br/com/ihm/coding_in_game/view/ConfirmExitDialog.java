package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import br.com.ihm.coding_in_game.model.Util;

public class ConfirmExitDialog extends Panel {

	private WindowDialog windowDialog;
	private JLabel labelBackground, labelTitle, labelContent;
	private JButton buttonClose, buttonConfirm;
	private static final long serialVersionUID = 1L;
	private ImageIcon imgButtonDoneNormal, imgButtonDoneHover, imgButtonDoneClick, imgButtonDoneLocked,
			imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked;

	public ConfirmExitDialog(WindowDialog window) {
		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		imgButtonDoneNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_done.png"));
		imgButtonDoneHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_done.png"));
		imgButtonDoneClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_done.png"));
		imgButtonDoneLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_done.png"));

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelBackground.setBounds(0, 0, 616, 470);
		
		labelTitle = new JLabel("SAIR");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(260, 15, 200, 50);

		labelContent = new JLabel("Deseja realmente sair?");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(Util.FONT_CONTENT);
		labelContent.setBounds(70, 120, 300, 50);

		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(400, 435, 52, 53);
		buttonClose.setCursor(Util.CURSOR);
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		buttonConfirm = new JButton(imgButtonDoneNormal);
		buttonConfirm.setContentAreaFilled(false);
		buttonConfirm.setBorder(null);
		buttonConfirm.setBounds(154, 435, 52, 53);
		buttonConfirm.setCursor(Util.CURSOR);
		buttonConfirm.setToolTipText("<html><center><strong>CONFIRMAR</strong></center></html>");

		this.windowDialog = window;

		add(labelTitle);
		add(labelContent);
		add(buttonConfirm);
		add(buttonClose);
		add(labelBackground);

		setVisible(false);

	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public JLabel getLabelBackground() {
		return labelBackground;
	}

	public void setLabelBackground(JLabel labelBackground) {
		this.labelBackground = labelBackground;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JLabel getLabelContent() {
		return labelContent;
	}

	public void setLabelContent(JLabel labelContent) {
		this.labelContent = labelContent;
	}

	public JButton getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	public void setButtonConfirm(JButton buttonConfirm) {
		this.buttonConfirm = buttonConfirm;
	}

	public ImageIcon getImgButtonDoneNormal() {
		return imgButtonDoneNormal;
	}

	public void setImgButtonDoneNormal(ImageIcon imgButtonDoneNormal) {
		this.imgButtonDoneNormal = imgButtonDoneNormal;
	}

	public ImageIcon getImgButtonDoneHover() {
		return imgButtonDoneHover;
	}

	public void setImgButtonDoneHover(ImageIcon imgButtonDoneHover) {
		this.imgButtonDoneHover = imgButtonDoneHover;
	}

	public ImageIcon getImgButtonDoneClick() {
		return imgButtonDoneClick;
	}

	public void setImgButtonDoneClick(ImageIcon imgButtonDoneClick) {
		this.imgButtonDoneClick = imgButtonDoneClick;
	}

	public ImageIcon getImgButtonDoneLocked() {
		return imgButtonDoneLocked;
	}

	public void setImgButtonDoneLocked(ImageIcon imgButtonDoneLocked) {
		this.imgButtonDoneLocked = imgButtonDoneLocked;
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

}
