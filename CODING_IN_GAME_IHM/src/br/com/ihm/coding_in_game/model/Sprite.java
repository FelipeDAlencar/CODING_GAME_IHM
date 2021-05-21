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
	private String direction;

	protected Sprite(int aparencia, int largura, int altura, int colunas, int linhas, int posX, int posY, String endereco) throws IOException {

		try {
			this.hero = ImageIO.read(getClass().getResource(endereco));
			this.aparence = aparencia;
			this.width = largura;
			this.height = altura;

			this.rows = colunas;
			this.cols = linhas;
			this.posX = posX;
			this.posY = posY;

			sprites = new BufferedImage[colunas * linhas];
			for (int i = 0; i < colunas; i++) {
				for (int j = 0; j < linhas; j++) {
					sprites[(i * linhas) + j] = hero.getSubimage(i* (largura / colunas), j * (altura / linhas), largura / colunas, altura / linhas);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel carregar a Sprite");
		}
	}

	public abstract void animate(String direcao);

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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	
	

}
