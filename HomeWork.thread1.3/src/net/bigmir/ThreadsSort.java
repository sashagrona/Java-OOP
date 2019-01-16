package net.bigmir;

import java.util.Arrays;

public class ThreadsSort {

	public ThreadsSort() {
		super();
	}

	public void sort(int[] arr) {
		int quantity = 1;
		int step = arr.length / 2;
		int l = 1;
		int d = 2;
		int threads = 0;
		int count = arr.length;
		while(count > 1) {
			count/=2;
			threads ++;
		}
		threads-=1;
		System.out.println("Quantity of threads " + threads);
		ShellSort[] ss = new ShellSort[threads];
		Thread[] thread = new Thread[threads];
		for (int i = 0; i < thread.length; i++) {
			ss[i] = new ShellSort(arr, quantity, d, l);
			thread[i] = new Thread(ss[i]);
			thread[i].start();
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			quantity++;
			d *= 2;
			if(l*step < arr.length) {
			l += 1;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
