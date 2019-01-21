package net.bigmir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy implements Runnable {
	private File source;
	private File copy;
	private double progress;
	private boolean state;
	private double result;
	private long size;

	public Copy(File source, File copy) {
		super();
		this.source = source;
		this.copy = copy;
		this.state = true;
		this.size = source.length();
	}

	public Copy() {
		super();
	}

	public double getProgress() {
		return progress;
	}

	public synchronized void setProgress(double progress) {
		while (!state) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.progress = progress;
		state = false;
		notify();
	}

	public synchronized void progressScreen() {

		while (state) {
			try {
				wait();
				state = true;
				result = (getProgress() / size) * 100;
				System.out.print("I am copying "); 
				System.out.printf("%.2f", result);
				System.out.print(" %\n");
				notify();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void getCopy() {
		try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(copy)) {
			int bytereader;
			byte[] buffer = new byte[1024];
			for (; (bytereader = is.read(buffer)) > 0;) {
				os.write(buffer, 0, bytereader);
				progress += bytereader;
				setProgress(progress);
				if(progress==size) {
					System.out.println("Copy was created successfully");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
			getCopy();
	}
}
