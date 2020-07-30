/*
 * Basic program that helps the user convert between currencies (COP and USD)
 */
#include <stdio.h>

float convert(char option) {
	float usdACop = 3426;
	float usd, cop;

	switch(option) {
		case 'c':
			printf("Enter the COP quantity: ");
			scanf("%f", &cop);

			usd = cop/usdACop;
			printf("That is equivalent to %f USD\n", usd);
			break;
		case 'u':
			printf("Enter the USD quantity: ");
			scanf("%f", &usd);

			cop = usd*usdACop;
			printf("That is equivalent to %f COP\n", cop);
			break;
	}
}

int main() {
	char option;
	printf("Choose the type of conversion:\n");
	printf("COP to USD: c\n");
	printf("USD a COP: u\n");

	scanf("%c", &option);

	convert(option);
	
	return 0;
}