/*
 * // Description goes here
 *
 * @author J. Alvarez
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {

		boolean finished = false;
		int option = 0;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("Welcome. What do you want to do?");
			System.out.println("1. Query");
			System.out.println("2. Insertion");
			System.out.println("3. Deletion");
			System.out.println("4. Update");
			System.out.println("5. Quit");

			option = getOption(input);

			if (option > 0 && option < 6) {
				System.out.println("You chose: " + option);
				
				switch(option) {
					case 1:
						query(input);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						finished = true;
						break;
				}
			}
			else
				System.out.println("INVALID OPTION!!");
	/*
			ConsolaDAO cdao = new ConsolaDAO();

			ArrayList<Consola> consolas = cdao.getAllConsolas();

			System.out.println("The consolas are: " + consolas);*/

		} while (!finished);


		input.close();
	}

	private static void query(Scanner input) {
		int queryOption = 0;
		boolean finishedQuery = false;

		do {
			System.out.println("What to you want to search?");
			System.out.println("1. All Consolas");
			System.out.println("2. Consolas by id");
			System.out.println("3. Consolas by name");
			System.out.println("4. Go back");

			queryOption = getOption(input);

			if (queryOption > 0 && queryOption < 5) {
				System.out.println("Now you selected " + queryOption);
				if(queryOption == 4)
					finishedQuery = true;
			}
			else
				System.out.println("INVALID OPTION!!"); 

		} while (!finishedQuery);
	}

	private static int getOption(Scanner input) {
		int option = -1;

		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("NUMBERS ONLY!!");
			input.next();
		}
		
		return option;
	}

}

