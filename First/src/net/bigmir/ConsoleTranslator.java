package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConsoleTranslator {
	private Map<Character, String[]> dictionary;
	private int fontSize;

	public ConsoleTranslator() {
		super();
		dictionary = new HashMap<>();
	}

	public void loadFontFromFile(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String info = br.readLine();
			int letterSize = Integer.parseInt(info.split(":")[1]) - 1;
			fontSize = letterSize;
			String text = "";
			for (; (text = br.readLine()) != null;) {
				Character letter = text.charAt(0);
				String[] description = new String[letterSize];
				for (int i = 0; i < letterSize; i++) {
					description[i] = br.readLine();
				}
				dictionary.put(letter, description);
			}
		} catch (IOException e) {
		}
	}

	public String transform(String text) {
		char[] symbols = text.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fontSize; i++) {
			for (char sym : symbols) {
				sb.append(dictionary.get(sym)[i]);
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}