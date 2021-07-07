package br.com.ihm.coding_in_game.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import br.com.ihm.coding_in_game.model.Util;

public class GeneralContentDialog extends Panel {
	private static final long serialVersionUID = 1L;
	private JLabel labelTitle, labelContent, labelBackground, labelBomb, labelFlags, labelDelimiter;
	private JButton buttonClose, buttonRight, buttonLeft;
	private WindowDialog windowDialog;
	private ImageIcon imgButtonCloseNormal, imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked,
			imgButtonMoveRightNormal, imgButtonMoveRightHover, imgButtonMoveRightClick, imgButtonMoveRightLocked,
			imgButtonMoveLeftNormal, imgButtonMoveLeftHover, imgButtonMoveLeftClick, imgButtonMoveLeftLocked, imgFlag, imgBomb, imgDelimiter;
	private boolean isButtonRightVisible, isButtonLeftVisible;
	private String infoFlag, infoBomb, infoDelimiter;
	
	public GeneralContentDialog(WindowDialog windowDialog) {
		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		this.windowDialog = windowDialog;

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));
		
		
		imgButtonMoveRightNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_pass_right.png"));
		imgButtonMoveRightHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_pass_right.png"));
		imgButtonMoveRightClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_pass_right.png"));
		imgButtonMoveRightLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_pass_right.png"));

		
		imgButtonMoveLeftNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_pass_left.png"));
		imgButtonMoveLeftHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_pass_left.png"));
		imgButtonMoveLeftClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_pass_left.png"));
		imgButtonMoveLeftLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_pass_left.png"));

		
		imgFlag = new ImageIcon(getClass().getClassLoader().getResource("assets/flags.png"));
		imgDelimiter = new ImageIcon(getClass().getClassLoader().getResource("assets/delimiter.png"));
		imgBomb = new ImageIcon(getClass().getClassLoader().getResource("assets/bomb.png"));
		
		//Colete as bandeiras espalhadas pelo cenário usando os métodos dispoíveis. Cuidado com as bombas
		
		infoFlag = "Colete as bandeiras espalhadas pelo cenário";
		infoDelimiter = "Siga os delimitadores para mover seu personagem";
		infoBomb = "Tome cuidado com as bombas";
		
		labelFlags = new JLabel(imgFlag);
		labelFlags.setBounds(500, 130,16,46);
		labelFlags.setVisible(false);
		
		labelDelimiter = new JLabel(imgDelimiter);
		labelDelimiter.setBounds(70, 160,16,46);
		labelDelimiter.setVisible(false);
		
		
		labelBomb = new JLabel(imgBomb);
		labelBomb.setBounds(370, 130,16,46);
		labelBomb.setVisible(false);

		
		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelBackground.setBounds(0, 0, 616, 470);

		buttonClose = new JButton(imgButtonCloseNormal);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(280, 435, 50, 52);
		buttonClose.setCursor(Util.CURSOR);
		buttonClose.setToolTipText("<html><center><strong>FECHAR</strong></center></html>");
		
		buttonRight = new JButton(imgButtonMoveRightNormal);
		buttonRight.setContentAreaFilled(false);
		buttonRight.setBorder(null);
		buttonRight.setBounds(400, 435, 50, 52);
		buttonRight.setCursor(Util.CURSOR);
		buttonRight.setToolTipText("<html><center><strong>PRÓXIMO</strong></center></html>");
		buttonRight.setVisible(false);
		
		buttonLeft = new JButton(imgButtonMoveLeftNormal);
		buttonLeft.setContentAreaFilled(false);
		buttonLeft.setBorder(null);
		buttonLeft.setBounds(160, 435, 50, 52);
		buttonLeft.setCursor(Util.CURSOR);
		buttonLeft.setToolTipText("<html><center><strong>VOLTAR</strong></center></html>");
		buttonLeft.setVisible(false);

		labelTitle = new JLabel("");
		labelTitle.setForeground(new Color(50, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(295, -25, 200, 100);

		labelContent = new JLabel("");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(Util.FONT_CONTENT);
		labelContent.setBounds(60, 80, 300, 300);
		
		add(labelBomb);
		add(labelDelimiter);
		add(labelFlags);
		add(labelTitle);
		add(labelContent);
		add(buttonLeft);
		add(buttonRight);
		add(buttonClose);
		add(labelBackground);

		setVisible(false);

	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JLabel getLabelBackground() {
		return labelBackground;
	}

	public void setLabelBackground(JLabel labelBackground) {
		this.labelBackground = labelBackground;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
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

	public ImageIcon getImgButtonMoveRightNormal() {
		return imgButtonMoveRightNormal;
	}

	public void setImgButtonMoveRightNormal(ImageIcon imgButtonMoveRightNormal) {
		this.imgButtonMoveRightNormal = imgButtonMoveRightNormal;
	}

	public ImageIcon getImgButtonMoveRightHover() {
		return imgButtonMoveRightHover;
	}

	public void setImgButtonMoveRightHover(ImageIcon imgButtonMoveRightHover) {
		this.imgButtonMoveRightHover = imgButtonMoveRightHover;
	}

	public ImageIcon getImgButtonMoveRightClick() {
		return imgButtonMoveRightClick;
	}

	public void setImgButtonMoveRightClick(ImageIcon imgButtonMoveRightClick) {
		this.imgButtonMoveRightClick = imgButtonMoveRightClick;
	}

	public ImageIcon getImgButtonMoveRightLocked() {
		return imgButtonMoveRightLocked;
	}

	public void setImgButtonMoveRightLocked(ImageIcon imgButtonMoveRightLocked) {
		this.imgButtonMoveRightLocked = imgButtonMoveRightLocked;
	}

	public ImageIcon getImgButtonMoveLeftNormal() {
		return imgButtonMoveLeftNormal;
	}

	public void setImgButtonMoveLeftNormal(ImageIcon imgButtonMoveLeftNormal) {
		this.imgButtonMoveLeftNormal = imgButtonMoveLeftNormal;
	}

	public ImageIcon getImgButtonMoveLeftHover() {
		return imgButtonMoveLeftHover;
	}

	public void setImgButtonMoveLeftHover(ImageIcon imgButtonMoveLeftHover) {
		this.imgButtonMoveLeftHover = imgButtonMoveLeftHover;
	}

	public ImageIcon getImgButtonMoveLeftClick() {
		return imgButtonMoveLeftClick;
	}

	public void setImgButtonMoveLeftClick(ImageIcon imgButtonMoveLeftClick) {
		this.imgButtonMoveLeftClick = imgButtonMoveLeftClick;
	}

	public ImageIcon getImgButtonMoveLeftLocked() {
		return imgButtonMoveLeftLocked;
	}

	public void setImgButtonMoveLeftLocked(ImageIcon imgButtonMoveLeftLocked) {
		this.imgButtonMoveLeftLocked = imgButtonMoveLeftLocked;
	}

	public JButton getButtonRight() {
		return buttonRight;
	}

	public void setButtonRight(JButton buttonRight) {
		this.buttonRight = buttonRight;
	}

	public JButton getButtonLeft() {
		return buttonLeft;
	}

	public void setButtonLeft(JButton buttonLeft) {
		this.buttonLeft = buttonLeft;
	}

	public boolean isButtonRightVisible() {
		return isButtonRightVisible;
	}

	public void setButtonRightVisible(boolean isButtonRightVisible) {
		this.isButtonRightVisible = isButtonRightVisible;
	}

	public boolean isButtonLeftVisible() {
		return isButtonLeftVisible;
	}

	public void setButtonLeftVisible(boolean isButtonLeftVisible) {
		this.isButtonLeftVisible = isButtonLeftVisible;
	}

	public ImageIcon getImgFlag() {
		return imgFlag;
	}

	public void setImgFlag(ImageIcon imgFlag) {
		this.imgFlag = imgFlag;
	}

	public ImageIcon getImgBomb() {
		return imgBomb;
	}

	public void setImgBomb(ImageIcon imgBomb) {
		this.imgBomb = imgBomb;
	}

	public ImageIcon getImgDelimiter() {
		return imgDelimiter;
	}

	public void setImgDelimiter(ImageIcon imgDelimiter) {
		this.imgDelimiter = imgDelimiter;
	}

	public String getInfoFlag() {
		return infoFlag;
	}

	public void setInfoFlag(String infoFlag) {
		this.infoFlag = infoFlag;
	}

	public String getInfoBomb() {
		return infoBomb;
	}

	public void setInfoBomb(String infoBomb) {
		this.infoBomb = infoBomb;
	}

	public String getInfoDelimiter() {
		return infoDelimiter;
	}

	public void setInfoDelimiter(String infoDelimiter) {
		this.infoDelimiter = infoDelimiter;
	}

	public JLabel getLabelBomb() {
		return labelBomb;
	}

	public void setLabelBomb(JLabel labelBomb) {
		this.labelBomb = labelBomb;
	}

	public JLabel getLabelFlags() {
		return labelFlags;
	}

	public void setLabelFlags(JLabel labelFlags) {
		this.labelFlags = labelFlags;
	}

	public JLabel getLabelDelimiter() {
		return labelDelimiter;
	}

	public void setLabelDelimiter(JLabel labelDelimiter) {
		this.labelDelimiter = labelDelimiter;
	}
	
	
	
}
