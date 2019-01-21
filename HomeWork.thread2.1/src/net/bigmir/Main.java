package net.bigmir;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		ex.execute(new Ship("Victoria"));
		ex.execute(new Ship("Esperanto"));
		ex.execute(new Ship("Dolcia"));
		ex.shutdown();
	}
}
