package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Converter c = new Converter();
		File file = new File("Font");
//       System.out.println(c.loadFromFont(file));
		c.getWord(file, "o\tops");
//		c.createLetter(file);
	}

}
