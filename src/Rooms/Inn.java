package Rooms;

import java.util.HashMap;

import Basics.*;
import Objects.*;
import Server.ClientHandler;

public class Inn extends Room {
	private String explained = "It looks like the local tavern, they serve beer and have warm beds.";
	private String normal = "Inn";
	private String west = "You go west to the square.";

	public Barkeeper barkeeper = new Barkeeper();
	public Beer beer = new Beer();
	private HashMap<String, Item> roomItems = new HashMap<>();

	public void roomItems() {
		roomItems.put("barkeeper", barkeeper);
		roomItems.put("beer", beer);
	}

	public String getNPC() {
		return barkeeper.getNormal();
	}

	public String getItem() {
		return beer.getNormal();
	}

	public String explainedItems(String i) {
		if (i.equals("barkeeper")) {
			return roomItems.get(i).getExplained();
		} else if (i.equals("beer")) {
			return roomItems.get(i).getExplained();
		} else
			return "What exactly do you want to look at?";
	}

	public String stealSyntax() {
		return "take beer";
	}

	public void deletebEER(ClientHandler handler) {
		handler.clientObj.remove(beer.getNormal());

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

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}
}
