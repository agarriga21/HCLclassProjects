package com.hcl.emailvalid;

import java.util.Scanner;

public class EmailValidate {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		EmailGenerator getemaillist = new EmailGenerator();
		CheckEmail validator = new CheckEmail();
		String emailinput;
		String restart;

		System.out.println("Welcome to the email validator!");

		while (true) {
			System.out.println("\nPlease type in a valid email address to verify if it is in this array.");
			System.out.println("Type LIST to display the email array.");
			System.out.println("\nEmail in array example: johndoe@yahoo.com");
			
			emailinput = input.nextLine();
			
			if (validator.isValid(emailinput) == true) {
				System.out.println(emailinput+" is a Valid email address");
				if (getemaillist.inArray(emailinput)) {
					System.out.println("The email address: "+emailinput+ " is in the array");
				} else {
					System.out.println("The email address: "+emailinput+" is not in the array");
				}
			} else if (emailinput.equals("LIST") || emailinput.equals("list") || emailinput.equals("List")) {
				getemaillist.GetEmailList();
				continue;
			} else {
				System.out.println(emailinput+" is not a valid email address");
			}

			System.out.println("\nWould you like to check another email?");
			System.out.println("Type Y for yes or type N to exit the program");
			while (true) {
				restart = input.nextLine();
				if (restart.equals("Y") || restart.equals("y")) {

					break;
				} else if (restart.equals("N") || restart.equals("n")) {

					break;
				}

				else {
					System.out.println("Invalid choice, please try again");

				}
			}

			if (restart.equals("Y") || restart.equals("y")) {

				continue;
			} else {
				System.out.println("Closing email validator...");
				break;
			}

		}

	}
}