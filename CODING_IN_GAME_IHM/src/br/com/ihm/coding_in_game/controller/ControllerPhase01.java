package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.ihm.coding_in_game.view.Phase;
import br.com.ihm.coding_in_game.view.Window;

public class ControllerPhase01 implements ActionListener, KeyListener {

	private Phase phase;
	private Window window;

	public ControllerPhase01( Window window) {
		this.window = window;
		this.phase = this.window.getPhase();
		phase.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ESCAPE) {
			System.exit(0);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
