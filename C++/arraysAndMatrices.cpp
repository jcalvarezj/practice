/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>

void imprimeArreglo(int * arr, int tam) {
	for (int i=0; i<tam; i++) 
		std::cout << " " << arr[i] << " ";	

	std::cout << std::endl;
}

void imprimeMatrizCuadrada(int mat[][3], int tam) {
	for (int i=0; i<tam; i++) {
		for (int j=0; j<tam; j++) 
			std::cout << " " << mat[i][j] << " "; 
		std::cout << std::endl;
	}
}


int main(int argc, char ** args) {
	
	int n = 3;

	int x[3] = {1, 2, 3};

	int A[][3] = { {1,1,1}, {1,1,1}, {1,1,1} };

	imprimeArreglo(x,n);
	imprimeMatrizCuadrada(A,n);

	return 0;
}


