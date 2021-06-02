package br.com.ihm.coding_in_game.model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import br.com.ihm.coding_in_game.view.WindowMain;

public class TileMap {

	private final static int numberColumns = 35;
	private final static int numberRows = 21;
	private final static int columnsTileSet = 40;
	private final static int tileSize = 16;

	private int layer[][];
	private static int mapWidht = numberColumns * tileSize;
	private static int mapHeight = numberRows * tileSize;

	private int newTileWidth = (int) (Math.ceil((1046.0 / numberColumns)));
	private int newTileHeight = (int) (Math.ceil((double) WindowMain.HEIGHT / numberRows));

	private BufferedImage tileSet;
	private BufferedImage map = new BufferedImage(mapWidht, mapHeight, BufferedImage.TYPE_4BYTE_ABGR);

	private Graphics2D db = map.createGraphics();

	private ArrayList<Rectangle> barriersInterceptions;

	public TileMap(String nameTileset, String nameMap) {
		barriersInterceptions = new ArrayList<Rectangle>();

		try {
			tileSet = ImageIO.read(getClass().getClassLoader().getResourceAsStream(nameTileset));
		} catch (IOException e) {
			System.out.println("ERROR: TILE MAP NOT FOUND");
			e.printStackTrace();
		}
		layer = loadMatrix(nameMap);
	}

	public void mountMap() {
		map.createGraphics();

		int tile;
		int tileRow;
		int tileCol;

		for (int i = 0; i < numberRows; i++) {
			for (int j = 0; j < numberColumns; j++) {

				tile = (layer[i][j] != -1) ? (layer[i][j]) : 478; // se não tiver igual o arquivo gerado ao lido
																	// tirar o -1
				tileRow = (tile / columnsTileSet) | 0;
				tileCol = (tile % columnsTileSet) | 0;
				db.drawImage(tileSet, (j * tileSize), (i * tileSize), (j * tileSize) + tileSize,
						(i * tileSize) + tileSize, (tileCol * tileSize), (tileRow * tileSize),
						(tileCol * tileSize) + tileSize, (tileRow * tileSize) + tileSize, null);
				if (tile != 478)
					// barriersInterceptions.add(new Rectangle((j * tileSize), (i * tileSize),
					// tileSize, tileSize));
					addBarrieInterception(i, j, newTileWidth, newTileHeight);
			}

		}

	}

	public void addBarrieInterception(int i, int j, int newTileWidth, int newTileHeight) {
		Rectangle barrieInterception = new Rectangle();
		barrieInterception.x = j * newTileWidth;
		barrieInterception.y = i * newTileHeight;
		barrieInterception.width = newTileWidth;
		barrieInterception.height = newTileHeight;
		barriersInterceptions.add(barrieInterception);
	}

	public int[][] loadMatrix(String nomeMapa) {
		int[][] mat = new int[numberRows][numberColumns];

		InputStream input = getClass().getClassLoader().getResourceAsStream(nomeMapa);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		ArrayList<String> linhas = new ArrayList<>();

		String linha = "";

		try {
			while ((linha = br.readLine()) != null)

				linhas.add(linha);

			int coluna = 0;
			for (int i = 0; i < linhas.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhas.get(i), ",");

				while (token.hasMoreElements()) {
					mat[i][coluna] = Integer.parseInt(token.nextToken());
					coluna++;
				}
				coluna = 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Não carregou a Matriz!!");
			e.printStackTrace();
		}

		return mat;
	}

	public int[][] getLayer() {
		return layer;
	}

	public void setLayer(int[][] layer) {
		this.layer = layer;
	}

	public static int getMapWidht() {
		return mapWidht;
	}

	public static void setMapWidht(int mapWidht) {
		TileMap.mapWidht = mapWidht;
	}

	public static int getMapHeight() {
		return mapHeight;
	}

	public static void setMapHeight(int mapHeight) {
		TileMap.mapHeight = mapHeight;
	}

	public BufferedImage getTileSet() {
		return tileSet;
	}

	public void setTileSet(BufferedImage tileSet) {
		this.tileSet = tileSet;
	}

	public BufferedImage getMap() {
		return map;
	}

	public void setMap(BufferedImage map) {
		this.map = map;
	}

	public Graphics2D getDb() {
		return db;
	}

	public void setDb(Graphics2D db) {
		this.db = db;
	}

	public static int getNumbercolumns() {
		return numberColumns;
	}

	public static int getNumberrows() {
		return numberRows;
	}

	public static int getColumnstileset() {
		return columnsTileSet;
	}

	public static int getTilesize() {
		return tileSize;
	}

	public ArrayList<Rectangle> getBarriersInterceptions() {
		return barriersInterceptions;
	}

	public void setBarriersInterceptions(ArrayList<Rectangle> barriersInterceptions) {
		this.barriersInterceptions = barriersInterceptions;
	}

}
