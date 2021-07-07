package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.ihm.coding_in_game.view.ConfirmExitDialog;

public class ControllerConfirmExit implements ActionListener, MouseListener {
	private ConfirmExitDialog confirmExit;

	public ControllerConfirmExit(ConfirmExitDialog confirmExit) {
		this.confirmExit = confirmExit;
		init();

	}

	private void init() {
		this.confirmExit.getButtonClose().addActionListener(this);
		this.confirmExit.getButtonConfirm().addActionListener(this);
		this.confirmExit.getButtonClose().addMouseListener(this);
		this.confirmExit.getButtonConfirm().addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmExit.getButtonClose()) {
			confirmExit.setVisible(false);
			confirmExit.getWindowDialog().getWindowParent().setEnabled(true);
			confirmExit.getWindowDialog().setVisible(false);

		} else {
			System.exit(0);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == confirmExit.getButtonClose()) {
			confirmExit.getButtonClose().setIcon(confirmExit.getImgButtonCloseHover());
		} else if (e.getComponent() == confirmExit.getButtonConfirm()) {
			confirmExit.getButtonConfirm().setIcon(confirmExit.getImgButtonDoneHover());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == confirmExit.getButtonClose()) {
			confirmExit.getButtonClose().setIcon(confirmExit.getImgButtonCloseNormal());
		} else if (e.getComponent() == confirmExit.getButtonConfirm()) {
			confirmExit.getButtonConfirm().setIcon(confirmExit.getImgButtonDoneNormal());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == confirmExit.getButtonClose()) {
			confirmExit.getButtonClose().setIcon(confirmExit.getImgButtonCloseClick());
		} else if (e.getComponent() == confirmExit.getButtonConfirm()) {
			confirmExit.getButtonConfirm().setIcon(confirmExit.getImgButtonDoneClick());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == confirmExit.getButtonClose()) {
			confirmExit.getButtonClose().setIcon(confirmExit.getImgButtonCloseHover());
		} else if (e.getComponent() == confirmExit.getButtonConfirm()) {
			confirmExit.getButtonConfirm().setIcon(confirmExit.getImgButtonDoneHover());
		}

	}

}
