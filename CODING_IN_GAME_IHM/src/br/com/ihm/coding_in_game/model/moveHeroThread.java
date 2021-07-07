package br.com.ihm.coding_in_game.model;

import br.com.ihm.coding_in_game.view.Inventory;

public class moveHeroThread extends Thread {
	private Hero hero;
	private int dx = 0, dy = 0;
	private int move = 4;
	private String[] comands;
	private int index;
	private Inventory inventory;
	int tempInterval = 200;

	public moveHeroThread(Hero hero, Inventory inventory) {
		this.hero = hero;
		this.inventory = inventory;
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
				updateMoveHero(Util.POSICTION_UP);
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_DOWN:
			if (hero.getPosY() != hero.getFutureY()) {
				dy = Hero.VELOCITY;
				dx = 0;
				updateMoveHero(Util.POSICTION_DOWN);
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_LEFT:
			if (hero.getPosX() != hero.getFutureX()) {
				dx = -Hero.VELOCITY;
				dy = 0;
				updateMoveHero(Util.POSICTION_LEFT);
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;
		case Util.POSICTION_RIGHT:
			if (hero.getPosX() != hero.getFutureX()) {

				dx = Hero.VELOCITY;
				dy = 0;
				updateMoveHero(Util.POSICTION_RIGHT);
			} else {
				move = 4;
				hero.setInMove(false);
			}
			break;

		default:
			break;
		}

	}

	public void updateMoveHero(int posiction) throws InterruptedException {
		hero.moveHero(dx, dy, posiction);
		hero.animate(posiction);
	}

	public void iteratorComands() throws InterruptedException {

		if ((comands != null) && comands.length != 0) {
			if (!hero.isInMove()) {
				while (index < comands.length) {

					if (comands[index].trim().equalsIgnoreCase(Util.METHOD_MOVE_FRONT)) {
						verifyEndComands();
						hero.calculateFutureXY();
						move = hero.getPosiction();
						hero.setInMove(true);
						index++;
						break;
					} else if (comands[index].trim().equalsIgnoreCase(Util.METHOD_TURN_RIGHT)) {
						hero.changeAparencePosiction(Util.METHOD_TURN_RIGHT);
						sleep(tempInterval);
					} else if (comands[index].trim().equalsIgnoreCase(Util.METHOD_TURN_LEFT)) {
						hero.changeAparencePosiction(Util.METHOD_TURN_LEFT);
						sleep(tempInterval);
					} else {
						System.out.println("Entrou em nenhum");
					}
					if (verifyEndComands()) {
						break;
					} else {
						index++;
					}

				}

			}

		}

	}

	public void turnButtonsUnlock() {
		inventory.setLockInventary(false);
		inventory.getButtonDelete().setIcon(inventory.getImgButtonTrashNormal());
		inventory.getButtonExecute().setIcon(inventory.getImgButtonExecuteNormal());
		inventory.getButtonReset().setIcon(inventory.getImgButtonResetNormal());
		inventory.getButtonInfo().setIcon(inventory.getImgButtonInfoNormal());
		inventory.getButtonHome().setIcon(inventory.getImgButtonHomeNormal());
		inventory.getButtonHelp().setIcon(inventory.getImgButtonHelpNormal());
		inventory.getTextAreaConsole().setText("");
	}

	public boolean verifyEndComands() {
		if ((index + 1) >= comands.length) {
			turnButtonsUnlock();
			comands = null;
			return true;
		}
		return false;
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
