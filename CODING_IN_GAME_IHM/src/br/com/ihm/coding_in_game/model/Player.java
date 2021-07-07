package br.com.ihm.coding_in_game.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player {
	private String name;
	private int score;
	private int amountMoves;
	private int currentPhase;
	private int lifes;
	private ArrayList<BufferedImage> imgsLife;


	public Player(String name, int score, int amountMove, int currentPhase, int lifes) {
		this.name = name;
		this.score = score;
		this.amountMoves = amountMove;
		this.currentPhase = currentPhase;
		this.lifes = lifes;
		
		
		initImgsLife();
	}
	
	public void initImgsLife() {
		imgsLife = new ArrayList<>();
		for (int i = 0; i < lifes; i++) {
			try {
				BufferedImage image = ImageIO.read(getClass().getResource("/assets/life.png"));
				imgsLife.add(image);
			} catch (IOException e) {
				System.out.println("ERROR: IMGLIFE NOT FOUND.");
				e.printStackTrace();
			}
		}
	}

	public String getName() {
		if (name.length() == 0) {
			return "ANÔNIMO";
		}
		return name;
	}


	
	
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", amountMoves=" + amountMoves + ", currentPhase="
				+ currentPhase + ", lifes=" + lifes + ", imgsLife=" + imgsLife + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAmountMoves() {
		return amountMoves;
	}

	public void setAmountMoves(int amountMoves) {
		this.amountMoves = amountMoves;
	}

	public int getCurrentPhase() {
		return currentPhase;
	}

	public void setCurrentPhase(int currentPhase) {
		this.currentPhase = currentPhase;
	}
	

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	
	
	
	public ArrayList<BufferedImage> getImgsLife() {
		return imgsLife;
	}

	public void setImgsLife(ArrayList<BufferedImage> imgsLife) {
		this.imgsLife = imgsLife;
	}


}
