package Server;

import java.net.ServerSocket;

public class Server extends Thread {

	public static void main(String[] args)throws Exception {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(9092);
        try {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
	}

}
