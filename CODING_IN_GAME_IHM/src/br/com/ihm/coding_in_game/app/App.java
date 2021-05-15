package br.com.ihm.coding_in_game.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import br.com.ihm.coding_in_game.view.Window;

public class App {

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		Window window = new Window(width, height);
	}

}
