package io.input.directory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public abstract class DirUtils {
	/**
	 * Templete Method
	 * @param file
	 */
	protected abstract void operate(File file);
	
	/**
	 * ディレクトリを再帰的に読む
     * @param folderPath
     */
	public void readFolder(File dir) {
		File[] files = dir.listFiles();
	  	if(files == null) return;
	    for(File file: files) {
	    	if(!file.exists()) {
	    		continue;
	    	} else if(file.isDirectory()) {
	    		readFolder(file);
    		} else if(file.isFile())
	        operate(file);
	    }
	}
	  
	  
}
