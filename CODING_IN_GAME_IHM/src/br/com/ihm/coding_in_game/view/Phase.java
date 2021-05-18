package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import br.com.ihm.coding_in_game.model.Camera;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.TileMap;

public class Phase extends Panel {
	private ArrayList<TileMap> layers;
	private TileMap layerRoadGrass, layerDoor, layerObjects, layerBomb, layerFlags;
	private Camera camera;
	private Hero hero;
	private String basePathLayers = "assets/TILE/TILES_CSV/MAP_01/";
	private String basePathTileSet = "assets/TILE/gfx/";
	private boolean isInit;

	public Phase() {

		setBounds(0, 0, 1068, 678);
		setBackground(Color.red);

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

		try {
			hero = new Hero(1, 272, 256, 18, 8, 30, 320, "/" + basePathTileSet + "character.png");
		} catch (IOException e) {
			System.out.println("ERRO HERO NOT FOUND.");
			e.printStackTrace();
		}
		// layers.add(layerObjects);
		// layers.add(layerBomb);
		// layers.add(layerFlags);

		// camera = new Camera(tileMaps);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (!isInit) {
			init();
			isInit = true;

		}
		// System.out.println(layers.get(0).getMap());
		// for (TileMap layer : layers) {
		// layer.mountMap();
		// g.drawImage(layer.getMap(), 0, 0, 1066, 678, null);
		// }

		// for (TileMap layer : layers) {
		layers.get(0).mountMap();
		g.drawImage(layers.get(0).getMap(), 0, 0, 1066, 678, null);
		// }
		g.drawImage(hero.getSprites()[hero.getAparencia()], hero.getPosX(), hero.getPosY(), null);

	}

}
