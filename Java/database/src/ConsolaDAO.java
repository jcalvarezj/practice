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

		try (Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				ResultSet result = preparedStatement.executeQuery();

				while(result.next()) {
					Consola consola = newConsola(result);
					consolas.add(consola);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consolas;
	}

	public ArrayList<Consola> getConsolaById(int id) {
		ArrayList<Consola> consolas = new ArrayList<>();

		String sql = "SELECT * FROM " + Configuration.TCONSOLAS +
			" WHERE " + Configuration.TCONSOLAS_ID + "=?;";

		try (Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setInt(1, id);
				
				ResultSet result = preparedStatement.executeQuery();

				while(result.next()) {
					Consola consola = newConsola(result);
					consolas.add(consola);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return consolas;
	}

	private Consola newConsola(ResultSet result) throws SQLException {
		return new Consola(
			Integer.parseInt(result.getString(Configuration.TCONSOLAS_ID)),
			result.getString(Configuration.TCONSOLAS_NAME),
			result.getString(Configuration.TCONSOLAS_FW)
		);
	}

}

