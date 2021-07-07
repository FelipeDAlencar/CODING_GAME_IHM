package br.com.ihm.coding_in_game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flag {

	private BufferedImage image;
	private boolean visible;
	private int posX, posY;
	private int width, height;

	public Flag(int width, int height, int posX, int posY) {
		init(width, height, posX, posY);
	}

	private void init(int width, int height, int posX, int posY) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/flags.png"));
		} catch (IOException e) {
			System.err.println("ERROR: IMAGE FLAGS NOT FOUND");
			e.printStackTrace();
		}
		visible = true;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(posX, posY, width, height);
	}

	public void draw(Graphics g) {
		g.drawImage(image, getPosX(), getPosY(), null);


	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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

}
