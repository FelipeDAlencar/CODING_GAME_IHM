package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.GeneralContentDialog;

public class ControllerGeneralContentDialog implements ActionListener {

	private GeneralContentDialog generalContentDialog;

	public ControllerGeneralContentDialog(GeneralContentDialog generalContentDialog) {
		this.generalContentDialog = generalContentDialog;
		init();
	}

	private void init() {
		generalContentDialog.getButtonClose().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generalContentDialog.getButtonClose()) {
			generalContentDialog.setVisible(false);
			generalContentDialog.getWindowDialog().getWindowParent().setEnabled(true);
			generalContentDialog.getWindowDialog().setVisible(false);

		}
	}

}
