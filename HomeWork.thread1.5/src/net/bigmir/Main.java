package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File folder = new File("Folder");
		folder.mkdir();
		Thread thread = new Thread(new CheckCatalog(folder));
		thread.start();
		try {
			thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();

	}

}
