package net.bigmir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		try {
			Optional <Integer> max = Files.lines(Paths.get("Numbers"))
					.map(n -> n.split(" "))
					.flatMap(n -> Arrays.stream(n))
					.map(n -> Integer.parseInt(n))
					.max(Integer :: compareTo);
			System.out.println(max.get());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
