package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.model.Delimiter;
import br.com.ihm.coding_in_game.model.Flag;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.TileMap;

public class Phase_01 extends Phase {
	private static final long serialVersionUID = 1L;
	private Flag flag01, flag02, flag03, flag04;
	private Delimiter delimiter01, delimiter02, delimiter03, delimiter04, delimiter05, delimiter06;
	
	
	public Phase_01(Player player, Hero hero) {
		super(player, hero);
		setBounds(0, 0, 1046, WindowMain.HEIGHT);

		setLayers(new ArrayList<>());
		
		init();

		setVisible(false);

	}

	@Override
	public void init() {

		setLayers(new ArrayList<>());

		setBasePathLayers("assets/TILE/TILES_CSV/MAP_01/");
		setBasePathTileSet("assets/TILE/gfx/");
		setLayerBomb(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_BOMB.csv"));
		setLayerObjects(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_OBJECTS.csv"));
		setLayerDoor(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_DOOR.csv"));
		setLayerRoadGrass(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_01_ROAD_GRASS.csv"));

		getLayers().add(getLayerRoadGrass());
		getLayers().add(getLayerDoor());
		getLayers().add(getLayerObjects());
		getLayers().add(getLayerBomb());

		flag01 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight,
				getHero().getPosX() + (TileMap.newTileWidth * 10), 350);
		flag02 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag01.getPosX() + (TileMap.newTileWidth * 10),
				350);
		flag03 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag02.getPosX(),
				flag02.getPosY() - (TileMap.newTileHeight * 7));

		flag04 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag03.getPosX(),
				flag02.getPosY() + (TileMap.newTileHeight * 7));

		delimiter01 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight,
				getHero().getPosX() + (TileMap.newTileWidth * 10), 395);

		delimiter02 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight,
				delimiter01.getPosX() + (TileMap.newTileWidth * 10), 395);

		delimiter03 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, delimiter02.getPosX(),
				delimiter02.getPosY() - (TileMap.newTileHeight * 7));

		delimiter04 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, delimiter02.getPosX(),
				delimiter02.getPosY() + (TileMap.newTileHeight * 7));

		setFlags(new ArrayList<>());

		getFlags().add(flag01);
		getFlags().add(flag02);
		getFlags().add(flag03);
		getFlags().add(flag04);

		setDelimiters(new ArrayList<>());

		getDelimiters().add(delimiter01);
		getDelimiters().add(delimiter02);
		getDelimiters().add(delimiter03);
		getDelimiters().add(delimiter04);

		for (TileMap layer : getLayers()) {
			layer.mountMap();
		}
		setLoop(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (TileMap layer : getLayers()) {
			g.drawImage(layer.getMap(), 0, 0, 1046, WindowMain.HEIGHT, null);

		}

		for (Rectangle rectangle : getLayerRoadGrass().getBarriersInterceptions()) {
			g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		}

		for (Flag flag : getFlags()) {
			flag.draw(g);
		}

		for (Delimiter delimiters : getDelimiters()) {
			delimiters.draw(g);
		}

		getHero().draw(g);

	}

	@Override
	public void gameUpdate() {
		colisionObjectsLayer();
		colisionFlags();
		colisionBomb();
	}

	@Override
	public void gameRender() {
		repaint();

	}

}
