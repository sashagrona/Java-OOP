package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Converter c = new Converter();
		File file = new File("Font");
<<<<<<< HEAD
//       System.out.println(c.loadFromFont(file));
		c.getWord(file, "o\tops");
//		c.createLetter(file);
=======
		c.getWord(file, "prog");
>>>>>>> 0dfb0989a8575e326cbd1a3663c878bf08b2d9f2
	}

}
