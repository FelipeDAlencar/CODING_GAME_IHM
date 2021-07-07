package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.view.SettingsDialog;

public class ControllerSettings implements ActionListener, KeyListener, ChangeListener, MouseListener {
	private SettingsDialog settings;

	public ControllerSettings(SettingsDialog settings) {
		this.settings = settings;
		init();
	}

	private void init() {

		// key listener
		this.settings.addKeyListener(this);

		// Action listenner
		this.settings.getButtonCancel().addActionListener(this);
		this.settings.getButtonConfirm().addActionListener(this);
		this.settings.getButtonSound().addActionListener(this);

		// CHANGE LISTENER
		this.settings.getSliderVelocity().addChangeListener(this);

		// MOUSE LISTENER
		this.settings.getButtonSound().addMouseListener(this);
		this.settings.getButtonCancel().addMouseListener(this);
		this.settings.getButtonConfirm().addMouseListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ESCAPE) {
			settings.setVisible(false);
			settings.getWindowDialog().setVisible(false);
			settings.getWindowDialog().getWindowParent().setEnabled(true);

			System.exit(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == settings.getButtonConfirm()) {
			settings.setVisible(false);
			settings.getWindowDialog().getWindowParent().setEnabled(true);
			settings.getWindowDialog().setVisible(false);
		} else if (e.getSource() == settings.getButtonCancel()) {
			settings.setVisible(false);
			settings.getWindowDialog().getWindowParent().setEnabled(true);
			settings.getWindowDialog().setVisible(false);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == settings.getSliderVelocity()) {
			Hero.VELOCITY = settings.getSliderVelocity().getValue();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == settings.getButtonSound()) {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundHover());
		} else if (e.getComponent() == settings.getButtonCancel()) {
			settings.getButtonCancel().setIcon(settings.getImgButtonCloseHover());
		} else if (e.getComponent() == settings.getButtonConfirm()) {
			settings.getButtonConfirm().setIcon(settings.getImgButtonDoneHover());
		} else if (e.getComponent() == settings.getButtonSound()) {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundHover());
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		settings.getButtonSound().setIcon(settings.getImgButtonSoundNormal());
		settings.getButtonCancel().setIcon(settings.getImgButtonCloseNormal());
		settings.getButtonConfirm().setIcon(settings.getImgButtonDoneNormal());

		if (Util.SOUND) {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundNormal());
		} else {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundLocked());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == settings.getButtonSound()) {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundClick());
			if (Util.SOUND) {
				Util.SOUND = false;
			} else {
				Util.SOUND = true;
			}
		} else if (e.getComponent() == settings.getButtonCancel()) {
			settings.getButtonCancel().setIcon(settings.getImgButtonCloseClick());
		} else if (e.getComponent() == settings.getButtonConfirm()) {
			settings.getButtonConfirm().setIcon(settings.getImgButtonDoneClick());

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == settings.getButtonSound()) {
			settings.getButtonSound().setIcon(settings.getImgButtonSoundHover());
		} else if (e.getComponent() == settings.getButtonCancel()) {
			settings.getButtonCancel().setIcon(settings.getImgButtonCloseHover());
		} else if (e.getComponent() == settings.getButtonConfirm()) {
			settings.getButtonConfirm().setIcon(settings.getImgButtonDoneHover());
		}

	}

}
