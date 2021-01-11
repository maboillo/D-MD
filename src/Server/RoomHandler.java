package Server;

import Rooms.*;

public class RoomHandler {
	private static Square square = new Square();
	private static Inn inn = new Inn();
	private static Sanitarium sanitarium = new Sanitarium();
	private static Shop shop = new Shop();
	private static Dungeon dungeon = new Dungeon();

	public static Square getSquare() {
		return square;
	}

	public static Inn getInn() {
		return inn;
	}

	public static Sanitarium getSanitarium() {
		return sanitarium;
	}

	public static Shop getShop() {
		return shop;
	}

	public static Dungeon getDungeon() {
		return dungeon;
	}

}
