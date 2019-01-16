package net.bigmir;

public class ShellSort implements Runnable {
	private int step;
	private int[] arr;
	private int quantity;
	private int d;
	private int l;

	public ShellSort(int[] arr, int quantity, int d, int l) {
		super();
		this.arr = arr;
		this.quantity = quantity;
		this.d = d;
		this.l = l;
	}

	public ShellSort() {
		super();
	}

	@Override
	public void run() {
		step = arr.length / 2;
		int temp = 0;
		if (quantity == 1) {
			for (int i = 0; i < step; i++) {
				if (arr[i] > arr[i + step]) {
					temp = arr[i];
					arr[i] = arr[i + step];
					arr[i + step] = temp;
				}
			}
		}
		int j = 0;

		for (int i = 0; i < step * l - 1; i++) {
			temp = arr[j];
			if (arr[i] > arr[i + step / d]) {
				temp = arr[i + step / d];
				arr[i + step / d] = arr[i];
				j = i;
			}
			while (j > 0 && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}
}
