package net.bigmir;

public class Process implements Runnable {
	private Copy c;

	public Process(Copy c) {
		super();
		this.c = c;
	}

	public Process() {
		super();
	}

	@Override
	public void run() {
		synchronized (this) {
				c.progressScreen();	
		}
	}

}
