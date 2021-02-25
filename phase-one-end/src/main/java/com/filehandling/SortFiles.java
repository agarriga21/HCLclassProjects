package com.filehandling;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortFiles {

	public void FileSorter(){
		System.out.println("Sorted file names including user id:");
		File directory = new File(System.getProperty("user.dir")+"\\ProjectFiles\\");
		List<String> fileList = new ArrayList<String>();
		String files[] = directory.list();
		fileList = Arrays.asList(files);
		
		
		
		if(fileList.size()>0) {
		Collections.sort(fileList);
	System.out.println(fileList);
		}
		else {
			System.err.println("There seems to be no files in the directory ProjectFiles");	
		}
	}
}
