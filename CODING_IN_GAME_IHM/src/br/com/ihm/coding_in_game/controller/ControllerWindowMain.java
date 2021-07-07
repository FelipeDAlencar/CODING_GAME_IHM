package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerWindowMain implements ActionListener {

	private WindowMain window;
	
	public ControllerWindowMain(WindowMain window) {
		this.window = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		
	}

	public WindowMain getWindow() {
		return window;
	}

	public void setWindow(WindowMain window) {
		this.window = window;
	}
	
	

	
	
}
