package com.hcl.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMethods {

	private static Scanner inputWriter = new Scanner(System.in);

	public void CreateFile(String filename) {
		try {
			File aFile = new File(filename);
			if (aFile.exists()) {
				System.out.println("Unable to create " + filename);
				System.out.println(filename + " already exists in " + aFile.getAbsolutePath());

			} else {
				aFile.createNewFile();
				System.out.println(filename + " was successfully created! ");
				System.out.println(filename + " was put into " + aFile.getAbsolutePath());
			}
		} catch (Exception ex) {
			System.out.println("Unable to create " + filename);
			System.err.println(ex.getMessage());
		}

	}

	public void DeleteFile(String fileName) {
		boolean status = false;
		try {
			File aFile = new File(fileName);
			if (aFile.exists()) {
				status = (aFile.delete());
				if (status == true) {
					System.out.println(fileName + " was successfully deleted! ");
				} else {
					System.out.println("No delete performed");
				}

			} else {
				System.out.println(fileName + " does not exist. ");
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	public void WriteFile(String fileName) {

		BufferedWriter writer = null;

		try {
			
			

			File aFile = new File(fileName);
			
			if (aFile.exists()) {
				
				System.out.println("What would you like to write in the file?");
				System.out.println("Type :STOP on an empty line to finish writing.");
				String input = inputWriter.nextLine();
				String killCommand = ":STOP";
				
				writer = new BufferedWriter(new FileWriter(fileName));
				
				while (!input.equals(killCommand)) {
					writer.write(input);
					writer.newLine();
					input = inputWriter.nextLine();
				}
			} else {

				System.out.println(fileName + " does not exist.");

			}
		}

		catch (IOException e) {

			System.err.println(e.getMessage());

		} catch (NullPointerException npe) {
			System.err.println(npe.getMessage());

		} finally {

			if (writer != null)
				try {
					writer.flush();
					writer.close();
					System.out.println("File has been written to successfully!");
				} catch (IOException e) {

					System.err.println(e.getMessage());
				}
		}

	}

	public void ReadFile(String fileName) {
		try {
			File aFile = new File(fileName);
			Scanner myReader = new Scanner(aFile);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " does not exist.");
			System.err.println(e.getMessage());
		}
	}

	public void AppendFile(String fileName) {

		BufferedWriter writer = null;

		try {
			
			System.out.println("What would you like to add in this file?");
			System.out.println("Type only :STOP on an input line to finish editting.");
			File aFile = new File(fileName);
			Scanner myReader = new Scanner(aFile);
			

			if (aFile.exists()) {

				String input="";
				String killCommand = ":STOP";
				String data = "";
				ArrayList<String> fileText = new ArrayList<String>();	
				int i=0;
				int j;
				try {	
					while (true) {
					
						data = myReader.nextLine();
						System.out.print("LINE " +(i+1)+": "+data);
					input = inputWriter.nextLine();
					
					
					if(input.equals(killCommand)) {
						fileText.add(i, data);
						
						try {
							while (true) {
							i++;
							data = myReader.nextLine();
							fileText.add(i, data);
							
							}
						
						}catch(NoSuchElementException npe) {
						
							myReader.close();
						break;}
					}
					else{
						fileText.add(i, data+input);
						System.out.println("NEW LINE " +(i+1)+": " +data +input);
					i++;
					}
					
					}
				}
				catch(NoSuchElementException npe) {
					myReader.close();
					
					while (true) {
						
						
						input = inputWriter.nextLine();
						if(input.equals(killCommand)) {
							break;
						}
						else{
							fileText.add(i, input);
							System.out.println("NEW LINE " +(i+1)+": " +input);
						i++;
						}
					}
					
				}
				writer = new BufferedWriter(new FileWriter(fileName));
				
				for(j=0;i>j;j++) {
				writer.write(fileText.get(j));
				writer.newLine();
				}
				}

				
			 else {

				System.out.println(fileName + " does not exist.");

			}
		}

		catch (IOException e) {

			System.err.println(e.getMessage());

		} catch (NullPointerException npe) {
			System.err.println(npe.getMessage());

		} finally {

			if (writer != null)
				try {
					writer.flush();
					writer.close();
					System.out.println("File has been appended successfully!");
				} catch (IOException e) {

					System.err.println(e.getMessage());
				}
		}

	}
}
