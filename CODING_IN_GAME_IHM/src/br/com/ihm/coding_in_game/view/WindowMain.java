package br.com.ihm.coding_in_game.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;

public class WindowMain extends Window implements KeyListener {
	public static int WIDTH, HEIGHT;
	private Inventory inventory;
	private Phase_01 phase01;
	private ChoicePhases choicePhases;
	private Start start;
	private Player player;
	private Hero hero;
	private static final long serialVersionUID = 1L;

	public WindowMain(int width, int height, Player player) {
		super(width, height);
		WIDTH = width;
		HEIGHT = height;
		this.player = player;
		setSize(width, height);

		// Instantiation views
		try {
			hero = new Hero(1, 64, 126, 4, 4, Hero.INITIAL_X, Hero.INITIAL_Y, "/assets/sprite.png");

			inventory = new Inventory(this.player, this.hero);
			phase01 = new Phase_01(this.player, this.hero);
			start = new Start();
			choicePhases = new ChoicePhases();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Add key listenner
		addKeyListener(this);

		add(inventory);
		add(phase01);
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

	public Phase_01 getPhase01() {
		return phase01;
	}

	public void setPhase01(Phase_01 phase) {
		this.phase01 = phase;
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
