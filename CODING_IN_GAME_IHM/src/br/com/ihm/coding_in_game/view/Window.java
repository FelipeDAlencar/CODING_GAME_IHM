package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame implements KeyListener {
	public static int WIDTH, HEIGHT;
	private Inventory inventory;
	private Console console;
	private World world;
	private static final long serialVersionUID = 1L;

	public Window(int largura, int altura) {
		super("CODING IN GAME");
		WIDTH = largura;
		HEIGHT = altura;
		setSize(largura, altura);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);

		// Instantiation
		inventory = new Inventory();
		console = new Console();

		addKeyListener(this);

		add(console);
		add(inventory);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();

		if (codigo == KeyEvent.VK_ESCAPE) {
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
}
