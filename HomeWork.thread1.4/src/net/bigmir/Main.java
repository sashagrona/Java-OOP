package net.bigmir;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		MakeCatalog mc = new MakeCatalog();
		File folderIn = new File("Folder");
		mc.make(folderIn);
		Threads th = new Threads();
		th.copyByThreads(folderIn);

	}

}
