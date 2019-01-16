package net.bigmir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class Copy implements Runnable {
	private File[] listfiles;
	private int begin;
	private int end;

	public Copy(File[] listfiles, int begin, int end) {
		super();
		this.listfiles = listfiles;
		this.begin = begin;
		this.end = end;
	}

	public Copy() {
		super();
	}

	@Override
	public void run() {
		File[] file = Arrays.copyOfRange(listfiles, begin, end);
		File folderOut = new File("FolderOut");
		folderOut.mkdir();

		Path folder = folderOut.toPath();
		for (int i = 0; i < file.length; i++) {
			try {
				Files.copy(file[i].toPath(), folder.resolve(file[i].getName()), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Arrays.toString(file));
	}

}
