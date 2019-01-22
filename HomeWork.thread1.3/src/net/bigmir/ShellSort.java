package net.bigmir;

import java.util.Arrays;

public class ShellSort implements Runnable {
	private int step;
	private int[] arr;
	private int d = 2;
	private int l = 1;
	private int begin;
	private int end;
	private int quantity = 1;
	private int n;

	public ShellSort(int[] arr, int begin, int end, int n) {
		super();
		this.arr = arr;
		this.begin = begin;
		this.end = end;
		this.n = n;
	}

	public ShellSort() {
		super();
	}

	@Override
	public void run() {
		
		step = arr.length / 2;
		int temp = 0;
//		if (quantity == 1) {
			for (begin = n; begin < end+1+n; begin++) {
				if (arr[begin] > arr[begin + end]) {
					temp = arr[begin];
					arr[begin] = arr[begin + end];
					arr[begin + end] = temp;
//				}
			}
		}
		int j = 0;
		while (quantity-1  < 2) {
			for (int begin = n; begin < step * l - 1; begin++) {
				temp = arr[j];
				if (arr[begin] > arr[begin + end / d]) {
					temp = arr[begin + end / d];
					arr[begin + end / d] = arr[begin];
					j = begin;
				}
				while (j > 0 && temp < arr[j - 1]) {
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = temp;
				
				
			}
			d *= 2;
			if (l * end < arr.length) {
				l += 1;
			}
			quantity++;
		}
//		System.out.println(Arrays.toString(arr));
	}
}
