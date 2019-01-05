package net.bigmir;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://prog.kiev.ua/forum/");
			URLToFIle link = new URLToFIle();
			link.linksToFile(url, "UTF-8");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
