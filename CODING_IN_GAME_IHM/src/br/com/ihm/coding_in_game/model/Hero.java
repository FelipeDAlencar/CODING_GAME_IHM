package br.com.ihm.coding_in_game.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

public class Hero extends Sprite{
	private int x, y;
	private boolean visible;
	private Image image;
	private int life;
	
	public Hero(int aparencia, int largura, int altura, int colunas, int linhas, int posX, int posY, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, posX, posY, endereco);
		
		init();
	}
	
	
	private void init() {
		life = 5;
		visible = true;
	}
	@Override
	public void animar(String direcao) {
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getPosX(), getPosY(), getLargura() / getColunas(), getAltura() / getLinhas());

	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public int getLife() {
		return life;
	}


	public void setLife(int life) {
		this.life = life;
	}
	
	
	

}
