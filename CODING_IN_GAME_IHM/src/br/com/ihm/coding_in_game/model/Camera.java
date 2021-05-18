package br.com.ihm.coding_in_game.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.view.Phase;

public class Camera {
	
	public ArrayList<TileMap> layers;

	private static int x = 0;
	private static int y = 0;
	
	private static final int widthPanel = 1200;
	private static final int heightPanel = 520;
	private BufferedImage panel;
	private Graphics2D g;
	private Phase phase;
	
	public Camera(Phase phase, ArrayList<TileMap> tileMaps) {
		this.phase = phase;
		this.layers = tileMaps;
		init();
		
	}
	
	private void init() {
		panel = new BufferedImage(TileMap.getMapWidht(), TileMap.getMapHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		g = (Graphics2D) panel.getGraphics();

	}

	
	public void render() {
		for (TileMap layer : layers) {
			g.drawImage(layer.getMap(), 0, 0, null);
		}
	}

}


