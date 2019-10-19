#include <stdio.h>

int main() {
	float notas[5][6] = {
		{10,6,8,8,9,0},
		{6,6.5,7,7.5,8,0},
		{8,8,9,9,10,0},
		{9,8,7,6,7,0},
		{9,9.5,10,8.5,9,0}
	};

	int i,j;

	for(i=0; i<5; i++) {
		for(j=0; j<5; j++)
			notas[i][5] += notas[i][j];
		notas[i][5] /= 5;
		printf("El promedio de la fila %i es %f\n",i,notas[i][5]);
	}

	return 0;
}

