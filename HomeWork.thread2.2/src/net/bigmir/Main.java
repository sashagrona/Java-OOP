package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Copy c = new Copy(new File("source.jpg"), new File("copy.jpg"));
		Process p = new Process(c);
		Thread t = new Thread(c);
		Thread t1 = new Thread(p);
		t.start();
		t1.start();
		
	}

}
