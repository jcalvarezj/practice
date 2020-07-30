#include <stdio.h>

int main() {
	int N;
	printf("Enter the size of the array: ");
	scanf("%i",&N);

	int i = 0;
	int numeros[N];
	
	int mayor;

	do {
		printf("Value[%i]: ",i);
		scanf("%i",&numeros[i]);
		if(i == 0)
			mayor = numeros[i];
		else
			if (numeros[i] > mayor)
				mayor = numeros[i];
		i++;
	} while(i<N);

	printf("The maximum is %i\n",mayor);	

	return 0;
}

