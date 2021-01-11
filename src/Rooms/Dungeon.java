package Rooms;

import Basics.Room;

public class Dungeon extends Room {
	private String explained = "It seems to be the dungeon is not implemented yet.";
	private String normal = "dungeon";
	private String north = "You go north to the square.";

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

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

}
