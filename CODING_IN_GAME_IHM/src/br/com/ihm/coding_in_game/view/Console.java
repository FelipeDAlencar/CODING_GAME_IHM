package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import br.com.ihm.coding_in_game.model.Util;

public class Console extends Panel {

	private static final long serialVersionUID = 1L;

	private JLabel labelBoardConsole;
	private ArrayList<JLabel> comandsLabels;
	private JLabel labelTitleBoardConsole;
	private Panel content;
	private JScrollPane contentScroll;
	Console() {

		setBounds(0, 668, 1046, 100);
		setBackground(new Color(0, 0, 0, 0));

		labelBoardConsole = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board.png")));
		labelBoardConsole.setBounds(0, 0, 300, 228);

		labelTitleBoardConsole = new JLabel("CONSOLE");
		labelTitleBoardConsole.setForeground(new Color(61, 57, 57));
		labelTitleBoardConsole.setFont(Util.FONT_TITLE_BOARD);
		labelTitleBoardConsole.setBounds(102, 13, 250, 20);
		
	
		
		content = new Panel();
		content.setBounds(30,60,233,133);
		content.setBackground(Util.COLOR_TRANSPARENT);
		GridLayout layoutPanelPlayer = new GridLayout(20, 1);
		layoutPanelPlayer.setVgap(5);
		content.setLayout(layoutPanelPlayer);
		
		for(int i = 0; i < 20; i++) {
			content.add(new JLabel("Teste"));
		}
		
		
		contentScroll = new JScrollPane(content);
		contentScroll.setBounds(35,60,233,133);
		
		
		comandsLabels = new ArrayList<>();
		
		
		add(contentScroll);
		add(labelTitleBoardConsole);
		add(labelBoardConsole);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	
	public JLabel getLabelBoardConsole() {
		return labelBoardConsole;
	}

	public void setLabelBoardConsole(JLabel labelBoardConsole) {
		this.labelBoardConsole = labelBoardConsole;
	}

	public ArrayList<JLabel> getComandsLabels() {
		return comandsLabels;
	}

	public void setComandsLabels(ArrayList<JLabel> comandsLabels) {
		this.comandsLabels = comandsLabels;
	}

	public JLabel getLabelTitleBoardConsole() {
		return labelTitleBoardConsole;
	}

	public void setLabelTitleBoardConsole(JLabel labelTitleBoardConsole) {
		this.labelTitleBoardConsole = labelTitleBoardConsole;
	}

	public Panel getContent() {
		return content;
	}

	public void setContent(Panel content) {
		this.content = content;
	}

	public JScrollPane getContentScroll() {
		return contentScroll;
	}

	public void setContentScroll(JScrollPane contentScroll) {
		this.contentScroll = contentScroll;
	}
	
	
	

}
