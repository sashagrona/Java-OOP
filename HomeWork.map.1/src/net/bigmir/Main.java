package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Translator tr = new Translator();
		File in = new File("English.in");
		File out = new File("Ukrainian.out");
		File dict = new File("Dictionary");
		System.out.println("In english: " + tr.getFromEnglishIn(in));
		System.out.println("In ukrainian: " + tr.getTranslation(dict, in));
		System.out.println();
		tr.saveInUkrainian(in, out, dict);
		DictionaryAdding da = new DictionaryAdding();
		da.saveNewToDictionary(dict, tr.convertDictToMap(dict));
	}
}
