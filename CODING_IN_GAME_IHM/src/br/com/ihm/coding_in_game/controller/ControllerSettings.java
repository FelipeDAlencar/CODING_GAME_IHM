package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.ihm.coding_in_game.view.Settings;

public class ControllerSettings implements ActionListener, KeyListener, ChangeListener {
	private Settings settings;

	public ControllerSettings(Settings settings) {
		this.settings = settings;

		this.settings.addKeyListener(this);
		this.settings.getButtonCancel().addActionListener(this);
		this.settings.getButtonConfirm().addActionListener(this);
		this.settings.getSliderVelocity().addChangeListener(this);
		this.settings.getCheckBoxSound().addActionListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ESCAPE) {
			settings.getWindow().setVisible(false);
			settings.setVisible(false);
			System.exit(0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == settings.getButtonConfirm()) {
			System.out.println(settings.getSliderVelocity().getValue());
			settings.getWindow().setVisible(false);
			settings.setVisible(false);
		} else if (e.getSource() == settings.getButtonCancel()) {
			settings.getWindow().setVisible(false);
			settings.setVisible(false);
		} else if (e.getSource() == settings.getCheckBoxSound()) {
			System.out.println(settings.getCheckBoxSound().isSelected());
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
		System.out.println("Aqui");
		if (e.getSource() == settings.getSliderVelocity()) {
		}
	}

}
