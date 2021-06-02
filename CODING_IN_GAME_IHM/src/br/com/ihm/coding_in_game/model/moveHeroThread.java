package br.com.ihm.coding_in_game.model;

public class moveHeroThread extends Thread {
	private Hero hero;
	private int dx = 0, dy = 0;
	private String move = "";

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
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void moveHero(String direction) {
		switch (direction) {
		case "up":
			dy = -Hero.VELOCITY;
			dx = 0;
			updateMoveHero(direction);
			break;
		case "down":
			dy = Hero.VELOCITY;
			dx = 0;
			updateMoveHero(direction);
			break;
		case "left":
			dx = -Hero.VELOCITY;
			dy = 0;
			updateMoveHero(direction);
			break;
		case "right":
			dx = Hero.VELOCITY;
			dy = 0;
			updateMoveHero(direction);
			break;

		default:
			break;
		}

	}

	public void updateMoveHero(String direction) {
		hero.moveHero(dx, dy, direction);
		hero.animate(direction);
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

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}
	
	
	

}
