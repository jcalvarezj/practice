/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>

using namespace std;


void imprimeArreglo(int * arr, int tam) {
	for (int i=0; i<tam; i++) 
		cout << " " << arr[i] << " ";	

	cout << endl;
}

void imprimeMatrizCuadrada(int * mat[], int tam) {
	for (int i=0; i<tam; i++) {
		for (int j=0; j<tam; j++) 
			cout << " " << mat[i][j] << " "; 
		cout << endl;
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


