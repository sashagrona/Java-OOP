package net.bigmir;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList( 4, 74, -3, 3,2,-2, 26, -43, 5);
		int result = list.stream()
				.mapToInt(n -> n)
				.filter(n -> n != 0)
				.map(n -> Math.abs(n))
				.min().getAsInt();
		System.out.println(result);
	}
}
