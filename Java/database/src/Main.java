/*
 * Basic JDBC example. Not using packages best practice for making it quick
 *
 * @author J. Alvarez
 */

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Application entry point and main program
 */
public class Main {

	/**
	 * Entry method for the program
	 * @param args Array of {@code String} containing program arguments
	 */
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

	/**
	 * Shows the query submenu and attempts to perform a query using the
	 * corresponding DAO and user input
	 *
	 * @param input The currently used {@code Scanner} for user input
	 * @param cDAO The ConsolaDAO for requesting CRUD operations
	 */
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
					consolas = cDAO.getConsolasByName(name);
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

	/**
	 * Shows the insert submenu and attempts to perform an insertion using the
	 * corresponding DAO and user input
	 *
	 * @param input The currently used {@code Scanner} for user input
	 * @param cDAO The ConsolaDAO for requesting CRUD operations
	 */
	private static void insert(Scanner input, ConsolaDAO cDAO) {
		boolean correct = true;
		String name = "";
		String firmware = "";

		do {
			input.nextLine();
			System.out.println("Please enter the Consola's name");
			name = input.nextLine();

			if (name.equals("")) {
				System.out.println("Please try again. Empty name not allowed");
				correct = false;
			}
			else
				correct = true;

		} while (!correct);

		do{
			System.out.println("Please enter the Consola's firmware");
			firmware = input.nextLine();

			if (firmware.equals("")) {
				System.out.println("Please try again. Firmware can't be empty");
				correct = false;
			}
			else
				correct = true;

		} while (!correct);

		boolean insertion = cDAO.insertConsola(name, firmware);

		if (insertion)
			System.out.println("\nSaved successfully!\n");
		else
			System.out.println("\nSorry, could not save.\n");
	}

	/**
	 * Shows the delete submenu and attempts to perform a deletion using the
	 * corresponding DAO and user input
	 *
	 * @param input The currently used {@code Scanner} for user input
	 * @param cDAO The ConsolaDAO for requesting CRUD operations
	 */
	private static void delete(Scanner input, ConsolaDAO cDAO) {
		System.out.println("Enter the id to delete");

		int id = getIntegerInput(input);

		if (id > 0) {
			boolean deletion = cDAO.deleteConsolaById(id);

			if (deletion)
				System.out.println("\nDeleted successfully!\n");
			else
				System.out.println("\nSorry, could not delete.\n");
		}
	}

	/**
	 * Shows the insert submenu and attempts to perform an update using the
	 * corresponding DAO and user input
	 *
	 * @param input The currently used {@code Scanner} for user input
	 * @param cDAO The ConsolaDAO for requesting CRUD operations
	 */
	private static void update(Scanner input, ConsolaDAO cDAO) {
		System.out.println("Enter the id to update");
		
		int id = getIntegerInput(input);
		String name = "";
		String firmware = "";
		boolean correct = true;

		do {
			input.nextLine();
			System.out.println("Please enter the Consola's name");
			name = input.nextLine();

			if (name.equals("")) {
				System.out.println("Please try again. Empty name not allowed");
				correct = false;
			}
			else
				correct = true;

		} while (!correct);

		do{
			System.out.println("Please enter the Consola's firmware");
			firmware = input.nextLine();

			if (firmware.equals("")) {
				System.out.println("Please try again. Firmware can't be empty");
				correct = false;
			}
			else
				correct = true;

		} while (!correct);

		if (id > 0) {
			boolean update = cDAO.updateConsolaById(id, name, firmware);

			if (update)
				System.out.println("\nUpdated successfully!\n");
			else
				System.out.println("\nSorry, could not update.\n");
		}
	}

	/**
	 * Retrieves numbers for user input and shows a message if the input is not
	 * a number
	 *
	 * @param input The currently used {@code Scanner} for user input
	 * @return -1 if input is incorrect, the input otherwise
	 */
	private static int getIntegerInput(Scanner input) {
		int number = -1;

		try {
			number = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\n -- NUMBERS ONLY!! --");
			input.next();
		}
		
		return number;
	}

}

