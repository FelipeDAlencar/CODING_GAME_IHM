package br.com.ihm.coding_in_game.view;

import java.awt.Rectangle;
import java.util.ArrayList;

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
	private String basePathLayers;
	private String basePathTileSet;
	private boolean init;
	Thread thread;
	private Player player;

	public Phase(Player player, Hero hero) {
		this.player = player;
		this.hero = hero;
	}

	public void colisionObjectsLayer() {
		for (Rectangle intercetion : getLayerObjects().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
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
		}
	}

	public void colisionBomb() {
		for (Rectangle intercetion : getLayerBomb().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
				getHero().setFutureX(Hero.INITIAL_X);
				getHero().setFutureY(Hero.INITIAL_Y);
				getHero().setPosX(Hero.INITIAL_X);
				getHero().setPosY(Hero.INITIAL_Y);
				getHero().setAparence(1);
				getHero().setPosiction(Util.POSICTION_RIGHT);
				hero.getImgsLife().remove(hero.getImgsLife().size() - 1);

			}
		}
	}

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

}
