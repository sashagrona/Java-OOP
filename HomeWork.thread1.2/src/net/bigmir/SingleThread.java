package net.bigmir;

public class SingleThread implements Runnable {
	private int[] array;
	private long count;
	private int begin;
	private int end;

	public SingleThread(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
	}

	public SingleThread() {
		super();
	}
	

	public long getCount() {
		return count;
	}

	@Override
	public void run() {
		for (int i = begin;i<=end;i++) {
			this.count+=i;
		}
		System.out.println("Sum of array by one thread: " + this.count);
	}
}
