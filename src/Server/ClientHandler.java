package Server;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import Basics.Room;

public class ClientHandler extends Thread {

	private final static Logger log = Logger.getLogger(Socket.class.getName());
	private static HashSet<String> names = new HashSet<String>();
	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
	public String name;
	private String input;
	private Socket socket;
	private BufferedReader in;
	public PrintWriter out;
	private Room currentRoom;
	public ArrayList<String> clientObj = new ArrayList<>();

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			// Start in the village square
			currentRoom = RoomHandler.getSquare();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			out = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				out.println("WELCOME to the");
				graphics();
				out.println("Log in with your name. After logging in you can type \"help\" to get a list of commands,");
				out.println("Look around, entertain yourself, have fun!");				

				// Sleep for delayed output
				TimeUnit.MILLISECONDS.sleep(1000);

				// Request a name from this client.
				// Keep requesting until a name is submitted that is not already used.
				out.println("What is your name?");
				out.println("----------------------------------------------");
				out.flush();
				
				name = in.readLine();
				System.out.println(name);
				if (name == null) {
					return;
				}
				if (names.contains(name)) {
					out.println("That's someone's name...");
				}

				synchronized (names) {
					if (!names.contains(name)) {
						names.add(name);
						break;
					}
				}
			}

			out.println("All right " + name.substring(20) + ", here we go!");
			writers.add(out);
			currentRoom.register(this);
			for (PrintWriter writer : writers) {
				writer.println(name.substring(20) + " has just logged in.");
			}
			while (true) {
				input = in.readLine();

				communicate();
				move();
				commonInput();
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	private void graphics() {
		int width = 80;
		int height = 15;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Arial", Font.BOLD, 12));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("DUNGEONS", 1, 10);

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {
				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
			}
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
			out.println(sb);
		}
		out.println();

	}

	private void commonInput() throws InterruptedException {
		if (input.matches("i")) {
			if (clientObj.isEmpty()) {
				out.println("You have nothing with you.");
			} else {
				for (int i = 0; i < clientObj.size(); i++) {
					out.println(clientObj.get(i));
				}
			}
		}

		if (input.matches("end")) {
			disconnect();
		}
		currentRoom.roomItems();

		if (input.matches(("l"))) {
			out.println(currentRoom.getNormal());
			out.println(currentRoom.getExplained());
			out.println(currentRoom.getNPC());
			out.println(currentRoom.clientsInRoom());
		}

		if (input.matches(("who"))) {

			out.println("Currently logged in:");
			for (String name : names) {
				out.println(name.substring(20));
			}

		}
		if (input.matches(("help"))) {
			out.println("list of commands:");
			out.println("l - look at your surroundings");
			out.println("b ENVIRONMENT = look at a conscience object or detail more closely.");
			out.println("l OBJETIVE - look at a conscience object or derail more closely");
			out.println("say TEXT - send TEXT as chat message to all logged in users");
			out.println("who - list of currently logged users");
			out.println("i = show you your inventory, that is what you are carrying");
			out.println("n, w, s, e - north, west, south and east with the command you move in each direction");
			out.println("end = ends the connection and closes the active window");

			if (input.length() > 3) {
				String key = input.substring(2);
				if (input.matches("b " + key)) {
					out.println(currentRoom.explainedItems(key));
				} else {
					out.println("");
				}
			}
		}
	}

	private void move() throws IOException {
		if (input.matches(("w"))) {
			if (currentRoom.goWest() != null) {

				out.println(currentRoom.getWest());
				currentRoom.unregister(this);
				currentRoom.leaveRoom(this);

				currentRoom = currentRoom.goWest();
				out.println("");
				out.println(currentRoom.getNormal());
				out.println(currentRoom.getExplained());

				currentRoom.enterRoom(this);

				currentRoom.register(this);
				out.println(currentRoom.getNPC());
				out.println(currentRoom.clientsInRoom());
			} else {
				out.println("That's as far as it goes.");
			}
		}

		if (input.matches(("e"))) {
			if (currentRoom.goEast() != null) {

				out.println(currentRoom.getEast());
				currentRoom.unregister(this);
				currentRoom.leaveRoom(this);

				currentRoom = currentRoom.goEast();
				out.println("");
				out.println(currentRoom.getNormal());
				out.println(currentRoom.getExplained());

				currentRoom.enterRoom(this);

				currentRoom.register(this);
				out.println(currentRoom.getNPC());
				out.println(currentRoom.clientsInRoom());
			} else {
				out.println("That's as far as it goes.");
			}
		}

		if (input.matches(("s"))) {
			if (currentRoom.goSouth() != null) {

				out.println(currentRoom.getSouth());
				currentRoom.unregister(this);
				currentRoom.leaveRoom(this);

				currentRoom = currentRoom.goSouth();
				out.println("");
				out.println(currentRoom.getNormal());
				out.println(currentRoom.getExplained());

				currentRoom.enterRoom(this);

				currentRoom.register(this);
				out.println(currentRoom.getNPC());
				out.println(currentRoom.clientsInRoom());
			} else {
				out.println("That's as far as it goes.");
			}
		}

		if (input.matches(("n"))) {
			if (currentRoom.goNorth() != null) {

				out.println(currentRoom.getNorth());
				currentRoom.unregister(this);
				currentRoom.leaveRoom(this);

				currentRoom = currentRoom.goNorth();
				out.println("");
				out.println(currentRoom.getNormal());
				out.println(currentRoom.getExplained());

				currentRoom.enterRoom(this);

				currentRoom.register(this);
				out.println(currentRoom.getNPC());
				out.println(currentRoom.clientsInRoom());
			} else {
				out.println("That's as far as it goes.");
			}
		}

	}

	private void communicate() {
		if (input.matches("say .*")) {
			String text = input.substring(3);
			currentRoom.talk(text, this);
		}

	}

	// Shut down connection
	private void disconnect() {
		if (name != null) {
			names.remove(name);
			for (PrintWriter writer : writers) {
				writer.println(name.substring(20) + " has just disconnected.");
			}
			currentRoom.unregister(this);
		}
		if (out != null) {
			writers.remove(out);
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
