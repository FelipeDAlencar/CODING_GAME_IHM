package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import br.com.ihm.coding_in_game.model.Util;
import br.com.ihm.coding_in_game.view.Start;
import br.com.ihm.coding_in_game.view.WindowDialog;
import br.com.ihm.coding_in_game.view.WindowMain;

public class ControllerStart implements ActionListener, MouseListener {

	private Start start;
	private WindowMain windowMain;
	private WindowDialog windowDialog;
	private ControllerContentHelp controllerContentHelp;
	private ControllerConfirmExit controllerConfirmExit;
	private ControllerSettings controllerSettings;

	public ControllerStart(WindowMain windowMain, WindowDialog windowDialog) {
		this.start = windowMain.getStart();
		this.windowMain = windowMain;
		this.windowDialog = windowDialog;
		controllerContentHelp = new ControllerContentHelp(windowDialog.getContentHelp());
		controllerConfirmExit = new ControllerConfirmExit(windowDialog.getConfirmExit());
		controllerSettings = new ControllerSettings(windowDialog.getSettings());

		init();
	}

	private void init() {
		start.getjButtonClose().addActionListener(this);
		start.getjButtonHelp().addActionListener(this);
		start.getjButtonSettings().addActionListener(this);
		start.getjButtonStartGame().addActionListener(this);

		// MOUSE LISTENER
		start.getjButtonClose().addMouseListener(this);
		start.getjButtonHelp().addMouseListener(this);
		start.getjButtonSettings().addMouseListener(this);
		start.getjButtonStartGame().addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start.getjButtonClose()) {
			windowDialog.setVisible(true);
			windowDialog.getConfirmExit().setVisible(true);
			windowMain.setEnabled(false);

		} else if (e.getSource() == start.getjButtonStartGame()) {
			windowDialog.setVisible(true);

			if(Util.players != null) {
				windowDialog.getSelectUser().setVisible(true);
				windowDialog.getChoicePhases().setVisible(false);
				windowDialog.getChoicePhases().getTextFieldNamePlayer().setVisible(false);
				windowDialog.getChoicePhases().getLabelNamePlayer().setVisible(false);


			}else {
				windowDialog.getChoicePhases().setVisible(true);
				windowDialog.getChoicePhases().getTextFieldNamePlayer().requestFocus();
				windowDialog.getSelectUser().setVisible(false);
				

			}
			
			windowDialog.getSettings().setVisible(false);
			windowDialog.getContentHelp().setVisible(false);
			windowDialog.getConfirmExit().setVisible(false);
			windowMain.setEnabled(false);

		} else if (e.getSource() == start.getjButtonHelp()) {
			windowDialog.setVisible(true);
			windowDialog.getContentHelp().setVisible(true);
			windowDialog.getSettings().setVisible(false);
			windowDialog.getConfirmExit().setVisible(false);
			windowDialog.getChoicePhases().setVisible(false);
			windowMain.setEnabled(false);
		} else {
			windowDialog.setVisible(true);
			windowDialog.getSettings().setVisible(true);
			windowDialog.getContentHelp().setVisible(false);
			windowDialog.getConfirmExit().setVisible(false);
			windowDialog.getChoicePhases().setVisible(false);
			windowMain.setEnabled(false);

		}

	}

	public Start getStartPanel() {
		return start;
	}

	public void setStartPanel(Start startPanel) {
		this.start = startPanel;
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

	public ControllerContentHelp getControllerContentHelp() {
		return controllerContentHelp;
	}

	public void setControllerContentHelp(ControllerContentHelp controllerContentHelp) {
		this.controllerContentHelp = controllerContentHelp;
	}

	public ControllerConfirmExit getControllerConfirmExit() {
		return controllerConfirmExit;
	}

	public void setControllerConfirmExit(ControllerConfirmExit controllerConfirmExit) {
		this.controllerConfirmExit = controllerConfirmExit;
	}

	public ControllerSettings getControllerSettings() {
		return controllerSettings;
	}

	public void setControllerSettings(ControllerSettings controllerSettings) {
		this.controllerSettings = controllerSettings;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == start.getButtonStartGame()) {
			start.getButtonStartGame().setIcon(start.getImgButtonPlayHover());
		} else if (e.getComponent() == start.getButtonClose()) {
			start.getButtonClose().setIcon(start.getImgButtonCloseHover());
		} else if (e.getComponent() == start.getButtonHelp()) {
			start.getButtonHelp().setIcon(start.getImgButtonHelpHover());
		} else if (e.getComponent() == start.getButtonSettings()) {
			start.getButtonSettings().setIcon(start.getImgButtonSettingsHover());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == start.getButtonStartGame()) {
			start.getButtonStartGame().setIcon(start.getImgButtonPlayNormal());
		} else if (e.getComponent() == start.getButtonClose()) {
			start.getButtonClose().setIcon(start.getImgButtonCloseNormal());
		} else if (e.getComponent() == start.getButtonHelp()) {
			start.getButtonHelp().setIcon(start.getImgButtonHelpNomal());
		} else if (e.getComponent() == start.getButtonSettings()) {
			start.getButtonSettings().setIcon(start.getImgButtonSettingsNormal());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == start.getButtonStartGame()) {
			start.getButtonStartGame().setIcon(start.getImgButtonPlayClick());
		} else if (e.getComponent() == start.getButtonClose()) {
			start.getButtonClose().setIcon(start.getImgButtonCloseClick());
		} else if (e.getComponent() == start.getButtonHelp()) {
			start.getButtonHelp().setIcon(start.getImgButtonHelpClick());
		} else if (e.getComponent() == start.getButtonSettings()) {
			start.getButtonSettings().setIcon(start.getImgButtonSettingsClick());
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == start.getButtonStartGame()) {
			start.getButtonStartGame().setIcon(start.getImgButtonPlayHover());
		} else if (e.getComponent() == start.getButtonClose()) {
			start.getButtonClose().setIcon(start.getImgButtonCloseHover());
		} else if (e.getComponent() == start.getButtonHelp()) {
			start.getButtonHelp().setIcon(start.getImgButtonHelpHover());
		} else if (e.getComponent() == start.getButtonSettings()) {
			start.getButtonSettings().setIcon(start.getImgButtonSettingsHover());
		}

	}

}
