package net.bigmir;

public class MultiThreads{
	private SingleThread[] tArray;
	private int quantity;
	private int[] array;
	private Thread[] threads;

	public MultiThreads(int quantity, int[] array) {
		super();
		this.quantity = quantity;
		this.array = array;
		threads = new Thread[quantity];
		tArray = new SingleThread[quantity];
	}

	public MultiThreads() {
		super();
	}
	
	public void calculateMulty() {
		int step = 0;
		long sum = 0;
		for(int i = 0;i<tArray.length;i++) {
			step = array.length/quantity;
			int begin = step*i;
			int end =0;
			if(i!=(tArray.length-1)) {
			end = step*(i+1)-1;
			}else {
				end = step*(i+1);
			}
			tArray[i] = new SingleThread(array, begin, end);
			threads[i] = new Thread(tArray[i]);
			threads[i].start();	
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		for (SingleThread i : tArray) {
			sum += i.getCount();
		}
		System.out.println("Sum by " + quantity + " threads is " + sum);
	}
	

	
}
