package Rooms;

import Basics.Room;
import Server.RoomHandler;

public class Sanitarium extends Room {

	private String explained = "This seems to be the old village sanitarium, it seems to be in ruins";
	private String normal = "sanitarium";
	private String east = "You go east to the square.";
	
	public Room goEast() {
		return RoomHandler.getSquare();
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
}
