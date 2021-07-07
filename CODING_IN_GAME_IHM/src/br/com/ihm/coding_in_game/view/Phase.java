package br.com.ihm.coding_in_game.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.controller.ControllerChoicePhases;
import br.com.ihm.coding_in_game.controller.ControllerInventory;
import br.com.ihm.coding_in_game.controller.ControllerPhase;
import br.com.ihm.coding_in_game.controller.ControllerSelectPlayer;
import br.com.ihm.coding_in_game.controller.ControllerStart;
import br.com.ihm.coding_in_game.model.Delimiter;
import br.com.ihm.coding_in_game.model.Flag;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.TileMap;
import br.com.ihm.coding_in_game.model.Util;

public abstract class Phase extends Game {
	private static final long serialVersionUID = 1L;
	private ArrayList<TileMap> layers;
	private ArrayList<Flag> flags;
	private ArrayList<Delimiter> delimiters;
	private TileMap layerRoadGrass, layerDoor, layerObjects, layerBomb;
	private Hero hero;
	private Player player;
	private String basePathLayers;
	private String basePathTileSet;
	private boolean init;
	private String title;
	Thread thread;
	private WindowDialog windowDialog;
	private WindowMain windowMain;
	private Inventory inventory;
	private int moves;
	private int codPhase;

	public void colisionObjectsLayer() {
		for (Rectangle intercetion : getLayerObjects().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
				stopHero();
			}
		}
	}

	public void stopHero() {
		switch (getHero().getPosiction()) {
		case Util.POSICTION_UP:
			getHero().setPosY(getHero().getPosY() + 5);
			getHero().setFutureY(getHero().getPosY());
			break;
		case Util.POSICTION_DOWN:
			getHero().setPosY(getHero().getPosY() - 5);
			getHero().setFutureY(getHero().getPosY());
			break;
		case Util.POSICTION_LEFT:
			getHero().setPosX(getHero().getPosX() + 5);
			getHero().setFutureX(getHero().getPosX());
			break;
		case Util.POSICTION_RIGHT:
			getHero().setPosX(getHero().getPosX() - 5);
			getHero().setFutureX(getHero().getPosX());
			break;
		default:
			break;
		}

	}

	public void RemainsFlags() {
		stopHero();
	}

	public void colisionBomb() {
		if (getLayerBomb() != null) {
			for (Rectangle intercetion : getLayerBomb().getBarriersInterceptions()) {
				if (getHero().getBounds().intersects(intercetion)) {
					resetPhase(false);
					DataBase.updatePlayer(getPlayer());
					showDialogFailure("SEU HERÓI FOI ATIGINDO PELAS BOMBAS.");

				}
			}
		}
	}

	public void backToHome() {

		inventory.getPlayer().setAmountMoves(0);
		DataBase.updatePlayer(inventory.getPlayer());
		Util.players = DataBase.allPlayers();

		windowMain.dispose();
		windowMain = null;

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		Hero.INITIAL_X = 35;
		Hero.INITIAL_Y = 365;
		WindowMain windowMain = new WindowMain(width, height);
		WindowDialog windowDialog = new WindowDialog(616, 500, windowMain);
		windowMain.getPhase().setWindowDialog(windowDialog);
		windowMain.getPhase().setInventory(windowMain.getInventory());
		windowMain.getPhase().setWindowMain(windowMain);

		new ControllerStart(windowMain, windowDialog);
		new ControllerPhase(windowDialog);
		new ControllerInventory(windowDialog);
		new ControllerChoicePhases(windowMain, windowDialog);
		new ControllerSelectPlayer(windowDialog.getSelectUser());

	}

	public void nextPhase() {

		if (getFlags().size() == 0) {
			passingAttributesAndConfigurationNextPhase();

		} else {
			RemainsFlags();
			showDialogRemainsFlags("VOCÊ NÃO PODE PASSAR DE FASE. AINDA HÁ BANDEIRAS A SEREM COLETADAS.");

		}

	}

	public abstract void colisionDoor();

	public abstract void passingAttributesAndConfigurationNextPhase();

	public void showDialogFailure(String content) {
		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(225, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 10, 500, 300);

		windowMain.setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>FALHOU</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent()
				.setText("<html><strong>" + content + "</strong></html>");
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);

	}

	public void showDialogCongratulations(String content) {

		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(198, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 10, 500, 300);

		windowMain.setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>PARABÉNS</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent()
				.setText("<html><strong>" + content + "</strong></html>");
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);

	}

	public void showDialogRemainsFlags(String content) {
		windowDialog.getGeneralContentDialog().getLabelTitle().setBounds(225, 15, 250, 50);
		windowDialog.getGeneralContentDialog().getLabelContent().setBounds(70, 10, 500, 300);

		windowMain.setEnabled(false);
		windowDialog.getGeneralContentDialog().getLabelTitle()
				.setText("<html><center><strong>ALERTA</strong></center></html>");
		windowDialog.getGeneralContentDialog().getLabelContent()
				.setText("<html><strong>" + content + "</strong></html>");
		windowDialog.getGeneralContentDialog().setVisible(true);
		windowDialog.setVisible(true);

	}

	public void resetPhase(boolean resetFlagsAndScore) {
		switch (getCodPhase()) {
		case 1:
			Hero.INITIAL_X = 35;
			Hero.INITIAL_Y = 365;

			hero.setAparence(1);
			hero.setPosiction(Util.POSICTION_RIGHT);
			hero.setFutureX(Hero.INITIAL_X);
			hero.setFutureY(Hero.INITIAL_Y);
			hero.setPosX(Hero.INITIAL_X);
			hero.setPosY(Hero.INITIAL_Y);

			break;
		case 2:
			Hero.INITIAL_X = 35;
			Hero.INITIAL_Y = 365;
			hero.setAparence(1);
			hero.setPosiction(Util.POSICTION_RIGHT);
			hero.setFutureX(Hero.INITIAL_X);
			hero.setFutureY(Hero.INITIAL_Y);
			hero.setPosX(Hero.INITIAL_X);
			hero.setPosY(Hero.INITIAL_Y);

			break;
		case 3:
			Hero.INITIAL_X = 35;
			Hero.INITIAL_Y = 365;
			hero.setAparence(1);
			hero.setPosiction(Util.POSICTION_RIGHT);
			hero.setFutureX(Hero.INITIAL_X);
			hero.setFutureY(Hero.INITIAL_Y);
			hero.setPosX(Hero.INITIAL_X);
			hero.setPosY(Hero.INITIAL_Y);

			break;
		case 4:
			Hero.INITIAL_X = 100;
			Hero.INITIAL_Y = 100;
			hero.setFutureX(Hero.INITIAL_X);
			hero.setFutureY(Hero.INITIAL_Y);
			hero.setPosX(Hero.INITIAL_X);
			hero.setPosY(Hero.INITIAL_Y);

			hero.setAparence(0);
			hero.setPosiction(Util.POSICTION_DOWN);
			break;

		default:
			break;
		}

		player.getImgsLife().remove(player.getImgsLife().size() - 1);
		player.setLifes(player.getLifes() - 1);
		hero.setAlreadyMoved(false);
		player.setAmountMoves(0);
		inventory.getTextAreaConsole().setText("");
		inventory.getButtonDelete().setIcon(windowMain.getInventory().getImgButtonTrashLocked());
		inventory.getButtonExecute().setIcon(windowMain.getInventory().getImgButtonExecuteLocked());
		inventory.getButtonReset().setIcon(windowMain.getInventory().getImgButtonResetLocked());
		if (resetFlagsAndScore) {
			initFlags();
			player.setScore(0);
		}

		if (player.getLifes() == 0) {

			showDialogFailure("QUE PENA VOCÊ ZEROU SUAS VIDAS :'). POR FAVOR, TENTE NOVAMENTE.");
			getPlayer().setLifes(5);
			DataBase.updatePlayer(getPlayer());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			windowDialog.setVisible(false);
			backToHome();

		}

	}

	public abstract void initFlags();

	public void colisionFlags() {
		for (int i = 0; i < getFlags().size(); i++) {
			Flag flag = (Flag) getFlags().get(i);
			if (flag.getBounds().intersects(getHero().getBounds())) {
				flag.setVisible(false);
				getPlayer().setScore(getPlayer().getScore() + 10);
				getFlags().remove(flag);

			}
		}
	}

	public ArrayList<TileMap> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<TileMap> layers) {
		this.layers = layers;
	}

	public TileMap getLayerRoadGrass() {
		return layerRoadGrass;
	}

	public void setLayerRoadGrass(TileMap layerRoadGrass) {
		this.layerRoadGrass = layerRoadGrass;
	}

	public TileMap getLayerDoor() {
		return layerDoor;
	}

	public void setLayerDoor(TileMap layerDoor) {
		this.layerDoor = layerDoor;
	}

	public TileMap getLayerObjects() {
		return layerObjects;
	}

	public void setLayerObjects(TileMap layerObjects) {
		this.layerObjects = layerObjects;
	}

	public TileMap getLayerBomb() {
		return layerBomb;
	}

	public void setLayerBomb(TileMap layerBomb) {
		this.layerBomb = layerBomb;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public String getBasePathLayers() {
		return basePathLayers;
	}

	public void setBasePathLayers(String basePathLayers) {
		this.basePathLayers = basePathLayers;
	}

	public String getBasePathTileSet() {
		return basePathTileSet;
	}

	public void setBasePathTileSet(String basePathTileSet) {
		this.basePathTileSet = basePathTileSet;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Delimiter> getDelimiters() {
		return delimiters;
	}

	public void setDelimiters(ArrayList<Delimiter> delimiters) {
		this.delimiters = delimiters;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public WindowMain getWindowMain() {
		return windowMain;
	}

	public void setWindowMain(WindowMain windowMain) {
		this.windowMain = windowMain;
	}

	public int getCodPhase() {
		return codPhase;
	}

	public void setCodPhase(int codPhase) {
		this.codPhase = codPhase;
	}

}
