package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ConfirmExit extends Panel{
	
	private Window window;
	private JLabel labelBackground, labelTitle, labelContent;
	private JButton buttonClose, buttonConfirm;
	private static final long serialVersionUID = 1L;

	
	public ConfirmExit(Window window) {
		setBounds(0, 0, 683, 384);
		setBackground(new Color(0, 0, 0, 0));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/dialog.png")));
		labelBackground.setBounds(0, 0, 683, 384);

		labelTitle = new JLabel("<html><center><strong>SAIR</strong></center></html>");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 40));
		labelTitle.setBounds(290, -25, 200, 100);

		labelContent = new JLabel(
				"<html><center><strong>Deseja realmente sair?</strong></center></html>");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(new Font("Arial Bold", Font.BOLD, 30));
		labelContent.setBounds(60, 60, 600, 100);
		
		
		
		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(340, 320, 50, 52);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>FECHAR</strong></center></html>");
		
		
		buttonConfirm = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/done.png")));
		buttonConfirm.setContentAreaFilled(false);
		buttonConfirm.setBorder(null);
		buttonConfirm.setBounds(260, 320, 50, 52);
		buttonConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonConfirm.setToolTipText("<html><center><strong>CONFIRMAR</strong></center></html>");

		this.window = window;

		add(labelTitle);
		add(labelContent);
		add(buttonConfirm);
		add(buttonClose);
		add(labelBackground);
		
		setVisible(false);
	
	}


	public Window getWindow() {
		return window;
	}


	public void setWindow(Window window) {
		this.window = window;
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
	
	
	
	
	

}
