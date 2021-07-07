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
import br.com.ihm.coding_in_game.model.Util;

public class Phase_04 extends Phase {
	private static final long serialVersionUID = 1L;
	private Flag flag01, flag02, flag03, flag04, flag05, flag06, flag07, flag08, flag09, flag10, flag11;
	private Delimiter delimiter01, delimiter02, delimiter03, delimiter04, delimiter05, delimiter06, delimiter07,
			delimiter08, delimiter09, delimiter10, delimiter11;

	public Phase_04() {

		setBounds(0, 0, 1046, WindowMain.HEIGHT);
		init();
		setVisible(false);

	}

	@Override
	public void init() {

		setTitle("FASE 04");
		setCodPhase(4);

		Hero.INITIAL_X = 100;
		Hero.INITIAL_Y = 100;

		try {
			setHero(new Hero(0, 64, 126, 4, 4, Hero.INITIAL_X, Hero.INITIAL_Y, "/assets/sprite.png"));
			getHero().setPosiction(Util.POSICTION_DOWN);
		} catch (IOException e) {
			System.out.println("IMAGE HERO NOTFOUND");
			e.printStackTrace();
		}

		setMoves(19);

		setPlayer(new Player("", 0, 0, 4, 5));

		setLayers(new ArrayList<>());

		setBasePathLayers("assets/TILE/TILES_CSV/MAP_04/");
		setBasePathTileSet("assets/TILE/gfx/");

		// setLayerBomb(new TileMap(getBasePathTileSet() + "Overworld.png",
		// getBasePathLayers() + "MAP_04_BOMB.csv"));

		setLayerObjects(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_04_OBJECTS.csv"));

		setLayerDoor(new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_04_DOOR.csv"));

		setLayerRoadGrass(
				new TileMap(getBasePathTileSet() + "Overworld.png", getBasePathLayers() + "MAP_04_ROAD_GRASS.csv"));

		getLayers().add(getLayerRoadGrass());
		getLayers().add(getLayerDoor());
		getLayers().add(getLayerObjects());
		// getLayers().add(getLayerBomb());

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

		flag06 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, getHero().getPosX(), flag01.getPosY());

		flag07 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, getHero().getPosX(), flag04.getPosY());

		flag08 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag05.getPosX(), flag04.getPosY());

		flag09 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag08.getPosX() + (TileMap.newTileWidth * 10),
				flag08.getPosY());

		flag10 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag09.getPosX(), flag05.getPosY());

		flag11 = new Flag(TileMap.newTileWidth, TileMap.newTileHeight, flag09.getPosX(), flag03.getPosY());

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

		delimiter06 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag06.getPosX() + 3,
				flag06.getPosY() + 45);

		delimiter07 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag07.getPosX() + 3,
				flag07.getPosY() + 45);

		delimiter08 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag08.getPosX() + 3,
				flag08.getPosY() + 45);
		delimiter09 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag09.getPosX() + 3,
				flag09.getPosY() + 45);
		delimiter10 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag10.getPosX() + 3,
				flag10.getPosY() + 45);
		delimiter11 = new Delimiter(TileMap.newTileWidth, TileMap.newTileHeight, flag11.getPosX() + 3,
				flag11.getPosY() + 45);

		setFlags(new ArrayList<>());

		getFlags().add(flag01);
		getFlags().add(flag02);
		getFlags().add(flag03);
		getFlags().add(flag04);
		getFlags().add(flag05);
		getFlags().add(flag06);
		getFlags().add(flag07);
		getFlags().add(flag08);
		getFlags().add(flag09);
		getFlags().add(flag10);
		getFlags().add(flag11);

		setDelimiters(new ArrayList<>());

		getDelimiters().add(delimiter01);
		getDelimiters().add(delimiter02);
		getDelimiters().add(delimiter03);
		getDelimiters().add(delimiter04);
		getDelimiters().add(delimiter05);
		getDelimiters().add(delimiter06);
		getDelimiters().add(delimiter07);
		getDelimiters().add(delimiter08);
		getDelimiters().add(delimiter09);
		getDelimiters().add(delimiter10);
		getDelimiters().add(delimiter11);
	}

	@Override
	public void colisionDoor() {
		for (Rectangle intercetion : getLayerDoor().getBarriersInterceptions()) {
			if (getHero().getBounds().intersects(intercetion)) {
				nextPhase();
			}
		}

	}

	@Override
	public void nextPhase() {
		if (getFlags().size() == 0) {
			stopHero();
			showDialogCongratulations("PARABÉNS, " + getPlayer().getName()
					+ " VOCÊ CONSEGUIU CHEGAR ATÉ O FINAL. SEU SCORE FOI DE: " + getPlayer().getScore());
		} else {
			RemainsFlags();
		}
	}

	public void passingAttributesAndConfigurationNextPhase() {

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

	public Flag getFlag06() {
		return flag06;
	}

	public void setFlag06(Flag flag06) {
		this.flag06 = flag06;
	}

	public Flag getFlag07() {
		return flag07;
	}

	public void setFlag07(Flag flag07) {
		this.flag07 = flag07;
	}

	public Flag getFlag08() {
		return flag08;
	}

	public void setFlag08(Flag flag08) {
		this.flag08 = flag08;
	}

	public Flag getFlag09() {
		return flag09;
	}

	public void setFlag09(Flag flag09) {
		this.flag09 = flag09;
	}

	public Flag getFlag10() {
		return flag10;
	}

	public void setFlag10(Flag flag10) {
		this.flag10 = flag10;
	}

	public Flag getFlag11() {
		return flag11;
	}

	public void setFlag11(Flag flag11) {
		this.flag11 = flag11;
	}

	public Delimiter getDelimiter06() {
		return delimiter06;
	}

	public void setDelimiter06(Delimiter delimiter06) {
		this.delimiter06 = delimiter06;
	}

	public Delimiter getDelimiter07() {
		return delimiter07;
	}

	public void setDelimiter07(Delimiter delimiter07) {
		this.delimiter07 = delimiter07;
	}

	public Delimiter getDelimiter08() {
		return delimiter08;
	}

	public void setDelimiter08(Delimiter delimiter08) {
		this.delimiter08 = delimiter08;
	}

	public Delimiter getDelimiter09() {
		return delimiter09;
	}

	public void setDelimiter09(Delimiter delimiter09) {
		this.delimiter09 = delimiter09;
	}

	public Delimiter getDelimiter10() {
		return delimiter10;
	}

	public void setDelimiter10(Delimiter delimiter10) {
		this.delimiter10 = delimiter10;
	}

	public Delimiter getDelimiter11() {
		return delimiter11;
	}

	public void setDelimiter11(Delimiter delimiter11) {
		this.delimiter11 = delimiter11;
	}

}
