package br.com.ihm.coding_in_game.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ihm.coding_in_game.controller.ControllerInventory;
import br.com.ihm.coding_in_game.controller.ControllerPhase01;
import br.com.ihm.coding_in_game.controller.ControllerStart;
import br.com.ihm.coding_in_game.view.WindowMain;

public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		//UIManager.put("ToolTip.foreground", new ColorUIResource(Color.red));
		//UIManager.put("ToolTip.background", new ColorUIResource(Color.yellow));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		WindowMain window = new WindowMain(width, height);
		
		@SuppressWarnings("unused")
		ControllerStart controllerStart = new ControllerStart(window);
		ControllerPhase01 controllerPhase01 = new ControllerPhase01(window);
		ControllerInventory controllerInventory = new ControllerInventory(window);
		
		
	}

}
