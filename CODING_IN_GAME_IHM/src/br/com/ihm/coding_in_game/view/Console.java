package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Console extends Panel {

	private static final long serialVersionUID = 1L;

	private BufferedImage imgConsole;

	Console() {

		setBounds(0, 668, 1066, 100);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			g.drawImage(ImageIO.read(getClass().getResource("/assets/console.png")), 0, -50, 1075, 200, null);
		} catch (IOException e) {
			System.out.println("ERROR: IMAGE NOT FOUND.");
			e.printStackTrace();
		}

	}

	public BufferedImage getImgConsole() {
		return imgConsole;
	}

	public void setImgConsole(BufferedImage imgConsole) {
		this.imgConsole = imgConsole;
	}

}
