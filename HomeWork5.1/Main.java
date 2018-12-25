package net.bigmir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

	public static void main(String[] args) {
		ArrayFilter array = new ArrayFilter(".pdf");
		Path target = Paths.get("Target");
		Path p1 = Paths.get("a.doc");
		Path p2 = Paths.get("b.doc");
		Path p3 = Paths.get("c.pdf");
		Path p4 = Paths.get("d.pdf");
		Path p5 = Paths.get("e.doc");
		File targ = target.toFile();
		targ.mkdir();
		try {
			Files.createFile(p1);
			Files.createFile(p2);
			Files.createFile(p3);
			Files.createFile(p4);
			Files.createFile(p5);
		}catch(IOException e) {
			System.out.println("This file is already exists");
		}
		File file = new File(".");
		File[] list = file.listFiles(array);
		for (File file2 : list) {
			Path path = file2.toPath();
			try {
				Files.copy(path, target.resolve(file2.getName()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("This file is already exists");
			}
			System.out.println(file2);
		}
		
	}
}
