package net.bigmir;

public class Main {

	public static void main(String[] args) {
		for(int i =1;i<=100;i++) {
			Thread t = new Thread(new Factorial(i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
