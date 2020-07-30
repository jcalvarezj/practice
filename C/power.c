#include <stdio.h>

float power(float base, int exponent) {
	float result = 1;
	int i;

	if (exponent < 0) {
		for(i=0; i > exponent; i--) {
			result /= base;
		}
	}
	else {
		for(i=0; i < exponent; i++) {
			result *= base;
		}
	}

	return result;
}

int main() {
	float base;
	int exponent;
	printf("Enter the base: ");
	scanf("%f", &base);
	printf("Enter the exponent: ");
	scanf("%i", &exponent);

	float result = power(base, exponent);

	printf("The result is %f\n", result);

	return 0;
}

