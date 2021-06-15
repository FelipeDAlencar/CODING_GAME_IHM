package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.ihm.coding_in_game.view.ChoicePhases;
import br.com.ihm.coding_in_game.view.Window;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerChoicePhases implements ActionListener {

	private WindowMain windowMain;
	private WindowDialog WindowDialog;
	private ChoicePhases choicePhases;

	public ControllerChoicePhases(WindowMain windowMain, WindowDialog windowDialog) {
		this.windowMain = windowMain;
		this.WindowDialog = windowDialog;

		choicePhases = this.windowMain.getChoicePhases();

		init();

	}

	private void init() {
		choicePhases.getButtonClose().addActionListener(this);
		choicePhases.getButtonPhase1().addActionListener(this);
		choicePhases.getButtonPhase2().addActionListener(this);
		choicePhases.getButtonPhase3().addActionListener(this);
		choicePhases.getButtonPhase4().addActionListener(this);
		// choicePhases.getButttonLock().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choicePhases.getButtonClose()) {
			windowMain.getStart().setVisible(true);
			windowMain.getChoicePhases().setVisible(false);
		} else if (e.getSource() == choicePhases.getButtonPhase1()) {
			windowMain.getStart().setVisible(false);
			windowMain.getPhase01().setVisible(true);
			windowMain.getPhase01().requestFocus();
			windowMain.getInventory().setVisible(true);
			windowMain.getChoicePhases().setVisible(false);

		} else if (e.getSource() == choicePhases.getButtonPhase2()) {

		} else if (e.getSource() == choicePhases.getButtonPhase3()) {

		} else if (e.getSource() == choicePhases.getButtonPhase4()) {

		}

	}

}
