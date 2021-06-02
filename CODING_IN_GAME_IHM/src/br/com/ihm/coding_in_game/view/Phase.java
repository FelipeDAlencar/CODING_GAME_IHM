package br.com.ihm.coding_in_game.view;

import java.util.ArrayList;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.TileMap;

public abstract class Phase extends Game {
	private static final long serialVersionUID = 1L;
	private ArrayList<TileMap> layers;
	private TileMap layerRoadGrass, layerDoor, layerObjects, layerBomb, layerFlags;
	private Hero hero;
	private String basePathLayers;
	private String basePathTileSet;
	private boolean init;
	Thread thread;

	




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

	public TileMap getLayerFlags() {
		return layerFlags;
	}

	public void setLayerFlags(TileMap layerFlags) {
		this.layerFlags = layerFlags;
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

}
