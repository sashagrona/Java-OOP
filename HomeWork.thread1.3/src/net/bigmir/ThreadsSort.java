package net.bigmir;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsSort {
private int threads = 0;
	public ThreadsSort() {
		super();
	}

	public int getThreads() {
		return threads;
	}
	public void sort(int[] arr) {
		int quantity = 1;
		int step = arr.length / 2;
		int count = arr.length;
		int begin = 0;
		ExecutorService ex = Executors.newFixedThreadPool(2);
		for(int n = 0;n<step;n++) {
			ex.execute(new ShellSort(arr, begin, step,n));
			
		}
		System.out.println(Arrays.toString(arr));
	}
}
