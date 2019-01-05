package net.bigmir;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) {
		String os = System.getProperty("os.name");
		String vers = System.getProperty("os.version");

		try (ServerSocket servSock = new ServerSocket(6540)) {
			int num = 0;
			while (true) {
				Socket socket = servSock.accept();
				num++;
				String ansver = "<html><head><title>Информация о Diesel`s системе</title> <meta charset='utf-8'>"
						+ "</head><body><p>ЭТО САМЫЙ КРУТОЙ САЙТ ДИЗЕЛЯ</p><br>"
						+ "<p>Подробная информация о Diesel`s системе:</p>" + "<p>Операционная система: " + os + "<br>"
						+ "Версия: " + vers + "</p>" + "<p>Ваш запрос номер " + num + "</p></body></html>";
				ConnectClient client = new ConnectClient(socket, ansver);
				System.out.println("№" + num + " - " + socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}