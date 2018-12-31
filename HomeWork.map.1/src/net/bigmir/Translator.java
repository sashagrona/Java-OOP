package net.bigmir;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Translator {
	private SaveLoad sl = new SaveLoad();

	public String getFromEnglishIn(File file) {
		return sl.loadEnglishIn(file);
	}

	public String getFromDictionary(File file) {
		return sl.loadDictionary(file);
	}

	public Map<String, String> convertDictToMap(File file) {
		String text = getFromDictionary(file);
		String[] array = text.split(System.lineSeparator());
		Map<String, String> map = new TreeMap<String, String>();
		for (String combinations : array) {
			String[] words = combinations.split("-");
			for (int i = 0; i < words.length; i++) {
				map.put(words[0], words[1]);
			}
		}
		return map;
	}

	public String getTranslation(File dict, File english) {
		Map<String, String> map = convertDictToMap(dict);
		Set<Map.Entry<String, String>> set = map.entrySet();
		String text = getFromEnglishIn(english);
		String line = "";
		String delimiters = "[ .,\n!]";
		String[] array = text.split(delimiters);

		for (String key : array) {
			for (Map.Entry<String, String> s : set) {
				if (key.equals(s.getKey())) {
					line += s.getValue() + " ";
				}
			}
			if (!map.containsKey(key)) {
				line += "(I didn't find this word:(" + key + ") in the dictionary) ";
			}
		}
		return line;
	}

	public void saveInUkrainian(File in, File out, File dict) {
		String text = getTranslation(dict, in);
		sl.saveUkrainianOut(out, text);
		System.out.println("Translation is saved successfully");
	}

}
