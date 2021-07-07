package br.com.ihm.coding_in_game.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.controller.ControllerChoicePhases;
import br.com.ihm.coding_in_game.controller.ControllerInventory;
import br.com.ihm.coding_in_game.controller.ControllerPhase;
import br.com.ihm.coding_in_game.controller.ControllerSelectPlayer;
import br.com.ihm.coding_in_game.controller.ControllerStart;
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

		// UIManager.put("ToolTip.foreground", new ColorUIResource(Color.red));
		// UIManager.put("ToolTip.background", new ColorUIResource(Color.yellow));
		
		DataBase.createArchiveIfNotExists();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		WindowMain windowMain = new WindowMain(width, height);
		WindowDialog windowDialog = new WindowDialog(616, 500, windowMain);
		windowMain.getPhase().setWindowDialog(windowDialog);
		windowMain.getPhase().setInventory(windowMain.getInventory());
		windowMain.getPhase().setWindowMain(windowMain);

		ControllerStart controllerStart = new ControllerStart(windowMain, windowDialog);
		ControllerPhase controllerPhase01 = new ControllerPhase(windowDialog);
		ControllerInventory controllerInventory = new ControllerInventory(windowDialog);
		ControllerChoicePhases controllerChoicePhases = new ControllerChoicePhases(windowMain, windowDialog);
		ControllerSelectPlayer controllerSelectPlayer = new ControllerSelectPlayer(windowDialog.getSelectUser());
		
			
		
	}
	
	
	
	
}
