/*
 * Basic JDBC example. Not using packages best practice for making it quick
 *
 * @author J. Alvarez
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DAO for the Consolas table of the database. Provides CRUD operations
 *
 * Implements {@link IDBConnection} as it connects with the database for the
 * CRUD operations
 */
public class ConsolaDAO implements IDBConnection {
	
	/**
	 * Retrieves all the Consolas in the database
	 * @return An {@code ArrayList} of {@code Consola}
	 */
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

	/**
	 * Retrieves the Consola in the database with the specified id
	 * @param id The id to find
	 * @return An {@code ArrayList} of {@code Consola}
	 */
	public ArrayList<Consola> getConsolaById(int id) {
		ArrayList<Consola> consolas = new ArrayList<>();

		String sql = "SELECT * FROM " + Configuration.TCONSOLAS +
			" WHERE " + Configuration.TCONSOLAS_ID + " = ?;";

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

	/**
	 * Retrieves the Consolas in the database with a name containing the
	 * specified string
	 * @param name The string to find in the Consola's name
	 * @return An {@code ArrayList} of {@code Consola}
	 */
	public ArrayList<Consola> getConsolasByName(String name) {
		ArrayList<Consola> consolas = new ArrayList<>();

		String sql = "SELECT * FROM " + Configuration.TCONSOLAS +
			" WHERE " + Configuration.TCONSOLAS_NAME + " LIKE UPPER(?);";

		try (Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, "%"+name+"%");
				
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

	/**
	 * Inserts a new Consola record using the parameters
	 * @param name The name
	 * @param firmware The firmware
	 * @return boolean indicating success of operation
	 */
	public boolean insertConsola(String name, String firmware) {
		String sql = "INSERT INTO " + Configuration.TCONSOLAS +
		   "(" + Configuration.TCONSOLAS_NAME + ", " + 
		   Configuration.TCONSOLAS_FW + ")" + " VALUES (?,?)";

		int result = 0;

		try (Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, name);
				preparedStatement.setString(2, firmware);

				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result > 0;
	}

	/**
	 * Deletes the Consola by the specified id
	 * @param id The id
	 * @return boolean indicating success of operation
	 */
	public boolean deleteConsolaById(int id) {
		int result = 0;

		String sql = "DELETE FROM " + Configuration.TCONSOLAS +
			" WHERE " + Configuration.TCONSOLAS_ID + " = ?";

		try (Connection connection = connectToDatabase()) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result > 0;
	}

	/**
	 * Updates the Consola by id, setting all its fields
	 * @param id The id
	 * @param name The name
	 * @param firmware The firmware
	 * @return boolean indicating success of operation
	 */
	public boolean updateConsolaById(int id, String name, String firmware) {
		int result = 0;
		String sql = "UPDATE " + Configuration.TCONSOLAS +
			" SET " + Configuration.TCONSOLAS_NAME + " = ?, " +
			Configuration.TCONSOLAS_FW + " = ?" +
			" WHERE " + Configuration.TCONSOLAS_ID + " = ?";

		try (Connection connection = connectToDatabase()) {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.setString(1, name);
				preparedStatement.setString(2, firmware);
				preparedStatement.setInt(3, id);

				result = preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result > 0;
	}

	/**
	 * Creates a new {@code Consola} object from the Result Set on its current
	 * pointed record
	 * @param result The Result Set
	 * @return The created {@code Consola} object
	 */
	private Consola newConsola(ResultSet result) throws SQLException {
		return new Consola(
			Integer.parseInt(result.getString(Configuration.TCONSOLAS_ID)),
			result.getString(Configuration.TCONSOLAS_NAME),
			result.getString(Configuration.TCONSOLAS_FW)
		);
	}

}

