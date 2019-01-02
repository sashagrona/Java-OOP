package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Converter c = new Converter();
		File file = new File("Font");
		c.getWord(file, "prog");
	}

}
