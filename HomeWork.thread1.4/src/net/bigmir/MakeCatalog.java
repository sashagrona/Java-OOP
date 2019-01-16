package net.bigmir;

import java.io.File;
import java.io.IOException;

public class MakeCatalog {
	public void make(File folder) {
		folder.mkdir();
		File file1 = new File(folder.getAbsolutePath() + "/a.txt");
		File file2 = new File(folder.getAbsolutePath() + "/b.txt");
		File file3 = new File(folder.getAbsolutePath() + "/c.txt");
		File file4 = new File(folder.getAbsolutePath() + "/d.txt");
		File file5 = new File(folder.getAbsolutePath() + "/e.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
			file3.createNewFile();
			file4.createNewFile();
			file5.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Folder with 5 files was created successfully");
		
		
	}
}
