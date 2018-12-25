package net.bigmir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int n = 0;
		while (n < 10) {
			list.add(n);
			n++;
		}
		modifyList(list);
	}

	public static <T> void modifyList(List<T> list) {
		Deque<T> deq = new ArrayDeque<T>(list);
		System.out.println("Source list: " + deq);
		deq.pollFirst();
		deq.pollFirst();
		deq.pollLast();
		System.out.println("Your modified list: " + deq);

	}
}
