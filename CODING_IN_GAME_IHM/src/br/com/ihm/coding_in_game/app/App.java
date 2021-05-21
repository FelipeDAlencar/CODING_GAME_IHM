package br.com.ihm.coding_in_game.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import br.com.ihm.coding_in_game.controller.ControllerInventory;
import br.com.ihm.coding_in_game.controller.ControllerPhase01;
import br.com.ihm.coding_in_game.controller.ControllerStart;
import br.com.ihm.coding_in_game.view.Window;

public class App {

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		Window window = new Window(width, height);
		
		ControllerStart controllerStart = new ControllerStart(window);
		ControllerPhase01 controllerPhase01 = new ControllerPhase01(window);
		ControllerInventory controllerInventory = new ControllerInventory(window);
	}

}
