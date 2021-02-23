package com.filehandling;

import java.util.ArrayList;
import java.util.Scanner;

import com.virtualkey.ExitProgram;
import com.virtualkey.OptionSelect;

public class FileOptions {
	private Scanner sc;
	 private ArrayList<String> options = new ArrayList<>();	
	 private String selectedOption;
	 private String instructions = "\nUser File menu: Please type one of the following commands below:";
	 private boolean lowerCase;
	 
	 public void FileOptionAdd(int user) {
		 options.add("add - add a new file"); 
		 options.add("delete - delete a nfile");
		 options.add("search - search for a file");
		 options.add("back - go back to the main menu");
		options.add("close - close out the program");
		 //options.add("case - toggle case sensitivity");
		 System.out.println("Welcome"+user);
		this.FileOptionPrint(user);
	 
	 }
	 
public void FileOptionPrint(int user) {
	
	 System.out.println(instructions);
	 options.stream()
	 .forEach(System.out::println);

	 this.FileOptionSwitch(user);
	
	
}
	 public void FileOptionSwitch(int user)
	    {
		 selectedOption = this.GetInput();
		 
	        switch(selectedOption) {

	            case "add":
	                
	                break;
	            case "delete":
	              
	                break;
	            case "search":
	                
	                break;
	                
	            case "back":
	            	OptionSelect os = new OptionSelect();
	        		os.OptionAddText();
	                break;

	            case "close":
		              ExitProgram close = new ExitProgram();
		              close.close();
	                break;

	            case "commands":
	                this.FileOptionPrint(user);
	                break;
	            
	            
	            default:
	                System.err.println("Invalid Option, please try again. Type commands to repeat command list");
	                this.FileOptionSwitch(user);
	                break;

	        }

	 
}
	 
	 
	 private String GetInput()
	    {

	        sc = new Scanner(System.in);
	        return(sc.nextLine());

	    }
	 
	 
	 
	 
}
