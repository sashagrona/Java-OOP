package net.bigmir;

import java.io.File;

public class FindFile implements Runnable {
	private String path;
	private String file;
	private File currentFile;

	public FindFile(String path, String file) {
		super();
		this.path = path;
		this.file = file;
	}

	public FindFile() {
		super();
	}

	public File getCurrentFile() {
		return currentFile;
	}

	public void getFile() {
		System.out.println("I found " + getCurrentFile().getAbsolutePath());

	}

	public synchronized void find() {
		File folder = new File(path);
		File[] files = folder.listFiles();
		if (folder.isDirectory() && folder.exists()) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					FindFile ff = new FindFile(files[i].getAbsolutePath(), file);
					new Thread(ff).start();
				} else if (files[i].getName().equals(file)) {
					currentFile = files[i];
					getFile();
				}
			}
		} else {
			System.out.println("Error, no such a directory");
		}
	}

	@Override
	public synchronized void run() {
		find();
	}
}
