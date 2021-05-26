package br.com.ihm.coding_in_game.view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	private int width, height;

	public Window(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);

		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);

		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/iconApp.png"));
		this.setIconImage(icon);

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
