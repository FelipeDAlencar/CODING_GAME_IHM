package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class SettingsDialog extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelBackground, labelTitle, labelSound, labelVelocity;
	private JButton buttonCancel, buttonConfirm;
	private JSlider sliderVelocity;
	private JCheckBox checkBoxSound;
	private WindowDialog windowDialog;

	public SettingsDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;

		setBounds(0, 0, 683, 384);
		setBackground(new Color(0, 0, 0, 0));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/dialog.png")));
		labelBackground.setBounds(0, 0, 683, 384);

		labelTitle = new JLabel("<html><center><strong>AJUSTES</strong></center></html>");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 40));
		labelTitle.setBounds(250, -25, 250, 100);

		labelSound = new JLabel("<html><center><strong>Som:</strong></center></html>");
		labelSound.setForeground(new Color(61, 57, 57));
		labelSound.setFont(new Font("Arial Bold", Font.BOLD, 30));
		labelSound.setBounds(60, 60, 100, 100);

		checkBoxSound = new JCheckBox();
		checkBoxSound.setBounds(140, 98, 30, 30);

		labelVelocity = new JLabel("<html><center><strong>Velocidade:</strong></center></html>");
		labelVelocity.setForeground(new Color(61, 57, 57));
		labelVelocity.setFont(new Font("Arial Bold", Font.BOLD, 30));
		labelVelocity.setBounds(60, 130, 170, 100);

		sliderVelocity = new JSlider(1, 5);
		sliderVelocity.setBounds(235, 145, 200, 100);
		sliderVelocity.setPaintTrack(true);
		sliderVelocity.setPaintTicks(true);
		sliderVelocity.setPaintLabels(true);
		sliderVelocity.setMajorTickSpacing(1);
		sliderVelocity.setMinorTickSpacing(1);
		
	

		

		buttonCancel = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonCancel.setContentAreaFilled(false);
		buttonCancel.setBorder(null);
		buttonCancel.setBounds(360, 320, 50, 52);
		buttonCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonCancel.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		buttonConfirm = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/done.png")));
		buttonConfirm.setContentAreaFilled(false);
		buttonConfirm.setBorder(null);
		buttonConfirm.setBounds(280, 320, 50, 52);
		buttonConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonConfirm.setToolTipText("<html><center><strong>CONFIRMAR</strong></center></html>");

		add(sliderVelocity);
		add(labelVelocity);
		add(labelSound);
		add(checkBoxSound);
		add(buttonConfirm);
		add(buttonCancel);
		add(labelTitle);
		add(labelBackground);

		setVisible(false);

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

	public JLabel getLabelSound() {
		return labelSound;
	}

	public void setLabelSound(JLabel labelSound) {
		this.labelSound = labelSound;
	}

	public JLabel getLabelVelocity() {
		return labelVelocity;
	}

	public void setLabelVelocity(JLabel labelVelocity) {
		this.labelVelocity = labelVelocity;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(JButton buttonCancel) {
		this.buttonCancel = buttonCancel;
	}

	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	public void setButtonConfirm(JButton buttonConfirm) {
		this.buttonConfirm = buttonConfirm;
	}

	

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public JSlider getSliderVelocity() {
		return sliderVelocity;
	}

	public void setSliderVelocity(JSlider sliderVelocity) {
		this.sliderVelocity = sliderVelocity;
	}

	public JCheckBox getCheckBoxSound() {
		return checkBoxSound;
	}

	public void setCheckBoxSound(JCheckBox checkBoxSound) {
		this.checkBoxSound = checkBoxSound;
	}

}
