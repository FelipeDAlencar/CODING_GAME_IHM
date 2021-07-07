package br.com.ihm.coding_in_game.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import br.com.ihm.coding_in_game.DAO.DataBase;

public class Util {

	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";

	public static final String METHOD_TURN_RIGHT = "hero.girarDireita();";
	public static final String METHOD_TURN_LEFT = "hero.girarEsquerda();";
	public static final String METHOD_MOVE_FRONT = "hero.moverFrente();";

	public static final int POSICTION_UP = 0;
	public static final int POSICTION_DOWN = 1;
	public static final int POSICTION_RIGHT = 2;
	public static final int POSICTION_LEFT = 3;

	public static boolean SOUND = true;

	public static final Font FONT_TITLE = new Font("Arial Bold", Font.BOLD, 40);
	public static final Font FONT_CONTENT = new Font("Arial Bold", Font.BOLD, 20);
	public static final Font FONT_TITLE_BOARD = new Font("Arial Bold", Font.BOLD, 20);
	public static final Font FONT_CONTENT_INVENTORY = new Font("Arial Bold", Font.BOLD, 15);

	public static final Cursor CURSOR = new Cursor(Cursor.HAND_CURSOR);

	public static final Color COLOR_LABEL_HOVER = new Color(255, 255, 255);
	public static final Color COLOR_LABEL_OTHER = new Color(0, 0, 0);

	public static final Color COLOR_TRANSPARENT = new Color(0,0,0,0);
	
	public static ArrayList<Player> players = DataBase.allPlayers();

}
