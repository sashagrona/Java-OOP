package net.bigmir;

import java.io.File;
import java.io.FilenameFilter;

public class ArrayFilter implements FilenameFilter {
	private String ext;
	
	public ArrayFilter(String ext) {
		super();
		this.ext = ext;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}
	
}
