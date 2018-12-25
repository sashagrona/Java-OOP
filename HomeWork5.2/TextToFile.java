package net.bigmir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextToFile {

	public static String[] splitText(File file) throws NullPointerException {
		if (file == null) {
			throw new NullPointerException();
		}
		String[] words = null;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = br.readLine();
			words = text.split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

	public static String checkWords(File a, File b) {
		String[] aWords = splitText(a);
		String[] bWords = splitText(b);
		String line = "";
		for (int i = 0; i < aWords.length; i++) {
			for (int j = 0; j < bWords.length; j++) {
				if (aWords[i].equals(bWords[j])) {
					line += aWords[i] + " ";
				}
			}
		}
		return line;
	}

	public static void createFileThree(File a, File b) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ResultFile.txt")))) {
			bw.write(checkWords(a, b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
