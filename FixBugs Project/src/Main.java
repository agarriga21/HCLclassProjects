import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		/* System.out.println("Hello World!"); */
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");

		ArrayList<Integer> expenses = new ArrayList<Integer>();
		initExpenses(expenses);
		optionsSelection(expenses);

	}

	private static void optionsSelection(ArrayList<Integer> expenses) {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int slen = arr1.length;
		for (int i = 0; i < slen; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}

		System.out.println("\nEnter your choice:\t");
		sc = new Scanner(System.in);
		String options = sc.nextLine();

		switch (options) {
		case "1":
			System.out.println("Your saved expenses are listed below: \n");
			System.out.println(expenses + "\n");
			optionsSelection(expenses);
			break;
		case "2":
			System.out.println("Enter the value to add your Expense: \n");
			try {
				int value = sc.nextInt();
				expenses.add(value);
				System.out.println("Your value is updated\n");

				System.out.println(expenses + "\n");

			} catch (InputMismatchException e) {
				System.err.println("Not a valid integer, nothing was added.");

			}

			optionsSelection(expenses);
			break;
		case "3":
			System.out.println(
					"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
			String con_choice = sc.nextLine();
			if (con_choice.equals(options)) {
				expenses.clear();
				System.out.println(expenses + "\n");
				System.out.println("All your expenses are erased!\n");
			} else {
				System.err.println("Erasing cancelled\n");
			}
			optionsSelection(expenses);
			break;
		case "4":
			expenses = sortExpenses(expenses);
			System.out.println("Your sorted expenses are listed below: \n");
			System.out.println(expenses + "\n");
			optionsSelection(expenses);
			break;
		case "5":
			searchExpenses(expenses);
			optionsSelection(expenses);
			break;
		case "6":
			closeApp();
			break;
		default:
			System.err.println("You have made an invalid choice!\n");
			optionsSelection(expenses);
			break;
		}
	}

	private static ArrayList<Integer> initExpenses(ArrayList<Integer> expenses) {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		return expenses;
	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");

	}

	private static void searchExpenses(ArrayList<Integer> expenses) {
		 int leng = expenses.size();
		 int count =0;
		System.out.println("Enter the expense you need to search:\t");
		while(true) {
		try {
			int expenseSearch = sc.nextInt();
			if(leng==0) {
				System.out.println("Your expenditures list is empty. \n");
				break;
			}
			for(int i : expenses) {
				if(i == expenseSearch) {
					System.out.println(expenseSearch+" was found in your expenditures list.\n");
					break;
				}
				else if(count >= leng) {
					System.out.println(expenseSearch+" was not found in your expenditures list.\n");
					break;
				
				}
			}

			
break;
		} catch (InputMismatchException e) {
			System.err.println("Not a valid integer, try again.");
			sc.next();
		}
		}
		
	}

	private static ArrayList<Integer> sortExpenses(ArrayList<Integer> expenses) {
		int arrlength = expenses.size();
		int x = 0;

		for (int i = 0; i < arrlength - 1; i++) {
			x++;
			for (int j = i + 1; j < arrlength; j++) {
				x++;
				int right = expenses.get(j);
				int left = expenses.get(i);
				if (right < left) {
					expenses.set(i, right);
					expenses.set(j, left);
					x++;
				}

			}

		}

		return expenses;
	}
}
