package br.com.ihm.coding_in_game.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.model.moveHeroThread;
import br.com.ihm.coding_in_game.view.Console;
import br.com.ihm.coding_in_game.view.Inventory;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerInventory implements ActionListener, MouseListener, AdjustmentListener {
	private Inventory inventory;
	private WindowDialog windowDialog;
	private WindowMain windowMain;
	private ControllerGeneralContentDialog contentDialog;
	private moveHeroThread moveHeroThread;
	private Hero hero;
	private Player player;
	private Console console;

	public ControllerInventory(WindowDialog windowDialog) {

		this.windowDialog = windowDialog;
		this.inventory = windowDialog.getWindowParent().getInventory();
		this.windowMain = windowDialog.getWindowParent();
		this.hero = this.inventory.getHero();
		this.player = this.inventory.getPlayer();
		this.console = this.inventory.getConsolePanel();

		init();
	}

	private void init() {

		this.inventory.getButtonInfo().addActionListener(this);
		this.inventory.getButtonHome().addActionListener(this);
		this.inventory.getButtonDelete().addActionListener(this);
		this.inventory.getButtonExecute().addActionListener(this);
		this.inventory.getButtonReset().addActionListener(this);
		this.inventory.getButtonHelp().addActionListener(this);

		// event mouse
		this.inventory.getLabelTurnLeft().addMouseListener(this);
		this.inventory.getLabelMoveFront().addMouseListener(this);
		this.inventory.getLabelTurnRight().addMouseListener(this);
		this.inventory.getButtonExecute().addMouseListener(this);
		this.inventory.getButtonReset().addMouseListener(this);
		this.inventory.getButtonDelete().addMouseListener(this);
		this.inventory.getButtonHome().addMouseListener(this);
		this.inventory.getButtonHelp().addMouseListener(this);
		this.inventory.getButtonInfo().addMouseListener(this);

		moveHeroThread = new moveHeroThread(windowMain.getPhase().getHero(), windowMain.getInventory());

		contentDialog = new ControllerGeneralContentDialog(this.windowDialog.getGeneralContentDialog());

		console.getContentScroll().getVerticalScrollBar().addAdjustmentListener(this);

	}

	public void showDialogInfo() {

		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(265, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 140, 500, 20);
		windowDialog.getGeneralContentDialog().getButtonRight().setVisible(true);
		windowDialog.getGeneralContentDialog().getLabelFlags().setVisible(true);
		windowMain.setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>INFO</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent()
				.setText(windowDialog.getGeneralContentDialog().getInfoFlag());
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);
	}

	public void showDialogHelp() {
		windowMain.setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(245, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 100, 500, 300);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>AJUDA</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent().setText(
				"<html><strong>Façaa uso dos métodos:  <br><br>- \"hero.girarDireita();\": Para girar o avatar para direita <br>"
						+ "<br>- \"hero.girarEsquerda();\": Para girar o avatar para esquerda <br>"
						+ "<br>- \"hero.girarDireita();\": Para mover o avatar para frente (a frente do avatar) <br>"
						+ "</strong></html>");
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);
	}

	public void deleteComandConsole() {
		if (ExistsComands()) {
			if (inventory.getTextAreaConsole().getText().contains("\n")) {
				inventory.getTextAreaConsole().setText(inventory.getTextAreaConsole().getText().substring(0,
						inventory.getTextAreaConsole().getText().lastIndexOf("\n")));
				if (!hero.isAlreadyMoved()) {
					inventory.getPlayer().setAmountMoves(inventory.getPlayer().getAmountMoves() - 1);
				}
			} else {
				inventory.getTextAreaConsole().setText("");
				turnBottomButtonsLock();
				if (!hero.isAlreadyMoved()) {
					inventory.getPlayer().setAmountMoves(inventory.getPlayer().getAmountMoves() - 1);

				}

			}
		}
	}

	public void turnButtonsLock() {
		inventory.setLockInventary(true);
		turnBottomButtonsLock();
		inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoLocked());
		inventory.getButtonHome().setIcon(inventory.getImgButtonHomeLocked());
		inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpLocked());

	}

	public void updateComands() {
		turnButtonsLock();
		String comands[] = inventory.getTextAreaConsole().getText().split("\n");
		moveHeroThread.setComands(comands);
		moveHeroThread.setIndex(0);

		if (!hero.isAlreadyMoved()) {
			hero.setAlreadyMoved(true);
		}
	}

	public void resetPhase() {

		inventory.getPhase().resetPhase(true);
		inventory.getTextAreaConsole().setText("");
		turnBottomButtonsLock();

		
	}

	public void turnBottomButtonsLock() {
		inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashLocked());
		inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteLocked());
		if (!isHeroAlreadyMoved()) {
			inventory.getButtonReset().setIcon(inventory.getImgButtonResetLocked());
		}
	}

	public void showDialogFailure(String content) {
		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(225, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 10, 500, 300);

		windowDialog.getWindowParent().setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>FALHOU</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent()
				.setText("<html><strong>" + content + "</strong></html>");
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);

	}

	public boolean ExistsComands() {
		if (inventory.getTextAreaConsole().getText().length() != 0) {
			return true;
		}

		return false;
	}

	public boolean isHeroAlreadyMoved() {
		if (hero.isAlreadyMoved()) {
			return true;
		}

		return false;
	}

	public void backToHome() {

		inventory.getPlayer().setAmountMoves(0);
		DataBase.updatePlayer(inventory.getPlayer());
		System.out.println("PASSOU 2");
		Util.players = DataBase.allPlayers();
		System.out.println("PASSOU 3");

		windowMain.dispose();
		windowMain = null;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		Hero.INITIAL_X = 35;
		Hero.INITIAL_Y = 365;
		WindowMain windowMain = new WindowMain(width, height);
		WindowDialog windowDialog = new WindowDialog(616, 500, windowMain);
		windowMain.getPhase().setWindowDialog(windowDialog);
		windowMain.getPhase().setInventory(windowMain.getInventory());
		windowMain.getPhase().setWindowMain(windowMain);

		new ControllerStart(windowMain, windowDialog);
		new ControllerPhase(windowDialog);
		new ControllerInventory(windowDialog);
		new ControllerChoicePhases(windowMain, windowDialog);
		new ControllerSelectPlayer(windowDialog.getSelectUser());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!inventory.isLockInventary()) {
			if (e.getSource() == inventory.getButtonInfo()) {
				showDialogInfo();
			} else if (e.getSource() == inventory.getButtonHelp()) {
				showDialogHelp();
			} else if (e.getSource() == inventory.getButtonDelete()) {

				if (ExistsComands()) {
					deleteComandConsole();
				}
			} else if (e.getSource() == inventory.getButtonHome()) {
				backToHome();

			} else if (e.getSource() == inventory.getButtonExecute()) {
				if (ExistsComands()) {
					updateComands();

				}
			} else if (e.getSource() == inventory.getButtonReset()) {
				if (isHeroAlreadyMoved()) {
					resetPhase();
				}
			}
		}

	}

	public void turnBottomButtonsNormal() {
		inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashNormal());
		inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteNormal());
		if (isHeroAlreadyMoved()) {
			inventory.getButtonReset().setIcon(inventory.getImgButtonResetNormal());
		}
	}

	public void countMoves() {
		if (!overComands()) {

			inventory.getPlayer().setAmountMoves(inventory.getPlayer().getAmountMoves() + 1);
		}

	}

	public boolean overComands() {
		if (inventory.getPhase().getMoves() == player.getAmountMoves()) {
			return true;
		}

		return false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (!inventory.isLockInventary()) {
			if (e.getComponent() == inventory.getLabelTurnRight()) {
				inventory.getLabelTurnRight().setForeground(new Color(255, 255, 255));
			} else if (e.getComponent() == inventory.getLabelTurnLeft()) {
				inventory.getLabelTurnLeft().setForeground(new Color(255, 255, 255));
			} else if (e.getComponent() == inventory.getLabelMoveFront()) {
				inventory.getLabelMoveFront().setForeground(new Color(255, 255, 255));
			} else if (e.getComponent() == inventory.getButtonExecute()) {
				if (ExistsComands()) {
					inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteHover());
				}
			} else if (e.getComponent() == inventory.getButtonReset()) {
				if (ExistsComands() && isHeroAlreadyMoved()) {
					inventory.getButtonReset().setIcon(inventory.getImgButtonResetHover());
				}
			} else if (e.getComponent() == inventory.getButtonDelete()) {
				if (ExistsComands()) {
					inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashHover());
				}
			} else if (e.getComponent() == inventory.getButtonInfo()) {

				inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoHover());

			} else if (e.getComponent() == inventory.getButtonHelp()) {

				inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpHover());

			} else if (e.getComponent() == inventory.getButtonHome()) {

				inventory.getButtonHome().setIcon(inventory.getImgButtonHomeHover());

			}

		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

		if (!inventory.isLockInventary()) {
			inventory.getLabelTurnRight().setForeground(new Color(0, 0, 0));
			inventory.getLabelTurnLeft().setForeground(new Color(0, 0, 0));
			inventory.getLabelMoveFront().setForeground(new Color(0, 0, 0));

			if (ExistsComands()) {
				inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteNormal());
			}
			if (isHeroAlreadyMoved()) {
				inventory.getButtonReset().setIcon(inventory.getImgButtonResetNormal());
			}
			if (ExistsComands()) {
				inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashNormal());
			}

			inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoNormal());

			inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpNormal());

			inventory.getButtonHome().setIcon(inventory.getImgButtonHomeNormal());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (!inventory.isLockInventary()) {
			if (e.getComponent() == inventory.getLabelTurnRight()) {

				if (!overComands()) {
					String isBreaklines = ExistsComands() ? "\n" : "";
					inventory.getTextAreaConsole().append(isBreaklines + Util.METHOD_TURN_RIGHT);
					isBreaklines = null;
					turnBottomButtonsNormal();
					countMoves();

				}

			} else if (e.getComponent() == inventory.getLabelTurnLeft()) {
				if (!overComands()) {
					String isBreaklines = ExistsComands() ? "\n" : "";
					inventory.getTextAreaConsole().append(isBreaklines + Util.METHOD_TURN_LEFT);
					turnBottomButtonsNormal();
					countMoves();
					isBreaklines = null;
				}
			} else if (e.getComponent() == inventory.getLabelMoveFront()) {
				if (!overComands()) {
					String isBreaklines = ExistsComands() ? "\n" : "";
					inventory.getTextAreaConsole().append(isBreaklines + Util.METHOD_MOVE_FRONT);
					turnBottomButtonsNormal();
					countMoves();
					isBreaklines = null;
				}
			} else if (e.getComponent() == inventory.getButtonExecute()) {
				if (ExistsComands()) {
					inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteClick());
				}
			} else if (e.getComponent() == inventory.getButtonReset()) {
				if (isHeroAlreadyMoved()) {
					inventory.getButtonReset().setIcon(inventory.getImgButtonResetClick());
				}
			} else if (e.getComponent() == inventory.getButtonDelete()) {
				if (ExistsComands()) {
					inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashClick());
				}

			} else if (e.getComponent() == inventory.getButtonInfo()) {

				inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoClick());

			} else if (e.getComponent() == inventory.getButtonHelp()) {

				inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpClick());

			} else if (e.getComponent() == inventory.getButtonHome()) {

				inventory.getButtonHome().setIcon(inventory.getImgButtonHomeClick());

			}

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!inventory.isLockInventary()) {
			if (e.getComponent() == inventory.getButtonExecute()) {
				if (ExistsComands() && isHeroAlreadyMoved()) {
					inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteHover());
				}
			} else if (e.getComponent() == inventory.getButtonReset()) {
				if (isHeroAlreadyMoved()) {
					inventory.getButtonReset().setIcon(inventory.getImgButtonResetHover());
				}
			} else if (e.getComponent() == inventory.getButtonDelete()) {

				if (ExistsComands()) {
					inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashHover());
				}
			} else if (e.getComponent() == inventory.getButtonInfo()) {

				inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoHover());

			} else if (e.getComponent() == inventory.getButtonHelp()) {

				inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpHover());

			} else if (e.getComponent() == inventory.getButtonHome()) {

				inventory.getButtonHome().setIcon(inventory.getImgButtonHomeHover());

			}
		}
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

	public moveHeroThread getMoveHeroThread() {
		return moveHeroThread;
	}

	public void setMoveHeroThread(moveHeroThread moveHeroThread) {
		this.moveHeroThread = moveHeroThread;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		console.repaint();
		console.getContent().repaint();
		console.getContentScroll().repaint();

	}

}
