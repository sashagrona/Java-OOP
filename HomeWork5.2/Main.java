package net.bigmir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
	public static void main(String[] args) {
		File file1 = new File("fileOne.txt");
		File file2 = new File("fileTwo.txt");

		try (BufferedWriter bwOne = new BufferedWriter(new FileWriter(file1));
				BufferedWriter bwTwo = new BufferedWriter(new FileWriter(file2))) {
			bwOne.write("Hello beautiful world");
			bwTwo.write("Hello terrible world");
		} catch (IOException e) {
			e.printStackTrace();
		}
		TextToFile.createFileThree(file1, file2);
	}
	
}
