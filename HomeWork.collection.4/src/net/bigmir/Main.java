package net.bigmir;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Queue<String> que = new ArrayDeque<>();
		que.add("Sheldon");
		que.add("Leonard");
		que.add("Volovets");
		que.add("Kutrapalli");
		que.add("Penni");
		System.out.println("How many cola it was drank?");
		Scanner sc = new Scanner(System.in);
		int quantity = sc.nextInt();
		sc.close();
		int i = 0;
		System.out.println("Source queue: " + que);
		while (i < quantity) {
			String b = que.element();
			que.poll();
			que.add(b);
			que.add(b);
			i++;
		}
		System.out.println("After " + quantity + " cola queue is " + que);

	}

}
