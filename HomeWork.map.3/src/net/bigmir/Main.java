package net.bigmir;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 5, 3, 7, 8, 5, 5, 1 };
		Map<Integer, Integer> map = getFrequancy(array);
		map.forEach((key, value) -> System.out.println(key + " = " + value));

	}

	public static <T> Map<Integer, Integer> getFrequancy(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : array) {
			Integer value = map.get(i);
			if (value == null) {
				map.put(i, 1);
			} else {
				map.put(i, value + 1);
			}
		}
		return map;

	}

}
