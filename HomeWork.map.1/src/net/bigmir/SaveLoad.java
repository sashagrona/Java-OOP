package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveLoad {
	public String loadEnglishIn(File file) {
		if(file == null) {
			throw new IllegalArgumentException("File not found");
		}
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = "";
			for (; (line = br.readLine()) != null;) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public void saveUkrainianOut(File file, String text) {
		try(PrintWriter pw = new PrintWriter(file)){
			pw.println(text);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String loadDictionary(File file) {
		return loadEnglishIn(file);
	}
}
