package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.model.Camera;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.TileMap;

public class Phase extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<TileMap> layers;
	private TileMap layerRoadGrass, layerDoor, layerObjects, layerBomb, layerFlags;
	private Hero hero;
	private String basePathLayers = "assets/TILE/TILES_CSV/MAP_01/";
	private String basePathTileSet = "assets/TILE/gfx/";
	private boolean isInit;

	public Phase() {

		setBounds(0, 0, 1046, Window.HEIGHT);

		isInit = true;
		setVisible(false);

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

		try {
			hero = new Hero(1, 272, 256, 18, 8, 30, 370, "/" + basePathTileSet + "character.png");
		} catch (IOException e) {
			System.out.println("ERRO HERO NOT FOUND.");
			e.printStackTrace();
		}
		

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (isInit) {
			init();
			for (TileMap layer : layers) {
				layer.mountMap();
				g.drawImage(layer.getMap(), 0, 0, 1046, Window.HEIGHT, null);
			}
			g.drawImage(hero.getSprites()[hero.getAparencia()], hero.getPosX(), hero.getPosY(), null);
			isInit = false;
		}

	}

}
