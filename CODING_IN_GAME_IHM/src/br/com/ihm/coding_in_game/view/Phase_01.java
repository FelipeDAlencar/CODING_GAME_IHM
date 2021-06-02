package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.TileMap;

public class Phase_01 extends Phase {
	private static final long serialVersionUID = 1L;

	public Phase_01() {

		setBounds(0, 0, 1046, WindowMain.HEIGHT);

		setLayers(new ArrayList<>());
		try {
			setHero(new Hero(1, 64, 126, 4, 4, 30, 370, "/assets/sprite.png"));
		} catch (IOException e) {
			System.out.println("ERRO HERO NOT FOUND.");
			e.printStackTrace();
		}

		init();

		setVisible(false);

	}

	@Override
	public void init() {

		setLayers(new ArrayList<>());

		setBasePathLayers("assets/TILE/TILES_CSV/MAP_01/");
		setBasePathTileSet("assets/TILE/gfx/");

		setLayerFlags(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_BANDEIRAS.csv"));
		setLayerBomb(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_BOMBA.csv"));
		setLayerObjects(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_OBJETOS.csv"));
		setLayerDoor(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_PORTA.csv"));
		setLayerRoadGrass(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_GRAMA_ESTRADA.csv"));

		getLayers().add(getLayerRoadGrass());
		getLayers().add(getLayerDoor());
		getLayers().add(getLayerObjects());
		getLayers().add(getLayerBomb());
		getLayers().add(getLayerFlags());

		for (TileMap layer : getLayers()) {
			layer.mountMap();
		}
		setLoop(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (TileMap layer : getLayers()) {
			// layer.mountMap();
			g.drawImage(layer.getMap(), 0, 0, 1046, WindowMain.HEIGHT, null);
		}
		
		getHero().draw(g);

	}

	public void ColisionObjectsLayer() {
		for (Rectangle intercetion : getLayerObjects().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
				System.out.println("INTERCECTION");
				//getHero().setIntersectsObjects(true);
			}
		}
	}

	@Override
	public void gameUpdate() {
		ColisionObjectsLayer();
	}

	@Override
	public void gameRender() {
		repaint();

	}

}
