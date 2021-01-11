package Rooms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Basics.Item;
import Basics.Room;
import Objects.Dwarf;
import Objects.Potion;
import Server.ClientHandler;
import Server.RoomHandler;

public class Shop extends Room {

	private String explained = "It seems to be the only shop open in the whole village, it seems to be run by a dwarf.";
	private String normal = "shop";
	private String south = "You go south to the square.";
	private Dwarf dwarf = new Dwarf();
	private Potion potion = new Potion();
	private HashMap<String, Item> roomItems = new HashMap<>();

	public void roomItems() {
		roomItems.put("dwarf", dwarf);
		roomItems.put("red potion", potion);
	}

	public String getNPC() {
		return dwarf.getNormal();
	}

	public String getItem() {
		return potion.getNormal();
	}

	public String explainedItems(String i) {
		if (i.equals("dwarf")) {
			return roomItems.get(i).getExplained();
		} else if (i.equals("potion")) {
			return roomItems.get(i).getExplained();
		} else
			return "What exactly do you want to look at?";
	}

	public String stealSyntax() {
		return "take potion";
	}

	public void steal(ClientHandler handler) {
        Random ran = new Random();
        ArrayList<String> pickPotion= new ArrayList<>();
        pickPotion.add("You try to pick a potion from the pack and you get one - but the dwarf gets on your fingers violently in the process. OW!");
        pickPotion.add("You snatch a potion from under the dwarf's feet.");
        String stealText = pickPotion.get(ran.nextInt(pickPotion.size()));
        handler.out.println(stealText);
    }

	public String syntax() {
		return "try: steal potion";
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public Room goWest() {
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

}
