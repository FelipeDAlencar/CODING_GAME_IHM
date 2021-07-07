package br.com.ihm.coding_in_game.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.DAO.DataBase;
import br.com.ihm.coding_in_game.model.Delimiter;
import br.com.ihm.coding_in_game.model.Flag;
import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.TileMap;
import br.com.ihm.coding_in_game.model.Util;

public class Phase_02 extends Phase {
	private static final long serialVersionUID = 1L;
	private Flag flag01, flag02, flag03, flag04, flag05;
	private Delimiter delimiter01, delimiter02, delimiter03, delimiter04, delimiter05;
	private TileMap layerRegies;
	private Phase_03 phase_03;

	public Phase_02() {

		setBounds(0, 0, 1046, WindowMain.HEIGHT);
		init();
		setVisible(false);

	}

	@Override
	public void init() {

		setTitle("FASE 02");
		setCodPhase(2);

		try {
			setHero(new Hero(1, 64, 126, 4, 4, Hero.INITIAL_X, Hero.INITIAL_Y, "/assets/sprite.png"));
		} catch (IOException e) {
			System.out.println("IMAGE HERO NOTFOUND");
			e.printStackTrace();
		}

		setMoves(14);

		setPlayer(new Player("", 0, 0, 2,5));

		setLayers(new ArrayList<>());

		setBasePathLayers("assets/TILE/TILES_CSV/MAP_02/");
		setBasePathTileSet("assets/TILE/gfx/");

		setLayerBomb(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_02_BOMB.csv"));

		setLayerObjects(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_02_OBJECTS.csv"));

		setLayerDoor(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_02_DOOR.csv"));

		setLayerRoadGrass(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_02_ROAD_GRASS.csv"));

		layerRegies = new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_02_REGIES.csv");

		getLayers().add(getLayerRoadGrass());
		getLayers().add(getLayerDoor());
		getLayers().add(getLayerObjects());
		getLayers().add(getLayerBomb());
		getLayers().add(layerRegies);

		initFlags();

		for (TileMap layer : getLayers()) {
			layer.mountMap();
		}
		setLoop(true);
	}

	@Override
	public void initFlags() {

		flag01 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight,
				getHero().getPosX() + (TileMap.newTileWidth * 10), 350);

		flag02 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag01.getPosX(),
				flag01.getPosY() - (TileMap.newTileHeight * 7));

		flag03 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag02.getPosX() + (TileMap.newTileWidth * 10),
				flag02.getPosY());

		flag04 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag01.getPosX(),
				flag01.getPosY() + (TileMap.newTileHeight * 7));

		flag05 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag01.getPosX() + (TileMap.newTileWidth * 10),
				flag01.getPosY());

		delimiter01 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag01.getPosX() + 3,
				flag01.getPosY() + 45);

		delimiter02 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag02.getPosX() + 3,
				flag02.getPosY() + 45);

		delimiter03 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag03.getPosX() + 3,
				flag03.getPosY() + 45);

		delimiter04 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag04.getPosX() + 3,
				flag04.getPosY() + 45);

		delimiter05 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag05.getPosX() + 3,
				flag05.getPosY() + 45);

		setFlags(new ArrayList<>());

		getFlags().add(flag01);
		getFlags().add(flag02);
		getFlags().add(flag03);
		getFlags().add(flag04);
		getFlags().add(flag05);

		setDelimiters(new ArrayList<>());

		getDelimiters().add(delimiter01);
		getDelimiters().add(delimiter02);
		getDelimiters().add(delimiter03);
		getDelimiters().add(delimiter04);
		getDelimiters().add(delimiter05);
	}

	@Override
	public void colisionDoor() {
		for (Rectangle intercetion : getLayerDoor().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
				nextPhase();
			}
		}

	}

	public void passingAttributesAndConfigurationNextPhase() {
		WindowMain window = getWindowMain();
		Hero.INITIAL_X = 35;
		Hero.INITIAL_Y = 365;
		
		getHero().setFutureX(Hero.INITIAL_X);
		getHero().setFutureY(Hero.INITIAL_Y);
		getHero().setPosX(Hero.INITIAL_X);
		getHero().setPosY(Hero.INITIAL_Y);
		getHero().setPosiction(Util.POSICTION_RIGHT);
		getHero().setAparence(1);
		getHero().setAlreadyMoved(false);
		getPlayer().setAmountMoves(0);
		getPlayer().setCurrentPhase(3);

		

		phase_03 = (Phase_03) window.getPhase3();
		
		phase_03.setHero(getHero());
		phase_03.setPlayer(getPlayer());
		getInventory().setPhase(phase_03);
		phase_03.setInventory(getInventory());
		phase_03.setWindowMain(getWindowMain());
		phase_03.setWindowDialog(getWindowDialog());
		getInventory().getTextAreaConsole().setText("");
		getInventory().getLabelTitlePhase().setText(window.getPhase3().getTitle() + " / 04");
		

		window.getPhase2().setLoop(false);
		window.getPhase2().setVisible(false);
		window.getPhase3().setVisible(true);
		window.setPhase(phase_03);
	
		DataBase.updatePlayer(getInventory().getPlayer());

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
		colisionDoor();
	}

	@Override
	public void gameRender() {
		repaint();

	}

	public Flag getFlag01() {
		return flag01;
	}

	public void setFlag01(Flag flag01) {
		this.flag01 = flag01;
	}

	public Flag getFlag02() {
		return flag02;
	}

	public void setFlag02(Flag flag02) {
		this.flag02 = flag02;
	}

	public Flag getFlag03() {
		return flag03;
	}

	public void setFlag03(Flag flag03) {
		this.flag03 = flag03;
	}

	public Flag getFlag04() {
		return flag04;
	}

	public void setFlag04(Flag flag04) {
		this.flag04 = flag04;
	}

	public Flag getFlag05() {
		return flag05;
	}

	public void setFlag05(Flag flag05) {
		this.flag05 = flag05;
	}

	public Delimiter getDelimiter01() {
		return delimiter01;
	}

	public void setDelimiter01(Delimiter delimiter01) {
		this.delimiter01 = delimiter01;
	}

	public Delimiter getDelimiter02() {
		return delimiter02;
	}

	public void setDelimiter02(Delimiter delimiter02) {
		this.delimiter02 = delimiter02;
	}

	public Delimiter getDelimiter03() {
		return delimiter03;
	}

	public void setDelimiter03(Delimiter delimiter03) {
		this.delimiter03 = delimiter03;
	}

	public Delimiter getDelimiter04() {
		return delimiter04;
	}

	public void setDelimiter04(Delimiter delimiter04) {
		this.delimiter04 = delimiter04;
	}

	public Delimiter getDelimiter05() {
		return delimiter05;
	}

	public void setDelimiter05(Delimiter delimiter05) {
		this.delimiter05 = delimiter05;
	}

	public TileMap getLayerRegies() {
		return layerRegies;
	}

	public void setLayerRegies(TileMap layerRegies) {
		this.layerRegies = layerRegies;
	}

	public Phase_03 getPhase_03() {
		return phase_03;
	}

	public void setPhase_03(Phase_03 phase_03) {
		this.phase_03 = phase_03;
	}
	

}
