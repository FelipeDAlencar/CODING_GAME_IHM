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

import br.com.ihm.coding_in_game.model.Util;

public class Inventory extends Panel {

	public static final long serialVersionUID = 1L;
	private BufferedImage[] imgsLife;
	private JLabel labelBoardMethods, labelConsole, labelScore, labelMoveUp, labelMoveDown, labelTurnLeft,
			labelTurnRight, labelMoveFront, labelTitleBoardMehtods, labelTitleBoardConsole, labelContentConsole;

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

		// g.drawImage(imgScoreIcon, 10, 120, 73, 34, null);

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
		labelBoardMethods = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board.png")));
		labelBoardMethods.setBounds(x, y, width, height);

		y = 400;

		labelConsole = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board.png")));
		labelConsole.setBounds(x, y, width, height);

		y = 308;
		x = 110;
		labelTitleBoardConsole = new JLabel("<html><center><strong>CONSOLE</strong></center></html>");
		labelTitleBoardConsole.setForeground(new Color(61, 57, 57));
		labelTitleBoardConsole.setFont(new Font("Arial Bold", Font.BOLD, 20));
		labelTitleBoardConsole.setBounds(x, y, width, height);

		y = 360;
		x = 50;
		width = 300;
		height = 228;

		labelContentConsole = new JLabel("");
		labelContentConsole.setFont(new Font("Arial Bold", Font.BOLD, 15));
		labelContentConsole.setBounds(x, y, width, height);
		labelContentConsole.setToolTipText("<html><center><strong>COMANDOS ADICIONADOS</strong></center></html>");
	

		width = 300;
		height = 228;
		y = 68;
		x = 110;
		labelTitleBoardMehtods = new JLabel("<html><center><strong>MÉTODOS</strong></center></html>");
		labelTitleBoardMehtods.setForeground(new Color(61, 57, 57));
		labelTitleBoardMehtods.setFont(new Font("Arial Bold", Font.BOLD, 20));
		labelTitleBoardMehtods.setBounds(x, y, width, height);

		y = 220;
		x = 50;
		width = 155;
		height = 40;
		margin = 30;
		labelTurnRight = new JLabel(Util.METHOD_TURN_RIGHT);
		labelTurnRight.setFont(new Font("Arial Bold", Font.BOLD, 15));
		labelTurnRight.setBounds(x, y, width, height);
		labelTurnRight
				.setToolTipText("<html><center><strong>CLICK PARA SER ADICIONADO AO CONSOLE</strong></center></html>");
		labelTurnRight.setCursor(new Cursor(Cursor.HAND_CURSOR));

		y += margin;
		labelTurnLeft = new JLabel(Util.METHOD_TURN_LEFT);
		labelTurnLeft.setFont(new Font("Arial Bold", Font.BOLD, 15));
		labelTurnLeft.setBounds(x, y, width, height);
		labelTurnLeft
				.setToolTipText("<html><center><strong>CLICK PARA SER ADICIONADO AO CONSOLE</strong></center></html>");
		labelTurnLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));

		y += margin;
		labelMoveFront = new JLabel(Util.METHOD_MOVE_FRONT);
		labelMoveFront.setFont(new Font("Arial Bold", Font.BOLD, 15));
		labelMoveFront.setBounds(x, y, width, height);
		labelMoveFront
				.setToolTipText("<html><center><strong>CLICK PARA SER ADICIONADO AO CONSOLE</strong></center></html>");
		labelMoveFront.setCursor(new Cursor(Cursor.HAND_CURSOR));

		add(labelContentConsole);
		add(labelTitleBoardConsole);
		add(labelTitleBoardMehtods);
		add(labelMoveFront);
		add(labelTurnLeft);
		add(labelTurnRight);
		add(labelBoardMethods);
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

	public JLabel getLabelBoardMethods() {
		return labelBoardMethods;
	}

	public void setLabelBoardMethods(JLabel labelBoardMethods) {
		this.labelBoardMethods = labelBoardMethods;
	}

	public JLabel getLabelConsole() {
		return labelConsole;
	}

	public void setLabelConsole(JLabel labelConsole) {
		this.labelConsole = labelConsole;
	}

	public JLabel getLabelScore() {
		return labelScore;
	}

	public void setLabelScore(JLabel labelScore) {
		this.labelScore = labelScore;
	}

	public JLabel getLabelMoveUp() {
		return labelMoveUp;
	}

	public void setLabelMoveUp(JLabel labelMoveUp) {
		this.labelMoveUp = labelMoveUp;
	}

	public JLabel getLabelMoveDown() {
		return labelMoveDown;
	}

	public void setLabelMoveDown(JLabel labelMoveDown) {
		this.labelMoveDown = labelMoveDown;
	}

	public JLabel getLabelTurnLeft() {
		return labelTurnLeft;
	}

	public void setLabelTurnLeft(JLabel labelTurnLeft) {
		this.labelTurnLeft = labelTurnLeft;
	}

	public JLabel getLabelTurnRight() {
		return labelTurnRight;
	}

	public void setLabelTurnRight(JLabel labelTurnRight) {
		this.labelTurnRight = labelTurnRight;
	}

	public JLabel getLabelMoveFront() {
		return labelMoveFront;
	}

	public void setLabelMoveFront(JLabel labelMoveFront) {
		this.labelMoveFront = labelMoveFront;
	}

	public JLabel getLabelTitleBoardMehtods() {
		return labelTitleBoardMehtods;
	}

	public void setLabelTitleBoardMehtods(JLabel labelTitleBoardMehtods) {
		this.labelTitleBoardMehtods = labelTitleBoardMehtods;
	}

	public JLabel getLabelTitleBoardConsole() {
		return labelTitleBoardConsole;
	}

	public void setLabelTitleBoardConsole(JLabel labelTitleBoardConsole) {
		this.labelTitleBoardConsole = labelTitleBoardConsole;
	}

	public JLabel getLabelContentConsole() {
		return labelContentConsole;
	}

	public void setLabelContentConsole(JLabel labelContentConsole) {
		this.labelContentConsole = labelContentConsole;
	}

	

}
