import java.util.ArrayList;

/**
 * Este programa resuelve el problema de las líneas de ensamblaje empleando
 * programación dinámica. 
 *
 * Problema: Se tienen dos lineas de ensamblaje, cada una con estaciones en
 * que se añaden o ajustan partes del producto final. En cada estación el
 * proceso se demora un determinado tiempo, y hay una demora extra si se quiere
 * cambiar de línea de ensamblaje; además, el ingreso a las líneas tiene un
 * tiempo distinto, al igual que la salida a la entrega del producto. Se requiere
 * de un algoritmo que ensamble un carro empleando el menor tiempo posible, y
 * con una complejidad de tiempo de ejecución óptima 
 *
 * Componentes del problema:
 *
 * 		T(x,y) el tiempo óptimo para x = numero línea; y = numero de estación
 * 		S(x,y) el valor del tiempo que toma ensamblar en la estación y de la línea x
 * 		P(x,y) el tiempo que toma pasar de la linea x a la y
 * 		e(x) el tiempo de entrada a la línea x
 * 		s(x) el tiempo de salida de la línea x
 *
 * @author J. Alvarez
 */
public class EnsamblajeProgDinamica {

	public static void main(String[] args) {
		int N = 3;  // Cantidad de estaciones intermedias
		int[][] tiempos = { {5, 1, 1}, {3, 3, 1} };  // Tiempos por línea de ensamblaje (línea: fila; tiempo: columna)
		int[] entradas = {1,1}; // Tiempo extra por entrar a una línea
		int[] salidas = {1,1}; // Tiempo extra por salir de una línea al camión
		int paso[] = {1,2}; // Tiempo que se tarda en pasar de una línea a otra

		int[][] optimizacion = resolverEstaciones(tiempos, entradas, salidas, paso);
		ArrayList<String> solucion = obtenerCamino(optimizacion);
		System.out.println("La solución al problema es: " + solucion);
		System.out.println("Porque la estructura quedó:");

		for (int i=0; i<2; i++) {
			for (int j=0; j<optimizacion[0].length; j++) {
				System.out.print(" "+optimizacion[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

	/*
		Este es el método que resuelve el problema mediante programación dinámica
	*/
	public static int[][] resolverEstaciones(int[][] tiempos, int[] entradas, int[] salidas, int[] paso) {
		int N = tiempos[0].length+1;		// Una columna de más para el manejo de las salidas
		int[][] tiemposOptimos = new int[2][N];

		// Soluciones triviales
		// T(1,1) = e(1) + S(1,1)
		// T(2,1) = e(2) + S(2,1)
		tiemposOptimos[0][0] = entradas[0] + tiempos[0][0];
		tiemposOptimos[1][0] = entradas[1] + tiempos[1][0];


		// Generalizacion de la optimizacion (hasta uno antes del tamaño completo; las salidas se manejan aparte)
		// T(1,N) = min{ T(1,N-1) + S(1,N) , T(2,N-1) + P(2,1) + S(1,N) }
		// T(2,N) = min{ T(2,N-1) + S(2,N) , T(1,N-1) + P(1,2) + S(2,N) }
		for (int i=1; i<N-1; i++) {
			tiemposOptimos[0][i] = Math.min(tiemposOptimos[0][i-1] + tiempos[0][i], tiemposOptimos[1][i-1] + paso[0] + tiempos[0][i]);
			tiemposOptimos[1][i] = Math.min(tiemposOptimos[1][i-1] + tiempos[1][i], tiemposOptimos[0][i-1] + paso[1] + tiempos[1][i]);
		}

		// Manejo del problema final de las salidas
		tiemposOptimos[0][N-1] = tiemposOptimos[0][N-2] + salidas[0];
		tiemposOptimos[1][N-1] = tiemposOptimos[1][N-2] + salidas[1];

		return tiemposOptimos;
	}

	public static ArrayList<String> obtenerCamino(int[][] estructura) {
		ArrayList<String> camino = new ArrayList<String>();

		for (int i=0; i<estructura[0].length; i++)
			if (estructura[0][i] < estructura[1][i])
				camino.add(str(0,i));
			else
				camino.add(str(1,i));

		return camino;
	}

	public static String str(int a, int b) {
		return "("+a+","+b+")";
	}

}