package net.bigmir;

import java.io.File;

public class Threads {
	private Thread[] threads;
	private int begin;
	private int end;

	public Threads() {
		super();
	}

	public void copyByThreads(File folderIn) {
		begin = 0;
		end = 1;
		File[] files = folderIn.listFiles();
		int thQ = files.length;
		threads = new Thread[thQ];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Copy(files, begin, end));
			threads[i].start();
			begin++;
			end++;
		}
	}
}
