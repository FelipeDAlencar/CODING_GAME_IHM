package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.model.moveHeroThread;
import br.com.ihm.coding_in_game.view.Phase;
import br.com.ihm.coding_in_game.view.Window;

public class ControllerPhase01 implements ActionListener, KeyListener {

	private Phase phase;
	private Window window;
	private moveHeroThread moveHeroThread;

	public ControllerPhase01(Window window) {
		this.window = window;
		this.phase = this.window.getPhase();
		moveHeroThread = new moveHeroThread(phase.getHero());
		System.out.println(phase.getHero());

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

		} else if (code == KeyEvent.VK_UP) {
			moveHeroThread.setMove(Util.UP);
		} else if (code == KeyEvent.VK_DOWN) {
			moveHeroThread.setMove(Util.DOWN);
		} else if (code == KeyEvent.VK_LEFT) {
			moveHeroThread.setMove(Util.LEFT);
		} else if (code == KeyEvent.VK_RIGHT) {
			moveHeroThread.setMove(Util.RIGHT);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP) {
			 moveHeroThread.setMove("parar");
		} else if (code == KeyEvent.VK_DOWN) {
			moveHeroThread.setMove("parar");
		} else if (code == KeyEvent.VK_LEFT) {
			moveHeroThread.setMove("parar");
		} else if (code == KeyEvent.VK_RIGHT) {
			moveHeroThread.setMove("parar");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
