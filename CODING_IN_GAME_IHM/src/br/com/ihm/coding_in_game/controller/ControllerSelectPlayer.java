package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.view.SelectPlayer;

public class ControllerSelectPlayer implements MouseListener, ActionListener, AdjustmentListener {
	private SelectPlayer selectPlayer;

	public ControllerSelectPlayer(SelectPlayer selectPlayer) {
		this.selectPlayer = selectPlayer;

		init();
	}

	private void init() {
		selectPlayer.getButtonClose().addMouseListener(this);
		selectPlayer.getButtonClose().addActionListener(this);
		selectPlayer.getButtonAddPlayer().addMouseListener(this);
		selectPlayer.getButtonAddPlayer().addActionListener(this);

		selectPlayer.getScrollPane().getVerticalScrollBar().addAdjustmentListener(this);

		for (JLabel label : selectPlayer.getLabelsPlayers()) {
			label.addMouseListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectPlayer.getButtonClose()) {
			selectPlayer.getWindowDialog().getWindowParent().setEnabled(true);
			selectPlayer.setVisible(false);
			selectPlayer.getWindowDialog().setVisible(false);

		} else if (e.getSource() == selectPlayer.getButtonAddPlayer()) {
			selectPlayer.setVisible(false);
			selectPlayer.getWindowDialog().getChoicePhases().setVisible(true);
			selectPlayer.getWindowDialog().getChoicePhases().getTextFieldNamePlayer().setVisible(true);
			selectPlayer.getWindowDialog().getChoicePhases().getLabelNamePlayer().setVisible(true);
			selectPlayer.getWindowDialog().getChoicePhases().getTextFieldNamePlayer().requestFocus();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == selectPlayer.getButtonClose()) {
			selectPlayer.getButtonClose().setIcon(selectPlayer.getImgButtonCloseHover());
		} else if (e.getComponent() == selectPlayer.getButtonAddPlayer()) {
			selectPlayer.getButtonAddPlayer().setIcon(selectPlayer.getImgButtonAddPlayerHover());
		}

		else {
			for (JLabel label : selectPlayer.getLabelsPlayers()) {
				if (e.getComponent() == label) {
					label.setForeground(Util.COLOR_LABEL_HOVER);
				}
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == selectPlayer.getButtonClose()) {
			selectPlayer.getButtonClose().setIcon(selectPlayer.getImgButtonCloseNormal());
		} else if (e.getComponent() == selectPlayer.getButtonAddPlayer()) {
			selectPlayer.getButtonAddPlayer().setIcon(selectPlayer.getImgButtonAddPlayerNormal());
		}
		for (JLabel label : selectPlayer.getLabelsPlayers()) {
			if (e.getComponent() == label) {
				label.setForeground(Util.COLOR_LABEL_OTHER);
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == selectPlayer.getButtonClose()) {
			selectPlayer.getButtonClose().setIcon(selectPlayer.getImgButtonCloseClick());
		} else if (e.getComponent() == selectPlayer.getButtonAddPlayer()) {
			selectPlayer.getButtonAddPlayer().setIcon(selectPlayer.getImgButtonAddPlayerClick());
		}
		for (JLabel label : selectPlayer.getLabelsPlayers()) {
			if (e.getComponent() == label) {
				selectPlayer.setVisible(false);
				selectPlayer.getWindowDialog().getChoicePhases().setVisible(true);
				Player player = DataBase.searchPlayer(label.getText().split(" ")[0].trim());
				selectPlayer.getWindowDialog().getWindowParent().getInventory().setPlayer(player);
				selectPlayer.getWindowDialog().getWindowParent().getPhase().setPlayer(player);
				selectPlayer.getWindowDialog().getWindowParent().getPhase1().setPlayer(player);
				phasesAvailable(player);

			}
		}
	}

	public void phasesAvailable(Player player) {
		if (player.getCurrentPhase() == 1) {
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase01Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase4()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());

		} else if (player.getCurrentPhase() == 2) {
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase02Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase01Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase4()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());
			
			
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2().setToolTipText("<html><center><strong>IR PARA FASE 02</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1().setToolTipText("<html><center><strong>IR PARA FASE 01</strong></center></html>\"");

		
		} else if (player.getCurrentPhase() == 3) {
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase03Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1()
			.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase01Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase02Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase4()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonLock());
			
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1().setToolTipText("<html><center><strong>IR PARA FASE 01</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2().setToolTipText("<html><center><strong>IR PARA FASE 02</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3().setToolTipText("<html><center><strong>IR PARA FASE 03</strong></center></html>\"");

		} else if (player.getCurrentPhase() == 4) {
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase4()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase04Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase01Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase02Normal());
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3()
					.setIcon(selectPlayer.getWindowDialog().getChoicePhases().getImgButtonPhase02Normal());
			
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase1().setToolTipText("<html><center><strong>IR PARA FASE 01</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase2().setToolTipText("<html><center><strong>IR PARA FASE 02</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase3().setToolTipText("<html><center><strong>IR PARA FASE 03</strong></center></html>\"");
			selectPlayer.getWindowDialog().getChoicePhases().getButtonPhase4().setToolTipText("<html><center><strong>IR PARA FASE 04</strong></center></html>\"");


		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == selectPlayer.getButtonClose()) {
			selectPlayer.getButtonClose().setIcon(selectPlayer.getImgButtonCloseHover());
		} else if (e.getComponent() == selectPlayer.getButtonAddPlayer()) {
			selectPlayer.getButtonAddPlayer().setIcon(selectPlayer.getImgButtonAddPlayerHover());
		}
		for (JLabel label : selectPlayer.getLabelsPlayers()) {
			if (e.getComponent() == label) {
				label.setForeground(Util.COLOR_LABEL_OTHER);
			}
		}

	}

	public SelectPlayer getSelectPlayer() {
		return selectPlayer;
	}

	public void setSelectPlayer(SelectPlayer selectPlayer) {
		this.selectPlayer = selectPlayer;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		selectPlayer.getPanelPlayer().repaint();
		selectPlayer.getScrollPane().repaint();
		selectPlayer.repaint();

	}

}
