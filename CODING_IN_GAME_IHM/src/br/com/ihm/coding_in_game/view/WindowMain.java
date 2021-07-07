package br.com.ihm.coding_in_game.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WindowMain extends Window implements KeyListener {
	public static int WIDTH, HEIGHT;
	private Inventory inventory;
	private Phase phase;
	private Start start;
	private static final long serialVersionUID = 1L;
	private Phase phase1, phase2, phase3, phase4;

	public WindowMain(int width, int height) {
		super(width, height);
		WIDTH = width;
		HEIGHT = height;
		setSize(width, height);

		phase1 = new Phase_01();
		phase2 = new Phase_02();
		phase3 = new Phase_03();
		phase4 = new Phase_04();

		phase = phase1;
		// Instantiation views
		inventory = new Inventory(phase);
		start = new Start();

		// Add key listenner
		addKeyListener(this);

		add(inventory);
		add(phase4);
		add(phase3);
		add(phase2);
		add(phase1);
		add(phase);
		add(start);

		setVisible(true);

	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_ESCAPE) {
			System.exit(0);

		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}

	public Phase getPhase2() {
		return phase2;
	}

	public void setPhase2(Phase phase2) {
		this.phase2 = phase2;
	}

	public Phase getPhase3() {
		return phase3;
	}

	public void setPhase3(Phase phase3) {
		this.phase3 = phase3;
	}

	public Phase getPhase4() {
		return phase4;
	}

	public void setPhase4(Phase phase4) {
		this.phase4 = phase4;
	}

	public Phase getPhase1() {
		return phase1;
	}

	public void setPhase1(Phase phase1) {
		this.phase1 = phase1;
	}

}
