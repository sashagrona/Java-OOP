package net.bigmir;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Statistic stat = new Statistic();
		File file = new File("Text");
		try {
			System.out.println("The text: " + stat.getFromFile(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(stat.toString(file));

	}

}
