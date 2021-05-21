package br.com.ihm.coding_in_game.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

public class Hero extends Sprite {
	private int x, y;
	private boolean visible;
	private Image image;
	private int life;
	public static final int VELOCITY = 2;
	protected int posiction = 4;

	public Hero(int aparencia, int largura, int altura, int colunas, int linhas, int posX, int posY, String endereco)
			throws IOException {
		super(aparencia, largura, altura, colunas, linhas, posX, posY, endereco);

		init();
	}

	private void init() {
		life = 5;
		visible = true;
	}

	public void moveHero(int dx, int dy, String direction) {

		setPosX(getPosX() + dx);
		setPosY(getPosY() + dy);
		
		

		if (direction.equals(Util.UP)) {
			setY(getY() - VELOCITY);
			this.posiction = 1;
		}

		if (direction.equals(Util.DOWN)) {
			setY(getY() + VELOCITY);
			this.posiction = 1;
		}

		if (direction.equals(Util.LEFT)) {
			setX(getX() - VELOCITY);
			this.posiction = 1;
		}

		if (direction.equals(Util.RIGHT)) {
			setX(getX() + VELOCITY);
			this.posiction = 1;
		}
	}

	@Override
	public void animate(String direction) {
		setDirection(direction);

		if (direction.equals(Util.UP)) {

			switch (getUp()) {

			case 0:
				setAparence(3);
				break;
			case 1:
				setAparence(7);
				break;
			case 2:
				setAparence(11);
				break;

			}

			if (getUp() == 2)
				setUp(0);
			else
				setUp(getUp() + 1);

		}

		if (direction.equals(Util.DOWN)) {

			switch (getDown()) {

			case 0:
				setAparence(3);
				break;
			case 1:
				setAparence(7);
				break;
			case 2:
				setAparence(11);
				break;

			}

			if (getDown() == 2)
				setDown(0);
			else
				setDown(getDown() + 1);

		}

		if (direction.equals(Util.LEFT)) {

			switch (getLeft()) {

			case 0:
				setAparence(1);
				break;
			case 1:
				setAparence(5);
				break;
			case 2:
				setAparence(9);
				break;

			}
			if (getLeft() == 2)
				setLeft(0);
			else
				setLeft(getLeft() + 1);

		}

		if (direction.equals(Util.RIGHT)) {

			switch (getRight()) {

			case 0:
				setAparence(1);
				break;
			case 1:
				setAparence(5);
				break;
			case 2:
				setAparence(9);
				break;

			}
			if (getRight() == 2)
				setRight(0);
			else
				setRight(getRight() + 1);

		}

	}

	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparence()], getPosX(), getPosY(), null);
	}

	public Rectangle getBounds() {
		return new Rectangle(getPosX(), getPosY(), getWidth() / getCols(), getHeight() / getRows());

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
