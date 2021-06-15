package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.model.moveHeroThread;
import br.com.ihm.coding_in_game.view.Phase;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerPhase implements ActionListener, KeyListener {

	private Phase phase;
	private WindowMain window;
	private moveHeroThread moveHeroThread;

	public ControllerPhase(WindowMain window) {
		this.window = window;
		this.phase = this.window.getPhase01();
		moveHeroThread = new moveHeroThread(phase.getHero());

		phase.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
