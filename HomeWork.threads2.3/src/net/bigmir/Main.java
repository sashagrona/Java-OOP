package net.bigmir;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the path: ");
		String p;
		String f;
		p = sc.nextLine();
		System.out.println("What files do you want to find");
		f = sc.nextLine();
		FindFile ff = new FindFile(p, f);
		Thread t1 = new Thread(ff);
		t1.start();
	}

}
