package net.bigmir;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int range = 200;
		Random rn = new Random();
		
		int[] arr = new int[range];
		for(int i=0;i<arr.length;i++) {
			arr[i] = rn.nextInt(range);
		}
		System.out.println("Unsorted: " + Arrays.toString(arr));
		ThreadsSort ts = new ThreadsSort();
		ts.sort(arr);

	}

}
