package net.bigmir;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
	private Socket soc;
	private int count;
	private Thread t;

	public Client(Socket soc, int count) {
		super();
		this.soc = soc;
		this.count = count;
		t = new Thread();
		t.start();
	}

	@Override
	public void run() {
		try (OutputStream os = soc.getOutputStream(); PrintWriter pw = new PrintWriter(os)) {
			String response = System.getProperty("os.name") + "\r\n" + System.getProperty("os.version") + "\r\n"
					+ Runtime.getRuntime().availableProcessors() + "\r\n";
			pw.print(response + "Quantity: " + count + "\r\n");
			pw.flush();
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

}
