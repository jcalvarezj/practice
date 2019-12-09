/*
 * Basic file writing exercise. Writes on out.txt user prompted input
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char ** args) {
	FILE * file = fopen("out.txt", "w");

	if(!file) {
		printf("Sorry, I can't write on that file\n");
		return 1;
	}

	else {
		char buffer[101];
		int stop = 0;

		do {
			printf("Please write something less than 100 characters long\n");
			scanf("%100s",buffer);

			fputs(buffer,file);
			fputs("\n",file);

			printf("Saved. Anything else? (y/n): ");
			scanf("%1s",buffer);

			if(strcmp("n",buffer) == 0)
				stop = 1;

		} while (!stop);

		return 0;
	}

	fclose(file);
}

