#include <stdio.h>

int main() {
	int tam;
	printf("Ingresa el tamaño del arreglo: ");
	scanf("%i",&tam);

	int i = 0;
	int numeros[tam];
	
	int mayor;

	do {
		printf("Valor[%i]: ",i);
		scanf("%i",&numeros[i]);
		if(i == 0)
			mayor = numeros[i];
		else
			if (numeros[i] > mayor)
				mayor = numeros[i];
		i++;
	} while(i<tam);

	printf("El mayor es: %i\n",mayor);
	

	return 0;
}

