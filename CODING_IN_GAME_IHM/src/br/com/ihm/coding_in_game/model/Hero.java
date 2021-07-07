package br.com.ihm.coding_in_game.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;


public class Hero extends Sprite {
	private int x, y, futureX, futureY;
	private boolean visible;
	private Image image;
	private int life;
	public static int VELOCITY = 1;
	public static int INTERVAL_MOVE_X = (TileMap.newTileWidth * 10);
	public static int INTERVAL_MOVE_Y = (TileMap.newTileHeight * 7);
	public static int INITIAL_X = 35;
	public static int INITIAL_Y = 370;
	private int posiction;
	private boolean intersectsObjects;
	private boolean inMove;
	private boolean alreadyMoved;

	public Hero(int aparence, int width, int height, int cols, int rows, int posX, int posY, String path)
			throws IOException {
		super(aparence, width, height, cols, rows, posX, posY, path);

		init();
	}

	private void init() {
		life = 5;
		visible = true;
		posiction = Util.POSICTION_RIGHT;
		futureX = posX;
		futureY = posY;

	
	}

	public void moveHero(int dx, int dy, int direction) {

		setPosX(getPosX() + dx);
		setPosY(getPosY() + dy);

		if (direction == Util.POSICTION_UP) {
			setY(getY() - VELOCITY);
		}

		if (direction == Util.POSICTION_DOWN) {
			setY(getY() + VELOCITY);
		}

		if (direction == Util.POSICTION_LEFT) {
			setX(getX() - VELOCITY);
		}

		if (direction == Util.POSICTION_RIGHT) {
			setX(getX() + VELOCITY);
		}

	}

	@Override
	public void animate(int direction) {
		setDirection(direction);

		if (direction == Util.POSICTION_UP) {

			switch (getUp()) {

			case 0:
				setAparence(2);
				break;
			case 1:
				setAparence(6);
				break;
			case 2:
				setAparence(10);
				break;
			case 3:
				setAparence(14);
				break;

			}

			if (getUp() == 3)
				setUp(0);
			else
				setUp(getUp() + 1);

		}

		if (direction == Util.POSICTION_DOWN) {

			switch (getDown()) {

			case 0:
				setAparence(0);
				break;
			case 1:
				setAparence(4);
				break;
			case 2:
				setAparence(8);
				break;
			case 3:
				setAparence(12);
				break;

			}

			if (getDown() == 3)
				setDown(0);
			else
				setDown(getDown() + 1);

		}

		if (direction == Util.POSICTION_LEFT) {

			switch (getLeft()) {

			case 0:
				setAparence(3);
				break;
			case 1:
				setAparence(7);
				break;
			case 2:
				setAparence(11);
				break;
			case 3:
				setAparence(15);
				break;

			}
			if (getLeft() == 3)
				setLeft(0);
			else
				setLeft(getLeft() + 1);

		}

		if (direction == Util.POSICTION_RIGHT) {

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
			case 3:
				setAparence(13);
				break;
			}
			if (getRight() == 3)
				setRight(0);
			else
				setRight(getRight() + 1);

		}

	}

	public void changeAparencePosiction(String turnDirection) {

		switch (turnDirection) {
		case Util.METHOD_TURN_RIGHT:
			switch (posiction) {
			case 0:
				setAparence(1);
				posiction = Util.POSICTION_RIGHT;
				break;
			case 1:
				setAparence(3);
				posiction = Util.POSICTION_LEFT;
				break;
			case 2:
				setAparence(0);
				posiction = Util.POSICTION_DOWN;
				break;
			case 3:
				setAparence(2);
				posiction = Util.POSICTION_UP;
				break;

			default:
				System.out.println("N�o setou a apar�ncia");
				break;
			}
			break;

		case Util.METHOD_TURN_LEFT:

			switch (posiction) {
			case 0:
				setAparence(3);
				posiction = Util.POSICTION_LEFT;
				break;
			case 1:
				setAparence(1);
				posiction = Util.POSICTION_RIGHT;
				break;
			case 2:
				setAparence(2);
				posiction = Util.POSICTION_UP;
				break;
			case 3:
				setAparence(0);
				posiction = Util.POSICTION_DOWN;
				break;

			default:
				System.out.println("N�o setou a apar�ncia");
				break;
			}
			break;
		default:
			System.out.println("N�o entrou no primeiro switch");
			break;
		}

	}

	public void calculateFutureXY() {
		switch (posiction) {
		case Util.POSICTION_LEFT:
			setFutureX(getFutureX() - Hero.INTERVAL_MOVE_X);
			break;
		case Util.POSICTION_RIGHT:
			setFutureX(getFutureX() + Hero.INTERVAL_MOVE_X);
			break;
		case Util.POSICTION_UP:
			setFutureY(getFutureY() - Hero.INTERVAL_MOVE_Y);
			break;
		case Util.POSICTION_DOWN:
			setFutureY(getFutureY() + Hero.INTERVAL_MOVE_Y);
			break;
		default:
			break;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparence()], getPosX(), getPosY(), null);
		g.drawRect(getPosX() - 5, getPosY() - 5, (getWidth() / getCols()) + 10, (getHeight() / getRows()) + 10);
	}

	public Rectangle getBounds() {
		return new Rectangle(getPosX() - 5, getPosY() - 5, (getWidth() / getCols()) + 10,
				(getHeight() / getRows()) + 10);

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

	public boolean isIntersectsObjects() {
		return intersectsObjects;
	}

	public void setIntersectsObjects(boolean intersectsObjects) {
		this.intersectsObjects = intersectsObjects;
	}

	public int getPosiction() {
		return posiction;
	}

	public void setPosiction(int posiction) {
		this.posiction = posiction;
	}

	public int getFutureX() {
		return futureX;
	}

	public void setFutureX(int futureX) {
		this.futureX = futureX;
	}

	public int getFutureY() {
		return futureY;
	}

	public void setFutureY(int futureY) {
		this.futureY = futureY;
	}

	public boolean isInMove() {
		return inMove;
	}

	public void setInMove(boolean inMove) {
		this.inMove = inMove;
	}

	
	public boolean isAlreadyMoved() {
		return alreadyMoved;
	}

	public void setAlreadyMoved(boolean alreadyMoved) {
		this.alreadyMoved = alreadyMoved;
	}

}
