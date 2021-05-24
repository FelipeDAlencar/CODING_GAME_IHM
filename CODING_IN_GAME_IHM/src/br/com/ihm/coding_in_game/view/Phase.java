package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.TileMap;

public class Phase extends Panel implements Runnable {
	private static final long serialVersionUID = 1L;
	private ArrayList<TileMap> layers;
	private TileMap layerRoadGrass, layerDoor, layerObjects, layerBomb, layerFlags;
	private Hero hero;
	private String basePathLayers = "assets/TILE/TILES_CSV/MAP_01/";
	private String basePathTileSet = "assets/TILE/gfx/";
	private boolean isInit, loop = true;
	Thread thread;
	
	public Phase() {

		setBounds(0, 0, 1046, WindowMain.HEIGHT);
		

		try {
			hero = new Hero(1, 64, 126, 4, 4, 30, 370, "/assets/sprite.png");
		} catch (IOException e) {
			System.out.println("ERRO HERO NOT FOUND.");
			e.printStackTrace();
		}
		
		
		
		isInit = true;
		setVisible(false);

	}
	
	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}

	}

	private void init() {

		layers = new ArrayList<>();

		layerFlags = new TileMap(basePathTileSet + "Overworld.png", basePathLayers + "MAP_01_BANDEIRAS.csv");
		layerBomb = new TileMap(basePathTileSet + "Overworld.png", basePathLayers + "MAP_01_BOMBA.csv");
		layerObjects = new TileMap(basePathTileSet + "Overworld.png", basePathLayers + "MAP_01_OBJETOS.csv");
		layerDoor = new TileMap(basePathTileSet + "Overworld.png", basePathLayers + "MAP_01_PORTA.csv");
		layerRoadGrass = new TileMap(basePathTileSet + "Overworld.png", basePathLayers + "MAP_01_GRAMA_ESTRADA.csv");

		layers.add(layerRoadGrass);
		layers.add(layerDoor);
		layers.add(layerObjects);
		layers.add(layerBomb);
		layers.add(layerFlags);


	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (isInit) {
			init();
		}
		
		for (TileMap layer : layers) {
			layer.mountMap();
			g.drawImage(layer.getMap(), 0, 0, 1046, WindowMain.HEIGHT, null);
		}
		g.drawImage(hero.getSprites()[hero.getAparence()], hero.getPosX(), hero.getPosY(), null);
		
		
		//hero.draw(g);
		isInit = false;

	}
	
	@Override
	public void run() {
		while (true) {
			try {
				if (loop) {
					gameUpdate();
					gameRender();
					gameDraw();
				}
				Thread.sleep(5);

			} catch (InterruptedException e) {
				e.printStackTrace();

			}

		}
		
		
	}
	

	public void gameDraw() {
		
	}

	public void gameRender() {
		repaint();
		
	}

	public void gameUpdate() {
		
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

	
	

}
