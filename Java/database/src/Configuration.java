/*
 * Basic JDBC example. Not using packages best practice for making it quick
 *
 * @author J. Alvarez
 */

/**
 * Class containing constants for the connection with the database and table
 * information
 */
public class Configuration {

	// DATABASE CONNECTION
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB = "games_tournament";
	public static final String USER = "games_tournament";
	public static final String PASSWORD = "games_tournament";

	// TABLE INFORMATION
	public static final String TCONSOLAS = "consolas";
	public static final String TCONSOLAS_ID = "consola_id";
	public static final String TCONSOLAS_NAME = "nombre";
	public static final String TCONSOLAS_FW = "firmware";


}

