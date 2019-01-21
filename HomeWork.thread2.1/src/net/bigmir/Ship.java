package net.bigmir;

public class Ship implements Runnable {
	private int box;
	private String name;

	public Ship(String name) {
		super();
		this.box = 10;
		this.name = name;
	}

	public Ship() {
		super();
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		for(int i = 0;i<box;i++) {
            System.out.println("Box No" + (i+1) + " was loaded from the ship " + this.name);
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
