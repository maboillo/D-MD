package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		try {
			socket = new Socket("localhost", 9092);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Scanner scanner = new Scanner(System.in);  

			String textFromServer = null;
			String textToServer = null;
			do {
				for(int i=0;i <15;i++){
					textFromServer = in.readLine();
					System.out.println(textFromServer);			
					textFromServer = null;
				}
				
				textToServer = scanner.nextLine();
				
				out.print(textToServer); // send the response to client
				out.flush();
				System.out.println("enviado");
			} while (textToServer != "end");
			out.close();
			scanner.close();
			in.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
