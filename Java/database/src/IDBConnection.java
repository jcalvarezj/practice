/*
 * Basic JDBC example. Not using packages best practice for making it quick
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This interface provides functionality for connecting to a database through
 * the JDBC driver
 *
 * @author J. Alvarez
 */
public interface IDBConnection {

	default Connection connectToDatabase() {
		Connection connection = null;
		System.out.println("Attempting to connect to Database...");
		
		try {
				connection = DriverManager.getConnection(
					Configuration.URL + Configuration.DB,
					Configuration.USER, Configuration.PASSWORD
				);

			if(connection != null) {
				System.out.println("Conexión exitosa!!!");

			}
		}
		catch (Exception e) {
			System.out.println("Couldn't connect to Database");
			e.printStackTrace();
		}

		return connection;
	}

}

