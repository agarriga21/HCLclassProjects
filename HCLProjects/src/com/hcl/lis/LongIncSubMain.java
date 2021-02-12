package com.hcl.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LongIncSubMain {
	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String restart; // restart option
		
		int n;
		System.out.println("Welcome to my program to find the longest "
				+ "\nincreasing subsequence of a random sequence length n.");
		while (true) {

			System.out.println("\nEnter the integer length n of the randomly generated sequence desired.");
		
		
		
		while (true) {

			try {

				n = input.nextInt();
				if(n<0) {
					System.out.println("n must be positive, please try again");
				continue;
				}
				else {
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Not a valid integer, please try again");
				input.next(); 
			}
		}
		
		SequenceHandler sh = new SequenceHandler();
		ArrayList<Integer> mySequence = sh.CreateArrayList(n);
		
		
		
		
		System.out.println("\nYour sequence is:");
		System.out.println(mySequence);
		
		sh.Compare(mySequence, n);
		input.nextLine();
		System.out.println("\nType Y to try again or type N to exit the program");
		while (true) {
			restart = input.nextLine();
			if (restart.equals("Y") || restart.equals("y")) {

				break;
			} else if (restart.equals("N") || restart.equals("n")) {

				break;
			}

			else {
				System.err.println("Invalid choice, please try again");

			}
		}

		if (restart.equals("Y") || restart.equals("y")) {

			continue;
		} else {
			System.out.println("Thank you for using the program.");
			break;
		}
		
		
	}
	}

}
