package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Inventory extends Panel {

	public static final long serialVersionUID = 1L;
	private BufferedImage[] imgsLife;
	private JLabel labelMission, labelConsole, labelScore;
	
	private JButton buttonInfo, buttonHelp, buttonDelete, buttonClose, buttonExecute, buttonReset;

	private boolean isInit = true;

	public Inventory() {
		setBounds(1046, 0, 320, WindowMain.HEIGHT);
		setBackground(new Color(58, 47, 36));

		int x = 10, y = 20;
		int margin = 90;
		int width = 30, height = 30;

		buttonInfo = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/information.png")));
		buttonInfo.setBounds(x, y, width, height);
		buttonInfo.setContentAreaFilled(false);
		buttonInfo.setBorder(null);
		buttonInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonInfo.setToolTipText("<html><center><strong>INFORMAÇÕES</strong></center></html>");

		x += margin;
		buttonHelp = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/help.png")));
		buttonHelp.setBounds(x, y, width, height);
		buttonHelp.setContentAreaFilled(false);
		buttonHelp.setBorder(null);
		buttonHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonHelp.setToolTipText("<html><center><strong>AJUDA</strong></center></html>");

		
		
		x += margin;
		buttonDelete = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/delete.png")));
		buttonDelete.setBounds(x, y, width, height);
		buttonDelete.setContentAreaFilled(false);
		buttonDelete.setBorder(null);
		buttonDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonDelete.setToolTipText("<html><center><strong>DELETAR COMANDO</strong></center></html>");

		
		x += margin;
		buttonClose = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/closeapp.png")));
		buttonClose.setBounds(x, y, width, height);
		buttonClose.setContentAreaFilled(false);
		buttonClose.setBorder(null);
		buttonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonClose.setToolTipText("<html><center><strong>SAIR DO JOGO</strong></center></html>");



		// g.drawImage(imgButtonRun, 20, 640, 106, 62, null);
		// g.drawImage(imgButtonReset, 193, 640, 106, 62, null);
		
		//g.drawImage(imgScoreIcon, 10, 120, 73, 34, null);

		x = 10;
		y = 120;
		width = 73;
		height = 34; 
				
		labelScore = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/score.png")));
		labelScore.setBounds(x, y, width, height);
						

		x = 20;
		y = 640;
		width = 106;
		height = 56;

		buttonExecute = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/button_run.png")));
		buttonExecute.setBounds(x, y, width, height);
		buttonExecute.setContentAreaFilled(false);
		buttonExecute.setBorder(null);
		buttonExecute.setBorderPainted(false);
		buttonExecute.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		x = 193;

		buttonReset = new JButton(new ImageIcon(getClass().getClassLoader().getResource("assets/button_reset.png")));
		buttonReset.setBounds(x, y, width, height);
		buttonReset.setContentAreaFilled(false);
		buttonReset.setBorder(null);
		buttonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));


		// g.drawImage(imgMissionBoard, 10, 160, 300, 228, null);
		// g.drawImage(imgConsole, 10, 400, 300, 228, null);
		
		x = 10;
		y = 160;
		width = 300;
		height = 228;
		labelMission = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/mission_board.png")));
		labelMission.setBounds(x, y, width, height);
		
		y = 400;
		
		labelConsole = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/console.png")));
		labelConsole.setBounds(x, y, width, height);
		
		
		
				
		add(labelMission);
		add(labelConsole);
		add(labelScore);
		add(buttonInfo);
		add(buttonHelp);
		add(buttonDelete);
		add(buttonClose);
		add(buttonExecute);
		add(buttonReset);
		setVisible(false);
	}

	public void init() {
		imgsLife = new BufferedImage[5];
		for (int i = 0; i < imgsLife.length; i++) {
			try {
				imgsLife[i] = ImageIO.read(getClass().getResource("/assets/life.png"));
			} catch (IOException e) {
				System.out.println("ERROR: IMGLIFE NOT FOUND.");
				e.printStackTrace();
			}
		}

		

	}

	public void drawBtnRun(Graphics g) {
		int x = 10, y = 500;
		int width = this.getSize().width - 20;
		int height = 40;

		g.setColor(Color.WHITE);
		g.draw3DRect(x, y, width, height, false);
		g.setColor(Color.GRAY);
		g.fill3DRect(x, y, width, height, false);
		g.setColor(Color.white);
		g.drawString("EXECUTAR", 108, 525);

	}

	public void drawLife(Graphics g) {
		int x = 10, y = 85;
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.setColor(Color.white);
		g.drawString("VIDA", 15, 80);
		for (int i = 0; i < imgsLife.length; i++) {
			g.drawImage(imgsLife[i], x, y, 30, 30, null);
			x += 20;
		}
	}


	public void drawScore(Graphics g) {
		g.setColor(Color.yellow);
		g.drawString("10", 45, 142);
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (isInit) {
			init();
			isInit = false;
		}

		drawLife(g);
		// drawIcons(g);
		// drawnButtonRun(g);
		drawScore(g);
		// drawBtnReset(g);

	}

	public BufferedImage[] getImgsLife() {
		return imgsLife;
	}

	public void setImgsLife(BufferedImage[] imgsLife) {
		this.imgsLife = imgsLife;
	}

	public JButton getButtonInfo() {
		return buttonInfo;
	}

	public void setButtonInfo(JButton buttonInfo) {
		this.buttonInfo = buttonInfo;
	}

	public JButton getButtonHelp() {
		return buttonHelp;
	}

	public void setButtonHelp(JButton buttonHelp) {
		this.buttonHelp = buttonHelp;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}

	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}

	public JButton getButtonClose() {
		return buttonClose;
	}

	public void setButtonClose(JButton buttonClose) {
		this.buttonClose = buttonClose;
	}

	public boolean isInit() {
		return isInit;
	}

	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}

	public JButton getButtonExecute() {
		return buttonExecute;
	}

	public void setButtonExecute(JButton buttonExecute) {
		this.buttonExecute = buttonExecute;
	}

	public JButton getButtonReset() {
		return buttonReset;
	}

	public void setButtonReset(JButton buttonReset) {
		this.buttonReset = buttonReset;
	}

}
