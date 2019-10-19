#include <stdio.h>

int main() {
	char texto[50];
	printf("Ingresa el texto a invertir:\n");
	gets(texto);

	int tam = strlen(texto);
	char respuesta[tam];

	int i;

	for(i=0; i<tam; i++)
		respuesta[i] = texto[tam-i-1];

	printf("El texto invertido es: ");
	puts(respuesta);
	printf("\n");

	return 0;
}

