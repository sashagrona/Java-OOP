package net.bigmir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		try {
			int max = Files.lines(Paths.get("Numbers"))
					.flatMapToInt(n -> n.chars())
					.max().getAsInt();
			System.out.println((char) max);
		} catch (IOException e) {
			e.printStackTrace();
		}
				

	}

}
