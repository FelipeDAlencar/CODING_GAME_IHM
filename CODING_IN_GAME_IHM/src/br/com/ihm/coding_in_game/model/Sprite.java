package br.com.ihm.coding_in_game.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Sprite {
	protected BufferedImage hero;
	protected int width, height;
	protected int rows, cols;
	protected int posX, posY;
	protected BufferedImage[] sprites;
	protected int aparence;
	protected int up, down, left, right;
	private int direction;

	protected Sprite(int aparence, int width, int height, int cols, int rows, int posX, int posY, String path) throws IOException {

		try {
			this.hero = ImageIO.read(getClass().getResource(path));
			this.aparence = aparence;
			this.width = width;
			this.height = height;

			this.rows = cols;
			this.cols = rows;
			this.posX = posX;
			this.posY = posY;

			sprites = new BufferedImage[cols * rows];
			for (int i = 0; i < cols; i++) {
				for (int j = 0; j < rows; j++) {
					sprites[(i * rows) + j] = hero.getSubimage(i* (width / cols), j * (height / rows), width / cols, height / rows);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar a Sprite");
		}
	}

	public abstract void animate(int any);

	public BufferedImage getHero() {
		return hero;
	}

	public void setHero(BufferedImage hero) {
		this.hero = hero;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public void setSprites(BufferedImage[] sprites) {
		this.sprites = sprites;
	}

	public int getAparence() {
		return aparence;
	}

	public void setAparence(int aparence) {
		this.aparence = aparence;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}


	
	

}
