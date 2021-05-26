package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ContentHelp extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelBackground, labelTitle, labelContent, labelLink;
	private JButton buttonClose;
	private Window window;

	public ContentHelp(Window window) {

		setBounds(0, 0, 683, 384);
		setBackground(new Color(0, 0, 0, 0));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/dialog.png")));
		labelBackground.setBounds(0, 0, 683, 384);

		labelTitle = new JLabel("<html><center><strong>AJUDA</strong></center></html>");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 40));
		labelTitle.setBounds(280, -25, 200, 100);

		labelContent = new JLabel(
				"<html><center><strong>Vídeo-tutorial de ajuda no link a seguir:</strong></center></html>");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(new Font("Arial Bold", Font.BOLD, 30));
		labelContent.setBounds(60, 60, 600, 100);
		
		
		
		labelLink = new JLabel("<html><center><strong>https://www.youtube.com/</strong></center></html>");
		labelLink.setForeground(new Color(61, 57, 57));
		labelLink.setFont(new Font("Arial Bold", Font.BOLD, 30));
		labelLink.setBounds(60, 120, 400, 100);
		labelLink.setToolTipText("<html><center><strong>Clique para ser levado ao vídeo</strong></center></html>");
		labelLink.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		labelLink.setBackground(Color.red);
		
		
		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(320, 320, 50, 52);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		this.window = window;

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

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
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
	
	
	
	

}
