/*
 * Basic JDBC example. Not using packages best practice for making it quick
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DAO for the Consolas table of the database. Provides CRUD operations
 *
 * @author J. Alvarez
 */
public class ConsolaDAO implements IDBConnection {
	
	public ArrayList<Consola> getAllConsolas() {
		ArrayList<Consola> consolas = new ArrayList<>();

		String sql = "SELECT * FROM " + Configuration.TCONSOLAS + ";";

		try(Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				ResultSet result = preparedStatement.executeQuery();

				while(result.next()) {
					Consola consola = new Consola(
						Integer.parseInt(result.getString(Configuration.TCONSOLAS_ID)),
						result.getString(Configuration.TCONSOLAS_NAME),
						result.getString(Configuration.TCONSOLAS_FW)
					);

					consolas.add(consola);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return consolas;
	}

}

