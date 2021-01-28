package com.hcl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		double x; //first number
		double y; //second number
		double z; //answer
		String operation; //where the operation for the problem is stored
		String restart; //restart option

		
		System.out.println("Welcome to the basic arithmetic calculator");
	
	
	while(true) {
	
	
	System.out.println("Enter you first number or decimal");
	
	
	while(true) {
		
		  try {
		     
		     x = input.nextDouble();
		     break;
		 }catch(InputMismatchException e) {
		   System.out.println("Invalid entry, please try again");
		   input.next(); // eat some chars
		 }
		}
	
	
	
	System.out.println("Enter you second number or decimal");
	
	
	
	while(true) {
		
		  try {
		     
		     y = input.nextDouble();
		     break;
		 }catch(InputMismatchException e) {

			 System.out.println("Invalid entry, please try again");
		   
		   input.next();
		 }
		}
	
	input.nextLine();
	
	
	System.out.println("Please select what operation you would like to perform:");
	System.out.println("Type + for addition, - for subtraction, x for multiply, and / for division");	
	
	
	while(true) {
		operation = input.nextLine();	
	if(operation.equals("+"))
	{
		z = x + y;
		break;
	}
	else if(operation.equals("-"))
	{
		z = x - y;
		break;
	}
	else if(operation.equals("x"))
	{
		z = x * y;
		break;
	}
	else if(operation.equals("/"))
	{
		z = x / y;
		break;
	}
	else {
		System.out.println("Invalid operation, please try again");
		
	}
	
	}
	
	
	System.out.println(x +" " +operation+ " "+y + " = " +z);
	System.out.println("\n Would you like to do another calculation?");
	System.out.println("Type Y for yes or type N to exit the program");
	
	
	while(true) {
		restart = input.nextLine();
		if(restart.equals("Y")||restart.equals("y"))
		{
			
			break;
		}
		else if(restart.equals("N")||restart.equals("n"))
		{
			
			break;
		}
		
		
		else
		{
			System.out.println("Invalid choice, please try again");
			
		}
	}
	
	if(restart.equals("Y")||restart.equals("y"))
	{
		
		continue;
	}
	else
	{
		System.out.println("Thank you for using my calculator.");	
		break;
	}
	
	
	
	}	
}
}