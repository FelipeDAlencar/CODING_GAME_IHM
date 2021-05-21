package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.Start;
import br.com.ihm.coding_in_game.view.Window;

public class ControllerStart implements ActionListener{
	
	private Start startPanel;
	private Window window;
	public ControllerStart(Window window) {
		this.startPanel = window.getStart();
		this.window = window;
		
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
		
		if(e.getSource() == startPanel.getjButtonClose()) {
			System.exit(0);
		}else if(e.getSource() == startPanel.getjButtonStartGame()) {
			window.getStart().setVisible(false);
			window.getPhase().setVisible(true);
			window.getPhase().requestFocus();
			window.getInventory().setVisible(true);
		}else if(e.getSource() == startPanel.getjButtonHelp()) {
			System.out.println("Help");
		}else {
			System.out.println("Settings");
		}
		
	}

}
