#include <stdio.h>

float cambio(char opcion) {
	float usdACop = 3426;
	float usd, cop;

	switch(opcion) {
		case 'c':
			printf("Ingresa la cantidad de COP: ");
			scanf("%f",&cop);

			usd = cop/usdACop;
			printf("Eso equivale a %f USD\n",usd);
			break;
		case 'u':
			printf("Ingresa la cantidad de USD: ");
			scanf("%f",&usd);

			cop = usd*usdACop;
			printf("Eso equivale a %f COP\n",cop);
			break;
	}
}

int main() {
	char opcion;
	printf("Elije el tipo de cambio:\n");
	printf("Para cambiar de COP a USD ingresa una c\n");
	printf("Para cambiar de USD a COP ingresa una u\n");

	scanf("%c",&opcion);

	cambio(opcion);
	
	return 0;
}

