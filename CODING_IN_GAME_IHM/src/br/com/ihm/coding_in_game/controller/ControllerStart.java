package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.Start;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerStart implements ActionListener {

	private Start startPanel;
	private WindowMain windowMain;
	private WindowDialog windowDialog;
	private ControllerContentHelp controllerContentHelp;
	private ControllerConfirmExit controllerConfirmExit;
	private ControllerSettings controllerSettings;

	public ControllerStart(WindowMain window) {
		this.startPanel = window.getStart();
		this.windowMain = window;
		windowDialog = new WindowDialog(WindowMain.WIDTH / 2, WindowMain.HEIGHT / 2);
		controllerContentHelp = new ControllerContentHelp(windowDialog.getContentHelp());
		controllerConfirmExit = new ControllerConfirmExit(windowDialog.getConfirmExit());
		controllerSettings = new ControllerSettings(windowDialog.getSettings());
		
		init();
	}

	private void init() {
		startPanel.getjButtonClose().addActionListener(this);
		startPanel.getjButtonHelp().addActionListener(this);
		startPanel.getjButtonSettings().addActionListener(this);
		startPanel.getjButtonStartGame().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == startPanel.getjButtonClose()) {
			windowDialog.getConfirmExit().setVisible(true);
			windowDialog.setVisible(true);
		} else if (e.getSource() == startPanel.getjButtonStartGame()) {
			windowMain.getStart().setVisible(false);
			windowMain.getPhase().setVisible(true);
			windowMain.getPhase().requestFocus();
			windowMain.getInventory().setVisible(true);
		} else if (e.getSource() == startPanel.getjButtonHelp()) {
			windowDialog.getContentHelp().setVisible(true);
			
			windowDialog.setVisible(true);
		} else {
			windowDialog.getSettings().setVisible(true);
			windowDialog.setVisible(true);
			
		}

	}

}
