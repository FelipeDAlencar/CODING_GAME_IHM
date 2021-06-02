package br.com.ihm.coding_in_game.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class WindowMain extends Window implements KeyListener {
	public static int WIDTH, HEIGHT;
	private Inventory inventory;
	private Phase_01 phase;
	private ChoicePhases choicePhases;
	private Start start;
	
	private static final long serialVersionUID = 1L;

	public WindowMain(int width, int height) {
		super(width, height);
		WIDTH = width;
		HEIGHT = height;
		setSize(width, height);

		// Instantiation views
		inventory = new Inventory();
		phase = new Phase_01();
		start = new Start();
		choicePhases = new ChoicePhases();

		// Add key listenner
		addKeyListener(this);

		add(inventory);
		add(phase);
		add(start);
		add(choicePhases);

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

	

	public Phase_01 getPhase() {
		return phase;
	}

	public void setPhase(Phase_01 phase) {
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

	public ChoicePhases getChoicePhases() {
		return choicePhases;
	}

	public void setChoicePhases(ChoicePhases choicePhases) {
		this.choicePhases = choicePhases;
	}
	
	

}
