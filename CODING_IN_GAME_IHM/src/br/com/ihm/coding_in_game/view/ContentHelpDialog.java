package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import br.com.ihm.coding_in_game.model.Util;

public class ContentHelpDialog extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelBackground, labelTitle, labelContent, labelLink;
	private JButton buttonClose;
	private WindowDialog windowDialog;
	private ImageIcon imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked;

	public ContentHelpDialog(WindowDialog windowDialog) {

		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelBackground.setBounds(0, 0, 616, 470);
		
		labelTitle = new JLabel("AJUDA");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(240, 15, 150, 50);

		labelContent = new JLabel(
				"Vídeo-tutorial de ajuda no link a seguir:");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(Util.FONT_CONTENT);
		labelContent.setBounds(70, 130, 500, 30);

		labelLink = new JLabel("https://www.youtube.com/");
		labelLink.setForeground(new Color(61, 57, 57));
		labelLink.setFont(Util.FONT_CONTENT);
		labelLink.setBounds(70, 165, 250, 30);
		labelLink.setToolTipText("<html><center><strong>CLIQUE PARA SER LEVADO AO VÍDEO</strong></center></html>");
		labelLink.setCursor(Util.CURSOR);
		labelLink.setBackground(Color.red);

		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(280, 435, 50, 52);
		buttonClose.setCursor(Util.CURSOR);
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		this.windowDialog = windowDialog;

		add(labelTitle);
		add(labelContent);
		add(labelLink);
		add(buttonClose);
		add(labelBackground);

		setVisible(false);
	}

	public JLabel getLabelContent() {
		return labelBackground;
	}

	public void setLabelContent(JLabel labelContent) {
		this.labelBackground = labelContent;
	}

	public JButton getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JLabel getLabelLink() {
		return labelLink;
	}

	public void setLabelLink(JLabel labelLink) {
		this.labelLink = labelLink;
	}

	public JLabel getLabelBackground() {
		return labelBackground;
	}

	public void setLabelBackground(JLabel labelBackground) {
		this.labelBackground = labelBackground;
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
