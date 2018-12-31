package net.bigmir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Converter {
	private Map<Character, String> map = new HashMap<>();

	public String loadFromFont(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File not found");
		}
		String line = "";
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void createLetter(File file) {
		Converter c = new Converter();
		String text = c.loadFromFont(file);
		String[] let =null;
		int i = 1;
		int k = 1;
		int height = 8;
        
		for (char a = 'a'; a <= 'z'; a++) {
			for (i = k; i < height; i++) {	
				 let = text.split(System.lineSeparator());
			}
			map.put(a, let.toString());
			
			k += 8;
			height += 8;
		}
	}


	public void getWord(File file, String text){
		createLetter(file);
		char [] letters = text.toCharArray();
		Set<Map.Entry<Character, String >> set = map.entrySet();
		for (char c : letters) {
			for(Map.Entry<Character, String > s : set) {
				if(s.getKey().equals(c)) {
					System.out.print(s.getValue().toString());
					System.out.print(" ");
				}
			}
		}
	}

}
