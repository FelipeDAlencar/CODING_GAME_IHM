package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.ConfirmExit;

public class ControllerConfirmExit implements ActionListener {
	private ConfirmExit confirmExit;

	public ControllerConfirmExit(ConfirmExit confirmExit) {
		this.confirmExit = confirmExit;

		this.confirmExit.getButtonClose().addActionListener(this);
		this.confirmExit.getButtonConfirm().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmExit.getButtonClose()) {
			confirmExit.getWindow().setVisible(false);
		} else {
			System.exit(0);
		}

	}

}
