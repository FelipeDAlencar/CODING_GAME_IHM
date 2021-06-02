package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.ConfirmExitDialog;

public class ControllerConfirmExit implements ActionListener {
	private ConfirmExitDialog confirmExit;

	public ControllerConfirmExit(ConfirmExitDialog confirmExit) {
		this.confirmExit = confirmExit;

		this.confirmExit.getButtonClose().addActionListener(this);
		this.confirmExit.getButtonConfirm().addActionListener(this);
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmExit.getButtonClose()) {
			confirmExit.setVisible(false);
			confirmExit.getWindowDialog().getWindowParent().setEnabled(true);
			confirmExit.getWindowDialog().setVisible(false);
			
		} else {
			System.exit(0);
		}

	}

}
