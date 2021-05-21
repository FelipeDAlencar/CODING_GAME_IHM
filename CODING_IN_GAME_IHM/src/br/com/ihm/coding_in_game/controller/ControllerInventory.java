package br.com.ihm.coding_in_game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ihm.coding_in_game.view.Inventory;
import br.com.ihm.coding_in_game.view.Window;

public class ControllerInventory implements ActionListener{
	private Inventory inventory;
	private Window window;
	
	public ControllerInventory(Window window) {
		
		this.window = window;
		this.inventory = window.getInventory();
		
		// ADD EVENTS
		this.inventory.getButtonInfo().addActionListener(this);
		this.inventory.getButtonClose().addActionListener(this);
		this.inventory.getButtonDelete().addActionListener(this);
		this.inventory.getButtonExecute().addActionListener(this);
		this.inventory.getButtonReset().addActionListener(this);
		this.inventory.getButtonHelp().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inventory.getButtonInfo()) {
			System.out.println("INFO");
		}else if(e.getSource() == inventory.getButtonHelp()) {
			System.out.println("HELP");
		}else if(e.getSource() == inventory.getButtonDelete()) {
			System.out.println("DELETE");
		}else if(e.getSource() == inventory.getButtonClose()){
			System.exit(0);
		}else if(e.getSource() == inventory.getButtonExecute()) {
			System.out.println("EXECUTE");
		}else {
			System.out.println("RESET");
		}
	}
	

}
