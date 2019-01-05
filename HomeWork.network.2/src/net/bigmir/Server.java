package net.bigmir;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(8080)){
			int count = 0;
			while(true) {
				Socket socket = ss.accept();
				count++;
				Client cl = new Client(socket, count);
				cl.run();
				System.out.println(count + " " + socket);
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
