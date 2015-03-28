package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.glassfish.tyrus.server.Server;

public class WebSocketServer {
	public static void main(String[] args) {
		runServer();
	}

	public static void runServer() {
		//TODO: pass the hostname to the program
		Server server = new Server("localhost", 8025, "/websockets",
				ServerEndPoint.class);
		try {
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Please press a key to stop the server.");
			reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}
}