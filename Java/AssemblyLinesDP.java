/**
 * This program solver the assembly lines problem using dynamic programming
 *
 * Problem: We have two vehicle assembly lines, each one with stations where
 * parts of the final product are added or adjusted
 *
 * In each station the process takes a determined time, and there is an extra delay
 * when switching from one line to the other (time delay passing between stations of
 * the same line is not assumed). Besides, entry and exit to and from each line have
 * all different delay times.
 *
 * An efficient algotithm is required to assemble a car using the shortest time possible
 *
 * Components of the problem:
 *
 * 		T(x,y) optimal time for x = line number; y = station number
 * 		S(x,y) time that takes assmebling at station y from line x
 * 		P(x) time that takes passing to line x
 * 		e(x) entry time to line x
 * 		s(x) exit time from line x
 *
 * @author J. Alvarez
 */
import java.util.Arrays;

/**
 *	This class solves the problem of assembly lines and runs the program
 */
public class AssemblyLinesDP {

	/**
	 *	Entry point of the program
	 *	@param args Argumentos del sistema
	 */
	public static void main(String[] args) {
		int N = 3;  // Number of stations
		int[][] stationTimes = { {5, 1, 1}, {3, 3, 1} };  // T[x][y]: Times per assembly line (x: line; y: station)
		int[] entryTimes = {1,1}; // e[x]: Extra time that takes entering line x
		int[] exitTimes = {1,1}; // s[x]: Extra time that takes exiting line x
		int[] switchTimes = {1,2}; // P[x]: Time that takes switching to line x

		System.out.println("The problem will be solved for the stations with times:\n");
		System.out.println("Upper line: " + Arrays.toString(stationTimes[0]));
		System.out.println("Lower line: " + Arrays.toString(stationTimes[1]));
		System.out.println("entryTimes a superior e inferior:" + Arrays.toString(entryTimes));
		System.out.println("exitTimes a superior e inferior:" + Arrays.toString(exitTimes));
		System.out.println("switchTimes a superior e inferior:" + Arrays.toString(switchTimes));

		int[][] optimalResults = solveStations(stationTimes, entryTimes, exitTimes, switchTimes);  // Optimal results structure
		String[] result = getSolutionPath(optimalResults); // Solution to the problem

		System.out.println("\nThe solution to the problem is " + Arrays.toString(result));
		System.out.println("Because we have this optimal results structure:");

		for (int i=0; i<2; i++) {
			for (int j=0; j<optimalResults[0].length; j++)
				System.out.print(" "+optimalResults[i][j]+" ");

			System.out.print("\n");
		}
	}

	/**
	 *	This method solves the problem using dynammic programming
	 *	@param stationTimes S(x, y)
	 *	@param entryTimes e(x)
	 *	@param exitTimes s(x)
	 *	@param switchTimes P(x)
	 *	@return Integer matrix with the optimal solutions of time for each station
	 */
	public static int[][] solveStations(int[][] stationTimes, int[] entryTimes, int[] exitTimes, int[] switchTimes) {
		int N = stationTimes[0].length + 1;		// With one extra column to include exit times
		int[][] optimalTimes = new int[2][N];

		// Basic problems (indices adequated to the implementation)
		// T(1,1) = e(1) + S(1,1)
		// T(2,1) = e(2) + S(2,1)
		optimalTimes[0][0] = entryTimes[0] + stationTimes[0][0];
		optimalTimes[1][0] = entryTimes[1] + stationTimes[1][0];


		// Generalizing the optimization (up to the penultimate position; exit times are handled apart)
		// T(1,N) = min{ T(1,N-1) + S(1,N) , T(2,N-1) + P(2,1) + S(1,N) }
		// T(2,N) = min{ T(2,N-1) + S(2,N) , T(1,N-1) + P(1,2) + S(2,N) }
		for (int i=1; i<N-1; i++) {
			optimalTimes[0][i] = Math.min(optimalTimes[0][i-1] + stationTimes[0][i], optimalTimes[1][i-1] + switchTimes[0] + stationTimes[0][i]);
			optimalTimes[1][i] = Math.min(optimalTimes[1][i-1] + stationTimes[1][i], optimalTimes[0][i-1] + switchTimes[1] + stationTimes[1][i]);
		}

		// Handling the final exit times problem
		optimalTimes[0][N-1] = optimalTimes[0][N-2] + exitTimes[0];
		optimalTimes[1][N-1] = optimalTimes[1][N-2] + exitTimes[1];

		return optimalTimes;
	}

	/**
	 *	Obtains the solution to the problem as a traversal of stations according to the
	 *	optimal solutions structure
	 *	@param structure The optimal solutions structure
	 *	@return Traversal denoted as a list of Strings of ({line}, {station}) pairs of indices
	 */
	public static String[] getSolutionPath(int[][] structure) {
		String[] path = new String[structure[0].length];

		for (int i=0; i<structure[0].length; i++)
			if (structure[0][i] < structure[1][i])
				path[i] = str(0,i);
			else
				path[i] = str(1,i);

		return path;
	}

	/**
	 *	Returna a String with the ({a}, {b}) format
	 *	@param a First value
	 *	@param b Second value
	 *	@return String with the ({a}, {b}) format
	 */
	public static String str(int a, int b) {
		return "("+a+","+b+")";
	}

}