/*
 * Basic JDBC example. Not using packages best practice for making it quick
 *
 * @author J. Alvarez
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This interface provides functionality for connecting to a database through
 * the JDBC driver
 */
public interface IDBConnection {

	/**
	 * Creates and returns a {@code Connection} object with the attempted
	 * connection to the database
	 * @return The {@code Connection} instance with the session; null if failed
	 */
	default Connection connectToDatabase() {
		Connection connection = null;
		System.out.println("\nAttempting to connect to Database...");
		
		try {
				connection = DriverManager.getConnection(
					Configuration.URL + Configuration.DB,
					Configuration.USER, Configuration.PASSWORD
				);

			if(connection != null) {
				System.out.println("Successful connection!!");

			}
		}
		catch (Exception e) {
			System.out.println("Couldn't connect to Database");
			e.printStackTrace();
		}

		return connection;
	}

}

