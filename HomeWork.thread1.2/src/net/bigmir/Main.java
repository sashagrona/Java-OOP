package net.bigmir;

public class Main {

	public static void main(String[] args) {
		Thread t = new Thread(new SingleThread(getArray(),0,100_000_000));
		long begin = System.currentTimeMillis();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Proccessing time: " + (end - begin) + " ms");
		MultiThreads mt = new MultiThreads(5,getArray());
		begin = System.currentTimeMillis();
		mt.calculateMulty();
		end = System.currentTimeMillis();
		System.out.println("Proccessing time by 5 threads: " + (end - begin) + " ms");

	}

	public static int[] getArray() {
		int n = 100_000_000;
		int[] array = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
		return array;
	}

}
