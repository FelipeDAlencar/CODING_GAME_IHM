package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.com.ihm.coding_in_game.view.GeneralContentDialog;

public class ControllerGeneralContentDialog implements ActionListener, MouseListener {

	private GeneralContentDialog generalContentDialog;

	public ControllerGeneralContentDialog(GeneralContentDialog generalContentDialog) {
		this.generalContentDialog = generalContentDialog;
		init();
	}

	private void init() {
		generalContentDialog.getButtonClose().addActionListener(this);
		generalContentDialog.getButtonClose().addMouseListener(this);
		generalContentDialog.getButtonLeft().addActionListener(this);
		generalContentDialog.getButtonLeft().addMouseListener(this);
		generalContentDialog.getButtonRight().addActionListener(this);
		generalContentDialog.getButtonRight().addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generalContentDialog.getButtonClose()) {
			generalContentDialog.setVisible(false);
			generalContentDialog.getLabelContent().setText(generalContentDialog.getInfoFlag());
			generalContentDialog.getButtonLeft().setVisible(false);
			generalContentDialog.getLabelBomb().setVisible(false);
			generalContentDialog.getLabelDelimiter().setVisible(false);
			generalContentDialog.getLabelFlags().setVisible(true);
			generalContentDialog.getWindowDialog().getWindowParent().setEnabled(true);
			generalContentDialog.getWindowDialog().setVisible(false);
			generalContentDialog.getButtonLeft().setVisible(false);
			generalContentDialog.getButtonRight().setVisible(false);
			generalContentDialog.getLabelBomb().setVisible(false);
			generalContentDialog.getLabelDelimiter().setVisible(false);
			generalContentDialog.getLabelFlags().setVisible(false);

		}else if(e.getSource() == generalContentDialog.getButtonRight()) {
			String content =  generalContentDialog.getLabelContent().getText();
			if(content.equals(generalContentDialog.getInfoFlag())) {
				generalContentDialog.getLabelContent().setText(generalContentDialog.getInfoDelimiter());
				generalContentDialog.getButtonLeft().setVisible(true);
				generalContentDialog.getLabelFlags().setVisible(false);
				generalContentDialog.getLabelDelimiter().setVisible(true);
			}else if(content.equals(generalContentDialog.getInfoDelimiter())) {
				generalContentDialog.getLabelContent().setText(generalContentDialog.getInfoBomb());
				generalContentDialog.getLabelDelimiter().setVisible(false);
				generalContentDialog.getLabelBomb().setVisible(true);
				generalContentDialog.getButtonRight().setVisible(false);
				
			}
			
		}else if(e.getSource() == generalContentDialog.getButtonLeft()) {
			String content =  generalContentDialog.getLabelContent().getText();
			if(content.equals(generalContentDialog.getInfoBomb())) {
				generalContentDialog.getLabelContent().setText(generalContentDialog.getInfoDelimiter());
				generalContentDialog.getLabelDelimiter().setVisible(true);
				generalContentDialog.getLabelBomb().setVisible(false);
				generalContentDialog.getButtonLeft().setVisible(true);
			}else if(content.equals(generalContentDialog.getInfoDelimiter())) {
				generalContentDialog.getLabelContent().setText(generalContentDialog.getInfoFlag());
				generalContentDialog.getLabelDelimiter().setVisible(false);
				generalContentDialog.getLabelFlags().setVisible(true);
				generalContentDialog.getButtonLeft().setVisible(false);
				generalContentDialog.getButtonRight().setVisible(true);
				
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == generalContentDialog.getButtonClose()) {
			generalContentDialog.getButtonClose().setIcon(generalContentDialog.getImgButtonCloseHover());
		} else if (e.getComponent() == generalContentDialog.getButtonLeft()) {
			generalContentDialog.getButtonLeft().setIcon(generalContentDialog.getImgButtonMoveLeftHover());
		} else if (e.getComponent() == generalContentDialog.getButtonRight()) {
			generalContentDialog.getButtonRight().setIcon(generalContentDialog.getImgButtonMoveRightHover());
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getComponent() == generalContentDialog.getButtonClose()) {
			generalContentDialog.getButtonClose().setIcon(generalContentDialog.getImgButtonCloseNormal());
		} else if (e.getComponent() == generalContentDialog.getButtonLeft()) {
			generalContentDialog.getButtonLeft().setIcon(generalContentDialog.getImgButtonMoveLeftNormal());
		} else if (e.getComponent() == generalContentDialog.getButtonRight()) {
			generalContentDialog.getButtonRight().setIcon(generalContentDialog.getImgButtonMoveRightNormal());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getComponent() == generalContentDialog.getButtonClose()) {
			generalContentDialog.getButtonClose().setIcon(generalContentDialog.getImgButtonCloseClick());
		} else if (e.getComponent() == generalContentDialog.getButtonLeft()) {
			generalContentDialog.getButtonLeft().setIcon(generalContentDialog.getImgButtonMoveLeftClick());
		} else if (e.getComponent() == generalContentDialog.getButtonRight()) {
			generalContentDialog.getButtonRight().setIcon(generalContentDialog.getImgButtonMoveRightClick());
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getComponent() == generalContentDialog.getButtonClose()) {
			generalContentDialog.getButtonClose().setIcon(generalContentDialog.getImgButtonCloseHover());
		} else if (e.getComponent() == generalContentDialog.getButtonLeft()) {
			generalContentDialog.getButtonLeft().setIcon(generalContentDialog.getImgButtonMoveLeftHover());
		} else if (e.getComponent() == generalContentDialog.getButtonRight()) {
			generalContentDialog.getButtonRight().setIcon(generalContentDialog.getImgButtonMoveRightHover());
		}

	}

}
