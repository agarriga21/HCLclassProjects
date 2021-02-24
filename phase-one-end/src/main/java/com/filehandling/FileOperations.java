package com.filehandling;

import java.io.File;

public class FileOperations {
	public void CreateFile(String fileName, int user) {
		try {
			
			File aFile = new File(System.getProperty("user.dir")+"\\ProjectFiles\\"+fileName+user+".txt");
			if (aFile.exists()) {
				System.out.println("Unable to create " + fileName);
				System.out.println(fileName + "under user ID: "+user+" already exists in " + aFile.getAbsolutePath());

			} else {
				aFile.createNewFile();
				System.out.println(fileName + " was successfully created! ");
				System.out.println(fileName + " was put into " + aFile.getAbsolutePath());
			}
		} catch (Exception ex) {
			System.out.println("Unable to create " + fileName);
			System.err.println(ex.getMessage());
		}

	}

	public void DeleteFile(String fileName, int user) {
		boolean status = false;
		try {
			File aFile = new File(System.getProperty("user.dir")+"\\ProjectFiles\\"+fileName+user+".txt");
			if (aFile.exists()) {
				status = (aFile.delete());
				if (status == true) {
					System.out.println(fileName + " was successfully deleted! ");
				} else {
					System.out.println("No delete performed");
				}

			} else {
				System.out.println(fileName + "under user ID: "+user+" does not exist. ");
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}
}
