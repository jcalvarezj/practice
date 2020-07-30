#include <stdio.h>

int main() {
	float grades[5][6] = {
		{10,6,8,8,9,0},
		{6,6.5,7,7.5,8,0},
		{8,8,9,9,10,0},
		{9,8,7,6,7,0},
		{9,9.5,10,8.5,9,0}
	};

	int i,j;

	for(i=0; i<5; i++) {
		for(j=0; j<5; j++)
			grades[i][5] += grades[i][j];
		grades[i][5] /= 5;
		printf("The average for row %i is %f\n",i,grades[i][5]);
	}

	return 0;
}

