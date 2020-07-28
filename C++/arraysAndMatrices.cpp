/*
 * Basic example of arrays and matrices
 *
 * @author J. Alvarez
 */
#include <iostream>
#define N 3

void printArray(int * arr, int tam) {
	std::cout << "The array is " << std::endl;

	for (int i=0; i<tam; i++) 
		std::cout << " " << arr[i] << " ";	

	std::cout << std::endl;
}

void printSquareMatrix(int mat[][N], int tam) {
	std::cout << "The matrix is " << std::endl;

	for (int i=0; i<tam; i++) {
		for (int j=0; j<tam; j++) 
			std::cout << " " << mat[i][j] << " "; 
		std::cout << std::endl;
	}
}


int main(int argc, char ** args) {
	int x[N] = {1, 2, 3};

	int A[][N] = { {1,2,3}, {4,5,6}, {7,8,9} };

	printArray(x, N);
	printSquareMatrix(A, N);

	return 0;
}


