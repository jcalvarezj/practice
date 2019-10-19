#include <stdio.h>

float potencia(float base, int exponente) {
	float resultado = 1;
	int i;

	if (exponente < 0) {
		for(i=0; i>exponente; i--) {
			resultado /= base;
		}
	}
	else {
		for(i=0; i<exponente; i++) {
			resultado *= base;
		}
	}

	return resultado;
}

int main() {
	float base;
	int exponente;
	printf("Ingresa la base: ");
	scanf("%f",&base);
	printf("Ingresa el exponente: ");
	scanf("%i",&exponente);

	float resultado = potencia(base,exponente);

	printf("El resultado es %f\n",resultado);

	return 0;
}

