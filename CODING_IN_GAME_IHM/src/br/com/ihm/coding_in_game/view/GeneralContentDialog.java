package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GeneralContentDialog extends Panel {
	private static final long serialVersionUID = 1L;
	private JLabel labelTitle, labelContent, labelBackground;
	private JButton buttonClose;
	private WindowDialog windowDialog;

	public GeneralContentDialog(WindowDialog windowDialog) {
		setBounds(0, 0, 683, 384);
		setBackground(new Color(0, 0, 0, 0));

		this.windowDialog = windowDialog;
		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/dialog.png")));
		labelBackground.setBounds(0, 0, 683, 384);

		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(315, 320, 50, 52);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>FECHAR</strong></center></html>");
		
		// title <html><center><strong>INFO</strong></center></html>
		// content "<html><center><strong>Colete as bandeiras espalhadas pelo cenário
		// usando os métodos dispoíveis. Cuidado com as
		// bombas.</strong></center></html>"
		labelTitle = new JLabel("");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 40));
		labelTitle.setBounds(295, -25, 200, 100);

		labelContent = new JLabel("");
		labelContent.setForeground(new Color(61, 57, 57));
		labelContent.setFont(new Font("Arial Bold", Font.BOLD, 20));
		labelContent.setBounds(60, 80, 600, 100);

		add(labelTitle);
		add(labelContent);
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

}
