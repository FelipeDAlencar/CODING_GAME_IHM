package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ContentHelp extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelContent;
	private JButton buttonClose;
	private Window window;

	public ContentHelp(Window window) {
		
		setBounds(0, 0, 683, 384);
		setBackground(new Color(0, 0, 0, 0));
		
		labelContent = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/text_help_start.png")));
		labelContent.setBounds(0, 0, 683, 384);

		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(320, 320, 50, 52);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>FECHAR</strong></center></html>");
		
		this.window = window;

		add(buttonClose);
		add(labelContent);

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

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

}
