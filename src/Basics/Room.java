package Basics;

import java.util.ArrayList;

import Server.ClientHandler;

// Default room

public class Room {

	private String explained = "You're standing in the middle of nowhere - something must have gone wrong!";
    private String normal = "Limbo";
    private String west = "What should be there please? You're standing in limbo";
    private String east = "What should be there please? You're standing in limbo";
    private String north = "What should be there please? You're standing in limbo";
    private String south = "What should be there please? You're standing in limbo";
    public ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    
    public void register(ClientHandler clientHandler) {
        clients.add(clientHandler);
        clientsInRoom();
    }

    public String clientsInRoom() {
        if (clients.size() == 1) {
            return "Only you are in this room";
        } else {
            String clientList = "";
            ClientHandler first = clients.get(0);
            clientList = "You are in this room: " + first.name.substring(20);
            for (int i = 1; i < clients.size(); i++) {
                clientList = clientList + ", " + clients.get(i).name.substring(20);
            }
            return clientList;
        }
    }
    
    public ArrayList<String> syntax = new ArrayList<>();
    public String stealSyntax(){
        return "";
    }
    public String getNPC() {
        return "";
    }
    public String getObj(){ return ""; }

    public void talk(String text, ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            client.out.println(clientHandler.name.substring(20) + " say: " + text);
        }
    }

    public String syntax(){
        return "There are no special interactions here.";
    }

    public void enterRoom(ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            if (!client.equals(clientHandler)) {
                client.out.println(clientHandler.name.substring(20) + " is approaching.");
            }
        }
    }

    public void leaveRoom(ClientHandler clientHandler) {
        for (ClientHandler client : clients) {
            if (!client.equals(clientHandler)) {
                client.out.println(clientHandler.name.substring(20) + " is moving away.");
            }
        }
    }
    
    public void unregister(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }
    
    public String explainedItems(String i) {
        return "This did not work.";
    }

    public String normalItems(String i) {
        return "This didn't work.";
    }
    
    public void roomItems() {}
    public void deleteCup(ClientHandler handler){}
    public void action(ClientHandler handler) throws InterruptedException {}
    public void mystery(ClientHandler handler) throws InterruptedException {}
    
    public Room goWest() {
        return null;
    }
    
    public Room goEast() {
        return null;
    }
    
    public Room goNorth() {
        return null;
    }
    
    public Room goSouth() {
        return null;
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

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
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
