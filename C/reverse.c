#include <stdio.h>
#include <string.h>

int main() {
	char text[50];
	printf("Enter the text to reverse:\n");
	gets(text);

	int N = strlen(text);
	char result[N];

	int i;

	for(i=0; i<N; i++)
		result[i] = text[N-i-1];

	printf("The reversed text is ");
	puts(result);
	printf("\n");

	return 0;
}

