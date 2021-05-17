package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Inventory extends Panel {

	public static final long serialVersionUID = 1L;
	public BufferedImage[] imgsLife;
	public BufferedImage imgInformationIcon, imgHelpIcon, imgCloseIcon, imgDeleteIcon, imgScoreIcon, imgMissionBoard,
			imgButtonRun, imgButtonRunHover;

	public Inventory() {
		setBounds(1066, 0, 300, Window.HEIGHT);
		
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

		try {
			imgInformationIcon = ImageIO.read(getClass().getResource("/assets/information.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGINFORMATION NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgHelpIcon = ImageIO.read(getClass().getResource("/assets/help.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGHELP NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgDeleteIcon = ImageIO.read(getClass().getResource("/assets/delete.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGDELETE NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgCloseIcon = ImageIO.read(getClass().getResource("/assets/closeapp.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGDELETE NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgScoreIcon = ImageIO.read(getClass().getResource("/assets/score.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGSCORE NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgMissionBoard = ImageIO.read(getClass().getResource("/assets/mission_board.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGMISSIONBOARD NOT FOUND.");
			e.printStackTrace();
		}
		try {
			imgButtonRun = ImageIO.read(getClass().getResource("/assets/button_run.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGBURRONRUN NOT FOUND.");
			e.printStackTrace();
		}

		try {
			imgButtonRunHover = ImageIO.read(getClass().getResource("/assets/button_run_hover.png"));
		} catch (IOException e) {
			System.out.println("ERROR: IMGBURRONRUNHOVER NOT FOUND.");
			e.printStackTrace();
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

	public void drawMission(Graphics g) {
		g.drawImage(imgMissionBoard, 0, 180, 300, 228, null);
	}

	public void drawLife(Graphics g) {
		int x = 0, y = 85;

		for (int i = 0; i < imgsLife.length; i++) {
			g.drawImage(imgsLife[i], x, y, 30, 30, null);
			x += 20;
		}
	}

	public void drawIcons(Graphics g) {
		int x = 0, y = 20;
		int margin = 90;
		g.drawImage(imgInformationIcon, x, y, null);
		x += margin;
		g.drawImage(imgHelpIcon, x, y, null);
		x += margin;
		g.drawImage(imgDeleteIcon, x, y, null);
		x += margin;
		g.drawImage(imgCloseIcon, x, y, null);

	}

	public void drawScore(Graphics g) {
		g.setColor(Color.yellow);
		g.drawImage(imgScoreIcon, 0, 120, 73, 34, null);
		g.drawString("500", 35, 142);
	}

	public void drawnButtonRun(Graphics g) {
		g.drawImage(imgButtonRun, 100, 420, 106, 62, null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		init();

		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString("VIDA", 5, 80);
		drawLife(g);
		drawIcons(g);
		drawnButtonRun(g);
		drawMission(g);
		drawScore(g);
		

		/*
		 * g.drawImage(ImageIO.read(getClass().getResource("/assets/life.png")), 0, 40,
		 * 30, 30, null);
		 * g.drawImage(ImageIO.read(getClass().getResource("/assets/life.png")), 20, 40,
		 * 30, 30, null);
		 * g.drawImage(ImageIO.read(getClass().getResource("/assets/life.png")), 40, 40,
		 * 30, 30, null);
		 * g.drawImage(ImageIO.read(getClass().getResource("/assets/life.png")), 60, 40,
		 * 30, 30, null);
		 * g.drawImage(ImageIO.read(getClass().getResource("/assets/life.png")), 80, 40,
		 * 30, 30, null);
		 */

	}

}
