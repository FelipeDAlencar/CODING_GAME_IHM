package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChoicePhases extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel labelbackground, labelTitle;
	private JButton buttonClose, buttonPhase1, buttonPhase2, buttonPhase3, buttonPhase4, butttonLock;

	public ChoicePhases() {

		labelbackground = new JLabel(
				new ImageIcon(getClass().getClassLoader().getResource("assets/background_phases.jpeg")));
		labelbackground.setBounds(0, 0, WindowMain.WIDTH, WindowMain.HEIGHT);
			
		int width = 120;
		int height = 200;
		buttonPhase1 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/phase_01_button.png")));
		buttonPhase1.setContentAreaFilled(false);
		buttonPhase1.setBorder(null);
		buttonPhase1.setBounds(510, 200, width, height);
		buttonPhase1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonPhase1.setToolTipText("<html><center><strong>IR PARA FASE 01</strong></center></html>");
		
		buttonPhase2 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/phase_lock.png")));
		buttonPhase2.setContentAreaFilled(false);
		buttonPhase2.setBorder(null);
		buttonPhase2.setBounds(760, 200, width, height);
		buttonPhase2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonPhase2.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");
		
		buttonPhase3 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/phase_lock.png")));
		buttonPhase3.setContentAreaFilled(false);
		buttonPhase3.setBorder(null);
		buttonPhase3.setBounds(510, 400, width, height);
		buttonPhase3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonPhase3.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");
		
		buttonPhase4 = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/phase_lock.png")));
		buttonPhase4.setContentAreaFilled(false);
		buttonPhase4.setBorder(null);
		buttonPhase4.setBounds(760, 400, width, height);
		buttonPhase4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonPhase4.setToolTipText("<html><center><strong>FASE NÃO DISPONÍVEL</strong></center></html>");
		
	
		
		labelTitle = new JLabel("<html><center><strong>FASES</strong></center></html>");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(new Font("Arial Bold", Font.BOLD, 40));
		labelTitle.setBounds(613, 83, 200, 100);
		
		
		
		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setBounds(643, 590, 50, 52);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");
		
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

	
	
}
