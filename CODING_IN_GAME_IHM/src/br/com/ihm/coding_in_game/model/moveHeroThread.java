package br.com.ihm.coding_in_game.model;

import java.util.Arrays;

public class moveHeroThread extends Thread {
	private Hero hero;
	private int dx = 0, dy = 0;
	private int move = 4;
	private String[] comands;
	private int index;

	public moveHeroThread(Hero hero) {
		this.hero = hero;
		start();
	}

	@Override
	public void run() {
		super.run();

		while (true) {
			try {
				moveHero(move);
				iteratorComands();
				sleep(4);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void moveHero(int posiction) throws InterruptedException {
		switch (posiction) {
		case Util.POSICTION_UP:
			if (hero.getPosY() != hero.getFutureY()) {
				dy = -Hero.VELOCITY;
				dx = 0;
				updateMoveHero("up");
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_DOWN:
			if (hero.getPosY() != hero.getFutureY()) {
				dy = Hero.VELOCITY;
				dx = 0;
				updateMoveHero("down");
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_LEFT:
			if (hero.getPosX() != hero.getFutureX()) {
				dx = -Hero.VELOCITY;
				dy = 0;
				updateMoveHero("left");
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_RIGHT:
			if (hero.getPosX() != hero.getFutureX()) {

				dx = Hero.VELOCITY;
				dy = 0;
				updateMoveHero("right");
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;

		default:
			break;
		}

	}

	public void updateMoveHero(String direction) throws InterruptedException {
		hero.moveHero(dx, dy, direction);
		hero.animate(direction);
	}

	public void iteratorComands() throws InterruptedException {
		int temp = 200;
		if ((comands != null) && comands.length != 0) {
			if (!hero.isInMove()) {
				while (index < comands.length) {
					if (comands[index].trim().equalsIgnoreCase(Util.METHOD_MOVE_FRONT)) {
						hero.calculateFutureXY();
						move = hero.getPosiction();
						hero.setInMove(true);
						index++;
						break; // PAREI AQUI
					} else if (comands[index].trim().equalsIgnoreCase(Util.METHOD_TURN_RIGHT)) {
						hero.changeAparencePosiction(Util.METHOD_TURN_RIGHT);
						sleep(temp);
					} else if (comands[index].trim().equalsIgnoreCase(Util.METHOD_TURN_LEFT)) {
						hero.changeAparencePosiction(Util.METHOD_TURN_LEFT);
						sleep(temp);
					} else {
						System.out.println("Entrou em nenhum");
					}
					if ((index + 1) >= comands.length) {
						comands = null;
						break;
					} else {
						index++;
					}
				}

			}
		}

	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public String[] getComands() {
		return comands;
	}

	public void setComands(String[] comands) {
		this.comands = comands;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
