package me.steveice10.canarybridge;

import java.io.File;
import java.io.FilenameFilter;

public class JarFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		if(!(new File(dir, name).isFile())) return false;
		
		if(name.toLowerCase().endsWith(".jar")) return true;
	
		return false;
	}
	
}
