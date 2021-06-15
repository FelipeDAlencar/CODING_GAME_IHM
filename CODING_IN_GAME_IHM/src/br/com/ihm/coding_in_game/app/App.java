package br.com.ihm.coding_in_game.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ihm.coding_in_game.controller.ControllerChoicePhases;
import br.com.ihm.coding_in_game.controller.ControllerInventory;
import br.com.ihm.coding_in_game.controller.ControllerPhase;
import br.com.ihm.coding_in_game.controller.ControllerStart;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.view.WindowDialog;
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
		
		Player player =	new Player("Felipe", 0);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		WindowMain windowMain = new WindowMain(width, height, player);
		WindowDialog windowDialog = new WindowDialog(WindowMain.WIDTH / 2, WindowMain.HEIGHT / 2, windowMain);
		
		
		
		@SuppressWarnings("unused")
		ControllerStart controllerStart = new ControllerStart(windowMain, windowDialog);
		ControllerPhase controllerPhase01 = new ControllerPhase(windowMain);
		ControllerInventory controllerInventory = new ControllerInventory(windowDialog);
		ControllerChoicePhases controllerChoicePhases = new ControllerChoicePhases(windowMain, windowDialog);
		
	}

}
