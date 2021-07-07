package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.ihm.coding_in_game.model.moveHeroThread;
import br.com.ihm.coding_in_game.view.Phase;
import br.com.ihm.coding_in_game.view.WindowDialog;

public class ControllerPhase implements ActionListener, KeyListener {

	private Phase phase;
	private WindowDialog windowDialog;
	private moveHeroThread moveHeroThread;

	public ControllerPhase(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
		this.phase = this.windowDialog.getWindowParent().getPhase();
		phase.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	
	
	public moveHeroThread getMoveHeroThread() {
		return moveHeroThread;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public void setMoveHeroThread(moveHeroThread moveHeroThread) {
		this.moveHeroThread = moveHeroThread;
	}

}
