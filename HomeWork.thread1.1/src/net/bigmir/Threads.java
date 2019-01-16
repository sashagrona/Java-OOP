package net.bigmir;

public class Threads{
	private Factorial fac;
	private int n;
	private Thread t;

	public Threads(int n) {
		super();
		this.n = n;
	}

	public void calculate() {
		for(int i =0;i<n;i++) {
			t = new Thread(new Factorial(i));
			t.start();
		}
	}

}
