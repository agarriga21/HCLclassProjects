package com.hcl.filehandling;

import java.util.Scanner;

public class FileMain {

	private static Scanner input;

	public static void main(String[] args) {

		FileMethods fileMethods = new FileMethods();
		String commands;
		String inputcommand;
		String inputname;
		Boolean commandLoop=true;

		System.out.println("Welcome to my text file manager program.");
		
		
		while (commandLoop) {
			commands = ("\nPlease type a command to perform. Type 'list' to show commands.");
			System.out.println(commands);
			input = new Scanner(System.in);
			inputcommand = input.nextLine();
			
			
			switch (inputcommand) {

			case "create":
				System.out.println("What would you like to name your file?");
				inputname = input.nextLine();
				fileMethods.CreateFile(inputname + ".txt");

				break;
			case "delete":
				System.out.println("What is the name of the file you would like to delete?");
				inputname = input.nextLine();
				fileMethods.DeleteFile(inputname + ".txt");
				break;
				
			case "write":
				System.out.println("What is the name of the file you would like to write too?");
				inputname = input.nextLine();
				
				
				fileMethods.WriteFile(inputname+ ".txt");
				
				break;
				
			case "read":
				System.out.println("What file would you like to read?");
				inputname = input.nextLine();
				fileMethods.ReadFile(inputname + ".txt");
				break;
				
			case "append":
				System.out.println("What is the name of the file you would like to append?");
				inputname = input.nextLine();
				
				
				fileMethods.AppendFile(inputname+ ".txt");
				
				break;
			case "exit":
				commandLoop=false;
				break;
			case "list":
				System.out.println("create - creates a new .txt file.");
				System.out.println("delete - deletes an existing file");
				System.out.println("write - writes and replaces text to and existing file");
				System.out.println("read - displays text written in an existing file");
				System.out.println("append - adds text to an existing file");
				System.out.println("exit - closes the program");
				break;
				
			default:
				System.err.println("Unknown Command");
			
			}

		}
		System.out.println("Thank you for using my text file manager program.");
	}
}
