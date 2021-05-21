package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.ContentHelp;

public class ControllerContentHelp implements ActionListener{
	private ContentHelp contentHelp;
	
	public ControllerContentHelp(ContentHelp contentHelp) {
		this.contentHelp = contentHelp;
		
		this.contentHelp.getButtonClose().addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == contentHelp.getButtonClose()) {
			contentHelp.getWindow().dispose();
		}
		
	}
	
	

}
