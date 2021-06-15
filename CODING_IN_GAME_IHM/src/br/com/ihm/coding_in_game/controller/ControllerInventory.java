package br.com.ihm.coding_in_game.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.model.moveHeroThread;
import br.com.ihm.coding_in_game.view.Inventory;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerInventory implements ActionListener, MouseListener {
	private Inventory inventory;
	private WindowDialog windowDialog;
	private WindowMain windowMain;
	private ControllerGeneralContentDialog contentDialog;
	private String contentConsole;
	private String initialHTML, finalHTML;
	private moveHeroThread moveHeroThread;

	public ControllerInventory(WindowDialog windowDialog) {

		this.windowDialog = windowDialog;
		this.inventory = windowDialog.getWindowParent().getInventory();
		this.windowMain = windowDialog.getWindowParent();

		contentDialog = new ControllerGeneralContentDialog(this.windowDialog.getGeneralContentDialog());

		init();
	}

	private void init() {

		this.inventory.getButtonInfo().addActionListener(this);
		this.inventory.getButtonClose().addActionListener(this);
		this.inventory.getButtonDelete().addActionListener(this);
		this.inventory.getButtonExecute().addActionListener(this);
		this.inventory.getButtonReset().addActionListener(this);
		this.inventory.getButtonHelp().addActionListener(this);
		this.inventory.getLabelTurnLeft().addMouseListener(this);
		this.inventory.getLabelMoveFront().addMouseListener(this);
		this.inventory.getLabelTurnRight().addMouseListener(this);

		contentConsole = "";

		initialHTML = "<html>";
		finalHTML = "</html>";

		moveHeroThread = new moveHeroThread(windowMain.getPhase01().getHero());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inventory.getButtonInfo()) {
			windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(295, -25, 200, 100);
			windowDialog.getGeneralContentDialog().getLabelContent().setBounds(60, 80, 600, 100);

			windowMain.setEnabled(false);
			windowDialog.getGeneralContentDialog().getLabelTitle()
					.setText("<html><center><strong>INFO</strong></center></html>");
			windowDialog.getGeneralContentDialog().getLabelContent().setText(
					"<html><strong>Colete as bandeiras espalhadas pelo cenário usando os métodos dispoíveis. Cuidado com as bombas.</strong></html>");
			windowDialog.getGeneralContentDialog().setVisible(true);
			windowDialog.setVisible(true);

		} else if (e.getSource() == inventory.getButtonHelp()) {
			windowMain.setEnabled(false);
			windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(270, -25, 200, 100);
			windowDialog.getGeneralContentDialog().getLabelContent().setBounds(60, 80, 600, 200);
			windowDialog.getGeneralContentDialog().getLabelTitle()
					.setText("<html><center><strong>AJUDA</strong></center></html>");
			windowDialog.getGeneralContentDialog().getLabelContent().setText(
					"<html><strong>Faça uso dos métodos:  <br><br>- \"hero.girarDireita();\": Para girar o avatar para direita <br>"
							+ "<br>- \"hero.girarEsquerda();\": Para girar o avatar para esquerda <br>"
							+ "<br>- \"hero.girarDireita();\": Para mover o avatar para frente (a frente do avatar) <br>"
							+ "</strong></html>");
			windowDialog.getGeneralContentDialog().setVisible(true);
			windowDialog.setVisible(true);
		} else if (e.getSource() == inventory.getButtonDelete()) {
			// new_text = String(content_modal_footer.text()).trim().substring(0,
			// content_modal_footer.text().lastIndexOf(","))
			if (contentConsole.contains("<")) {
				contentConsole = contentConsole.substring(0, contentConsole.lastIndexOf("<br>"));
			} else {
				contentConsole = "";
			}
			inventory.getLabelContentConsole().setText(initialHTML + contentConsole + finalHTML);
		} else if (e.getSource() == inventory.getButtonClose()) {
			System.exit(0);
		} else if (e.getSource() == inventory.getButtonExecute()) {
			String comands[] = contentConsole.split("<br>");
			moveHeroThread.setComands(comands);
			moveHeroThread.setIndex(0);
			
			/*
			 * for (int i = 0; i < comands.length; i++) {
			 * 
			 * if (comands[i].trim().equals(Util.METHOD_TURN_RIGHT)) {
			 * 
			 * moveHeroThread.getHero().changeAparencePosiction(Util.METHOD_TURN_RIGHT);
			 * 
			 * } else if (comands[i].trim().equalsIgnoreCase(Util.METHOD_TURN_LEFT)) {
			 * System.out.println(comands[i].trim());
			 * moveHeroThread.getHero().changeAparencePosiction(Util.METHOD_TURN_LEFT);
			 * 
			 * } else if (comands[i].trim().equalsIgnoreCase(Util.METHOD_MOVE_FRONT)) {
			 * System.out.println(comands[i].trim());
			 * moveHeroThread.getHero().calculateFutureXY(); for (int k = 0; k < 32 /
			 * Hero.VELOCITY; k++) {
			 * moveHeroThread.setMove(moveHeroThread.getHero().getPosiction()); }
			 * 
			 * } else { System.out.println("Entrou em nenhum"); } }
			 */

		} else {
			System.out.println("RESET");
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == inventory.getLabelTurnRight()) {
			inventory.getLabelTurnRight().setForeground(new Color(255, 255, 255));
		} else if (e.getComponent() == inventory.getLabelTurnLeft()) {
			inventory.getLabelTurnLeft().setForeground(new Color(255, 255, 255));
		} else if (e.getComponent() == inventory.getLabelMoveFront()) {
			inventory.getLabelMoveFront().setForeground(new Color(255, 255, 255));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		inventory.getLabelTurnRight().setForeground(new Color(0, 0, 0));
		inventory.getLabelTurnLeft().setForeground(new Color(0, 0, 0));
		inventory.getLabelMoveFront().setForeground(new Color(0, 0, 0));

	}

	@Override
	public void mousePressed(MouseEvent e) {

		String breakLines = contentConsole.length() > 0 ? "<br>" : "";

		if (e.getComponent() == inventory.getLabelTurnRight()) {
			contentConsole = contentConsole + breakLines + Util.METHOD_TURN_RIGHT;
			inventory.getLabelContentConsole().setText(initialHTML + contentConsole + finalHTML);
		} else if (e.getComponent() == inventory.getLabelTurnLeft()) {
			contentConsole = contentConsole + breakLines + Util.METHOD_TURN_LEFT;
			inventory.getLabelContentConsole().setText(initialHTML + contentConsole + finalHTML);
		} else if (e.getComponent() == inventory.getLabelMoveFront()) {
			contentConsole = contentConsole + breakLines + Util.METHOD_MOVE_FRONT;
			inventory.getLabelContentConsole().setText(initialHTML + contentConsole + finalHTML);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public WindowMain getWindowMain() {
		return windowMain;
	}

	public void setWindowMain(WindowMain windowMain) {
		this.windowMain = windowMain;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public ControllerGeneralContentDialog getContentDialog() {
		return contentDialog;
	}

	public void setContentDialog(ControllerGeneralContentDialog contentDialog) {
		this.contentDialog = contentDialog;
	}

	public String getContentConsole() {
		return contentConsole;
	}

	public void setContentConsole(String contentConsole) {
		this.contentConsole = contentConsole;
	}

	public String getInitialHTML() {
		return initialHTML;
	}

	public void setInitialHTML(String initialHTML) {
		this.initialHTML = initialHTML;
	}

	public String getFinalHTML() {
		return finalHTML;
	}

	public void setFinalHTML(String finalHTML) {
		this.finalHTML = finalHTML;
	}

	public moveHeroThread getMoveHeroThread() {
		return moveHeroThread;
	}

	public void setMoveHeroThread(moveHeroThread moveHeroThread) {
		this.moveHeroThread = moveHeroThread;
	}

}
