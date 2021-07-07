package br.com.ihm.coding_in_game.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import br.com.ihm.coding_in_game.model.Player;

public class DataBase {

	private static ArrayList<Player> players = new ArrayList<Player>();
	private static XStream xml = new XStream(new DomDriver());
	private final static String URL_PATH = "src/database_archive/base.xml";

	public static void savePlayer(Player player) {
		try {
			File file = new File(URL_PATH);

			players = allPlayers();
			if (!(players != null)) {
				players = new ArrayList<>();
			}

			players.add(player);

			xml.processAnnotations(Player.class);
			String xmlPersist = xml.toXML(players);

			PrintWriter writer;

			writer = new PrintWriter(file);

			writer.print(xmlPersist);
			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Player> allPlayers() {

		try {
			File file = new File(URL_PATH);

			XStream xml = new XStream(new Dom4JDriver());
			xml.alias("Player", ArrayList.class);
			
			
			players = (ArrayList<Player>) xml.fromXML(file);

			return players;
		} catch (StreamException e) {
			// e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public static Player searchPlayer(String username) {
		try {
			File file = new File(URL_PATH);

			XStream xml = new XStream(new Dom4JDriver());
			xml.alias("Player", ArrayList.class);

			players = (ArrayList<Player>) xml.fromXML(file);

			for (Player player : players) {
				if (player.getName().equals(username)) {
					return player;
				}
			}

			return null;
		} catch (StreamException e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unused")
	public static void updatePlayer(Player player) {

		try {
			File file = new File(URL_PATH);

			players = allPlayers();


			if (!(players != null)) {
				players = new ArrayList<>();
			}

			for (Player player2 : DataBase.players) {
				if (player.getName().equals(player2.getName())) {
					players.remove(player2);
					players.add(player);
					break;
				}
			}
			
			xml.processAnnotations(Player.class);
			String xmlPersist = xml.toXML(players);

			PrintWriter writer;

			writer = new PrintWriter(file);

			writer.print(xmlPersist);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void createArchiveIfNotExists() {
		String path = "src/database_archive/";
		if (!new File(path).exists()) {
			new File(path).mkdirs();

		} else {
			System.out.println("Pasta caminho já existe ...");
		}

	}

}
