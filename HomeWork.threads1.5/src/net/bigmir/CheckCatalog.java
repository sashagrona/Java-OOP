package net.bigmir;

import java.io.File;
import java.util.Arrays;

public class CheckCatalog implements Runnable {
	private File folder;

	public CheckCatalog(File folder) {
		super();
		this.folder = folder;
	}

	public CheckCatalog() {
		super();
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		File[] files = folder.listFiles();
		while (!thread.isInterrupted()) {
			try {
				thread.sleep(1000);
				File[] checkingFiles = folder.listFiles();
				check(files, checkingFiles);
				files = checkingFiles;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public void check(File[] previous, File[] next) {
		boolean state = true;
		for (int i = 0; i < previous.length; i++) {
			for (int j = 0; j < next.length; j++) {
				if (previous[i].getName().equals(next[j].getName())) {
					state = false;
				} 
			}
			if(state) {
					System.out.println("The file " + previous[i].getName() + " was deleted...");
				
			}
		}
		for (int i = 0; i < next.length; i++) {
			for (int j = 0; j < previous.length; j++) {
				if (next[i].getName().equals(previous[j].getName())) {
					state = false;
				} 
			}
			if(state) {
					System.out.println("The file " + next[i].getName() + " was added...");
				
			}
		}
	}

}
