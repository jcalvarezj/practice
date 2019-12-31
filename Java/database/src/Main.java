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

		ConsolaDAO cDAO = new ConsolaDAO();

		do {
			System.out.println("Welcome. What do you want to do?");
			System.out.println("1. Query");
			System.out.println("2. Insertion");
			System.out.println("3. Deletion");
			System.out.println("4. Update");
			System.out.println("5. Quit");

			option = getIntegerInput(input);

			switch(option) {
				case 1:
					query(input, cDAO);
					break;
				case 2:
					insert(input, cDAO);
					break;
				case 3:
					delete(input, cDAO);
					break;
				case 4:
					update(input, cDAO);
					break;
				case 5:
					System.out.println("\nGood bye!");
					finished = true;
					break;
				default:
					System.out.println("\n-- INVALID OPTION!! --");
			}

		} while (!finished);

		input.close();
	}

	private static void query(Scanner input, ConsolaDAO cDAO) {
		int queryOption = 0;
		boolean finishedQuery = false;
		ArrayList<Consola> consolas = null;

		do {
			System.out.println("\nWhat to you want to search?");
			System.out.println("1. All Consolas");
			System.out.println("2. Consolas by id");
			System.out.println("3. Consolas by name");
			System.out.println("4. Go back");

			queryOption = getIntegerInput(input);

			switch (queryOption) {
				case 1:
					consolas = cDAO.getAllConsolas();
					break;
				case 2:
					System.out.println("Enter the desired id to find");
					int id = getIntegerInput(input);
					if(id > -1)
						consolas = cDAO.getConsolaById(id);
					break;
				case 3:
					input.nextLine();
					System.out.println("Enter the desired name to find");
					String name = input.nextLine();
					consolas = cDAO.getConsolaByName(name);
					break;
				case 4:
					System.out.println("\n-- Returning... --");
					finishedQuery = true;
					break;
				default:
					System.out.println("\n-- INVALID OPTION!! --"); 
					break;
			}

			if (consolas == null || consolas.isEmpty())
				System.out.println("\nSorry, there are no items");
			else
				System.out.println("\nThe Consolas are: " + consolas + "\n");

		} while (!finishedQuery);
	}

	private static void insert(Scanner input, ConsolaDAO cDAO) {
		// TODO
		System.out.println("WORK IN PROGRESS");
	}

	private static void delete(Scanner input, ConsolaDAO cDAO) {
		// TODO
		System.out.println("WORK IN PROGRESS");
	}

	private static void update(Scanner input, ConsolaDAO cDAO) {
		// TODO
		System.out.println("WORK IN PROGRESS");
	}

	private static int getIntegerInput(Scanner input) {
		int option = -1;

		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\n -- NUMBERS ONLY!! --");
			input.next();
		}
		
		return option;
	}

}
