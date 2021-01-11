package Rooms;

import Basics.Room;
import Server.RoomHandler;

public class Square extends Room {

	private String explained = "This is the village square, to the east is the inn, "
			+ "to the west is the way to the sanitarium" + "to the north is the shop"
			+ " and to the south way in to the dungeon";
	private String normal = "square";
	private String east = "You go east to the inn.";
	private String west = "You go west into the sanitarium.";
	private String north = "You go north to the shop.";
	private String south = "You go south into the dungeon.";

	public Room goEast() {
		return RoomHandler.getInn();
	}

	public Room goWest() {
		return RoomHandler.getSanitarium();
	}

	public Room goNorth() {
		return RoomHandler.getShop();
	}

	public Room goDungeon() {
		return RoomHandler.getDungeon();
	}

	public String getExplained() {
		return explained;
	}

	public void setExplained(String explained) {
		this.explained = explained;
	}

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

}
