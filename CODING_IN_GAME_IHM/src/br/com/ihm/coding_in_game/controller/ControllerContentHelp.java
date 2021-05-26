package br.com.ihm.coding_in_game.controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;

import br.com.ihm.coding_in_game.view.ContentHelp;

public class ControllerContentHelp implements ActionListener, MouseListener {
	private ContentHelp contentHelp;

	public ControllerContentHelp(ContentHelp contentHelp) {
		this.contentHelp = contentHelp;

		this.contentHelp.getButtonClose().addActionListener(this);
		this.contentHelp.getLabelLink().addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == contentHelp.getButtonClose()) {
			contentHelp.getWindow().setVisible(false);
			contentHelp.setVisible(false);
			// System.exit(0);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getComponent() == contentHelp.getLabelLink()) {
			try {
				java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.youtube.co/"));
			} catch (IOException e1) {
				System.out.println("ERRO DE ENTRADA E SAÍDA");
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				System.out.println("ERRO DE SINTAXE DO LINK");
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() == contentHelp.getLabelLink()) {
			contentHelp.getLabelLink().setForeground(new Color(5, 107, 180));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		contentHelp.getLabelLink().setForeground(new Color(61, 57, 57));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
