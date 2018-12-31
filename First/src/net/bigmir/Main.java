package net.bigmir;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsoleTranslator ct = new ConsoleTranslator();
		File font = new File("Font");
		ct.loadFontFromFile(font);
		System.out.println(ct.transform("text"));
	}

}