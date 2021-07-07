package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.view.ChoicePhases;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerChoicePhases implements ActionListener, MouseListener {

	private WindowMain windowMain;
	private WindowDialog windowDialog;
	private ChoicePhases choicePhases;

	public ControllerChoicePhases(WindowMain windowMain, WindowDialog windowDialog) {
		this.windowMain = windowMain;
		this.windowDialog = windowDialog;
		this.choicePhases = this.windowDialog.getChoicePhases();

		init();

	}

	private void init() {
		choicePhases.getButtonClose().addActionListener(this);
		choicePhases.getButtonPhase1().addActionListener(this);
		choicePhases.getButtonPhase2().addActionListener(this);
		choicePhases.getButtonPhase3().addActionListener(this);
		choicePhases.getButtonPhase4().addActionListener(this);

		// MOUSE LISTENER

		choicePhases.getButtonClose().addMouseListener(this);
		choicePhases.getButtonPhase1().addMouseListener(this);
		choicePhases.getButtonPhase2().addMouseListener(this);
		choicePhases.getButtonPhase3().addMouseListener(this);
		choicePhases.getButtonPhase4().addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == choicePhases.getButtonClose()) {
			choicePhases.setVisible(false);
			windowMain.setEnabled(true);
			windowDialog.setVisible(false);

		} else if (e.getSource() == choicePhases.getButtonPhase1()) {

			if (phaseAvailable() >= 1) {
				if (choicePhases.getTextFieldNamePlayer().isVisible()) {
					if (!verifyPlayer(choicePhases.getTextFieldNamePlayer().getText().trim())) {
						if (!choicePhases.getTextFieldNamePlayer().getText().isEmpty()) {
							windowMain.getStart().setVisible(false);
							windowMain.getPhase().setVisible(true);
							windowMain.getPhase().requestFocus();
							windowMain.getInventory().setVisible(true);

							windowMain.getInventory().getPlayer()
									.setName(choicePhases.getTextFieldNamePlayer().getText().toUpperCase());
							DataBase.savePlayer(windowMain.getInventory().getPlayer());
							windowMain.getInventory().getLabelNamePlayer()
									.setText(windowMain.getInventory().getPlayer().getName());
							windowMain.getInventory().getLabelTitlePhase().setText(
									windowMain.getPhase1().getTitle() + windowMain.getInventory().getFinalPhase());

							choicePhases.setVisible(false);
							windowMain.setEnabled(true);
							windowDialog.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,
									"Seu nome não pode ser vazio. Por favor, informe um nome.", "ATENÇÃO",
									JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Já existe um player com este nome. Por favor, tente outro.", "ATENÇÃO",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {

					windowMain.getInventory().getLabelNamePlayer()
							.setText(windowMain.getInventory().getPlayer().getName());
					windowMain.getInventory().getPlayer().initImgsLife();

					windowMain.getStart().setVisible(false);
					windowMain.getPhase().setVisible(true);
					windowMain.getPhase().requestFocus();
					windowMain.getInventory().setVisible(true);
					windowMain.getInventory().getLabelTitlePhase()
							.setText(windowMain.getPhase1().getTitle() + windowMain.getInventory().getFinalPhase());

					choicePhases.setVisible(false);
					windowMain.setEnabled(true);
					windowDialog.setVisible(false);
				}
			}

		} else if (e.getSource() == choicePhases.getButtonPhase2()) {

			if (phaseAvailable() >= 2) {
				windowMain.getInventory().getLabelNamePlayer().setText(windowMain.getInventory().getPlayer().getName());

				windowMain.getStart().setVisible(false);
				windowMain.getPhase().setVisible(true);
				windowMain.getPhase().requestFocus();
				windowMain.getInventory().setVisible(true);

				windowMain.getInventory().setPhase(windowMain.getPhase2());
				windowMain.getPhase2().setInventory(windowMain.getInventory());
				windowMain.getPhase2().setHero(windowMain.getInventory().getHero());
				windowMain.getPhase2().setPlayer(windowMain.getInventory().getPlayer());

				windowMain.getInventory().getPlayer().initImgsLife();
				windowMain.getInventory().getLabelTitlePhase()
						.setText(windowMain.getPhase2().getTitle() + windowMain.getInventory().getFinalPhase());

				windowMain.getPhase1().setLoop(false);
				windowMain.getPhase1().setVisible(false);

				windowMain.getPhase2().setVisible(true);
				windowMain.setPhase(windowMain.getPhase2());

				windowMain.getPhase2().setWindowMain(windowMain);
				windowMain.getPhase2().setWindowDialog(windowDialog);

				choicePhases.setVisible(false);
				windowMain.setEnabled(true);
				windowDialog.setVisible(false);
			}

		} else if (e.getSource() == choicePhases.getButtonPhase3()) {
			if (phaseAvailable() >= 3) {
				windowMain.getInventory().getLabelNamePlayer().setText(windowMain.getInventory().getPlayer().getName());

				windowMain.getStart().setVisible(false);
				windowMain.getPhase().setVisible(true);
				windowMain.getPhase().requestFocus();
				windowMain.getInventory().setVisible(true);

				windowMain.getInventory().setPhase(windowMain.getPhase3());
				windowMain.getPhase3().setInventory(windowMain.getInventory());
				windowMain.getPhase3().setHero(windowMain.getInventory().getHero());
				windowMain.getPhase3().setPlayer(windowMain.getInventory().getPlayer());

				windowMain.getInventory().getLabelTitlePhase()
						.setText(windowMain.getPhase3().getTitle() + windowMain.getInventory().getFinalPhase());

				windowMain.getPhase2().setLoop(false);
				windowMain.getPhase2().setVisible(false);
				windowMain.getPhase1().setLoop(false);
				windowMain.getPhase1().setVisible(false);

				windowMain.getInventory().getPlayer().initImgsLife();

				windowMain.getPhase3().setVisible(true);
				windowMain.setPhase(windowMain.getPhase3());

				windowMain.getPhase3().setWindowMain(windowMain);
				windowMain.getPhase3().setWindowDialog(windowDialog);

				choicePhases.setVisible(false);
				windowMain.setEnabled(true);
				windowDialog.setVisible(false);
			}

		} else if (e.getSource() == choicePhases.getButtonPhase4()) {

			if (phaseAvailable() >= 4) {
				windowMain.getInventory().getLabelNamePlayer().setText(windowMain.getInventory().getPlayer().getName());

				windowMain.getStart().setVisible(false);
				windowMain.getPhase().setVisible(true);
				windowMain.getPhase().requestFocus();
				windowMain.getInventory().setVisible(true);

				Hero.INITIAL_X = 100;
				Hero.INITIAL_Y = 100;

				windowMain.getInventory().getHero().setAparence(0);
				windowMain.getInventory().getHero().setPosiction(Util.POSICTION_DOWN);
				windowMain.getInventory().getHero().setPosX(Hero.INITIAL_X);
				windowMain.getInventory().getHero().setPosY(Hero.INITIAL_Y);
				windowMain.getInventory().getHero().setFutureX(Hero.INITIAL_X);
				windowMain.getInventory().getHero().setFutureY(Hero.INITIAL_Y);

				windowMain.getInventory().setPhase(windowMain.getPhase4());
				windowMain.getPhase4().setInventory(windowMain.getInventory());
				windowMain.getPhase4().setHero(windowMain.getInventory().getHero());
				windowMain.getPhase4().setPlayer(windowMain.getInventory().getPlayer());

				windowMain.getPhase3().setLoop(false);
				windowMain.getPhase3().setVisible(false);
				windowMain.getPhase2().setLoop(false);
				windowMain.getPhase2().setVisible(false);
				windowMain.getPhase1().setLoop(false);
				windowMain.getPhase1().setVisible(false);

				windowMain.getPhase4().setVisible(true);
				windowMain.setPhase(windowMain.getPhase4());
				windowMain.getPhase4().setWindowDialog(windowDialog);

				windowMain.getPhase4().setWindowMain(windowMain);
				windowMain.getPhase4().setWindowDialog(windowDialog);

				windowMain.getInventory().getPlayer().initImgsLife();

				windowMain.getInventory().getLabelTitlePhase()
						.setText(windowMain.getPhase4().getTitle() + windowMain.getInventory().getFinalPhase());

				choicePhases.setVisible(false);
				windowMain.setEnabled(true);
				windowDialog.setVisible(false);
			}

		}

	}

	public boolean verifyPlayer(String username) {
		System.out.println(username);
		if (Util.players != null) {
			for (Player player : Util.players) {
				if (player.getName().equals(username.toUpperCase())) {
					return true;
				}
			}
		}

		return false;

	}

	public int phaseAvailable() {
		Player player = windowMain.getInventory().getPlayer();
		if (player.getCurrentPhase() == 1) {
			return 1;
		} else if (player.getCurrentPhase() == 2) {
			return 2;
		} else if (player.getCurrentPhase() == 3) {
			return 3;
		} else {
			return 4;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == choicePhases.getButtonClose()) {
			choicePhases.getButtonClose().setIcon(choicePhases.getImgButtonCloseHover());
		} else if (e.getSource() == choicePhases.getButtonPhase1()) {
			choicePhases.getButtonPhase1().setIcon(choicePhases.getImgButtonPhase01Hover());
		} else if (e.getSource() == choicePhases.getButtonPhase2()) {
			if (phaseAvailable() >= 2) {
				choicePhases.getButtonPhase2().setIcon(choicePhases.getImgButtonPhase02Hover());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase3()) {
			if (phaseAvailable() >= 3) {
				choicePhases.getButtonPhase3().setIcon(choicePhases.getImgButtonPhase03Hover());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase4()) {
			if (phaseAvailable() >= 4) {
				choicePhases.getButtonPhase4().setIcon(choicePhases.getImgButtonPhase04Hover());
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == choicePhases.getButtonClose()) {
			choicePhases.getButtonClose().setIcon(choicePhases.getImgButtonCloseNormal());
		} else if (e.getSource() == choicePhases.getButtonPhase1()) {
			choicePhases.getButtonPhase1().setIcon(choicePhases.getImgButtonPhase01Normal());
		} else if (e.getSource() == choicePhases.getButtonPhase2()) {
			if (phaseAvailable() >= 2) {
				choicePhases.getButtonPhase2().setIcon(choicePhases.getImgButtonPhase02Normal());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase3()) {
			if (phaseAvailable() >= 3) {
				choicePhases.getButtonPhase3().setIcon(choicePhases.getImgButtonPhase03Normal());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase4()) {
			if (phaseAvailable() >= 4) {
				choicePhases.getButtonPhase4().setIcon(choicePhases.getImgButtonPhase04Normal());
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == choicePhases.getButtonClose()) {
			choicePhases.getButtonClose().setIcon(choicePhases.getImgButtonCloseClick());
		} else if (e.getSource() == choicePhases.getButtonPhase1()) {
			choicePhases.getButtonPhase1().setIcon(choicePhases.getImgButtonPhase01Click());
		} else if (e.getSource() == choicePhases.getButtonPhase2()) {
			if (phaseAvailable() >= 2) {
				choicePhases.getButtonPhase2().setIcon(choicePhases.getImgButtonPhase02Click());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase3()) {
			if (phaseAvailable() >= 3) {
				choicePhases.getButtonPhase3().setIcon(choicePhases.getImgButtonPhase03Click());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase4()) {
			if (phaseAvailable() >= 4) {
				choicePhases.getButtonPhase4().setIcon(choicePhases.getImgButtonPhase04Click());
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == choicePhases.getButtonClose()) {
			choicePhases.getButtonClose().setIcon(choicePhases.getImgButtonCloseHover());
		} else if (e.getSource() == choicePhases.getButtonPhase1()) {
			choicePhases.getButtonPhase1().setIcon(choicePhases.getImgButtonPhase01Hover());
		} else if (e.getSource() == choicePhases.getButtonPhase2()) {
			if (phaseAvailable() >= 2) {
				choicePhases.getButtonPhase2().setIcon(choicePhases.getImgButtonPhase02Hover());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase3()) {
			if (phaseAvailable() >= 3) {
				choicePhases.getButtonPhase3().setIcon(choicePhases.getImgButtonPhase03Hover());
			}
		} else if (e.getSource() == choicePhases.getButtonPhase4()) {
			if (phaseAvailable() >= 4) {
				choicePhases.getButtonPhase4().setIcon(choicePhases.getImgButtonPhase04Hover());
			}
		}

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

	public ChoicePhases getChoicePhases() {
		return choicePhases;
	}

	public void setChoicePhases(ChoicePhases choicePhases) {
		this.choicePhases = choicePhases;
	}

}
