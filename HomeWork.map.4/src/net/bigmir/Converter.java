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
		String[] let =text.split(System.lineSeparator());
		int i = 1;
		int k = 1;
		int height = 8;
        
		for (char a = 'a'; a <= 'z'; a++) {
			StringBuilder sb = new StringBuilder();
			for (i = k; i < height; i++) {	
				 sb.append(let[i]);
				 if(i<height ) {
				 sb.append(System.lineSeparator());
				 }
			}
			map.put(a, sb.toString());	
			k += 8;
			height += 8;
		}
	}


	public void getWord(File file, String text){
		createLetter(file);
		char [] letters = text.toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character, String >> set = map.entrySet();
		for (char c : letters) {
			for(Map.Entry<Character, String > s : set) {
				if(s.getKey().equals(c)) {
					sb.append(s.getValue());
				}
				
			}
		}System.out.println(sb.toString());
	}
}
