package com.virtualkey;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.filehandling.FileOptions;
import com.filehandling.SortFiles;

public class OptionSelect {
	private Scanner sc;
	 private ArrayList<String> options = new ArrayList<>();	
	 private String selectedOption;
	 private String instructions = "\nMain menu: Please type one of the following commands below:";
	 private int ID;
	 public void OptionAddText() {
		 options.add("id - input your user ID"); 
		 options.add("sort - sort files");
		 options.add("close - close out the program");
	 
		this.OptionPrint();
	 
	 }
	 
public void OptionPrint() {
	
	 System.out.println(instructions);
	 options.stream()
	 .forEach(System.out::println);
 
	 this.OptionSwitch();
	
	
}
	 public void OptionSwitch()
	    {
		 selectedOption = this.GetInput();
		 
	        switch(selectedOption) {

	            case "id":
	               System.out.println("Please type the user id to manage user specific files");
	            	ID =this.GetID();
	                FileOptions fo = new FileOptions();
	                fo.FileOptionAdd(ID);
	                break;
	            case "sort":
	            	SortFiles sf = new SortFiles();
	              sf.FileSorter();
	              this.OptionPrint();
	                break;
	            case "close":
		              ExitProgram close = new ExitProgram();
		              close.close();
	                break;

	            case "commands":
	                this.OptionPrint();
	                break;
	            
	            
	            default:
	                System.err.println("Invalid Option, please try again. Type commands to repeat command list");
	                this.OptionSwitch();
	                break;

	        }

	 
}
	 
	 
	 private String GetInput()
	    {

	        sc = new Scanner(System.in);
	        return(sc.nextLine());

	    }
	 
	 private int GetID()
	    {
		 sc = new Scanner(System.in);
	       int iD=0; 
	      while(iD<=0) { 
	       try {
	            iD = sc.nextInt();
	            if(iD>0) {
	            	break;
	            }
	            else {
	            	System.err.println("ID must be greater than 0, please try again");	
	            }
	        }
	        catch (InputMismatchException ex) {
	        	 System.err.println("Invalid ID format, please try again.");
	        sc.next();
	        }
	      }
		 
		 
		 
		 return(iD);

	    }
	 
	 
}