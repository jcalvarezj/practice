/*
 * // Description goes here
 *
 * @author J. Alvarez
 */

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ConsolaDAO cdao = new ConsolaDAO();

		ArrayList<Consola> consolas = cdao.getAllConsolas();

		//System.out.println(""+connection);

	}

}

