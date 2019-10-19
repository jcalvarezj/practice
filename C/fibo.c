#include <stdio.h>

int main() {
	int vuelta;
	printf("Ingresa el numero de vuelta a calcular de fibonacci: ");
	scanf("%i",&vuelta);

	int fn_1 = 1;
	int fn_2 = 0;
	int fn = 0;

	int i;

	for(i=1; i<=vuelta; i++) {
		fn = fn_1 + fn_2;
		
		printf("%i ",fn);

		fn_2 = fn_1;
		fn_1 = fn;
	} 
	printf("\n");

	return 0;
}

