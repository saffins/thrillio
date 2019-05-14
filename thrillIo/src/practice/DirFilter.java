package practice;

import java.io.File;
import java.io.FilenameFilter;

class DirFilter implements FilenameFilter {
	// Holds filtering criteria
	public boolean accept(File file, String name) {
		return name.endsWith(".txt") || name.endsWith(".JPG");
	}
	
}

