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
						insert(input);
						break;
					case 3:
						delete(input);
						break;
					case 4:
						update(input);
						break;
					case 5:
						System.out.println("Good bye!");
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
				switch (queryOption) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("-- Returning... --");
						finishedQuery = true;
						break;
				}
			}
			else
				System.out.println("INVALID OPTION!!"); 

		} while (!finishedQuery);
	}

	private static void insert(Scanner input) {
		// TODO
		System.out.println("WORK IN PROGRESS");
	}

	private static void delete(Scanner input) {
		// TODO
		System.out.println("WORK IN PROGRESS");
	}

	private static void update(Scanner input) {
		// TODO
		System.out.println("WORK IN PROGRESS");
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

