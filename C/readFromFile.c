/*
 * Basic file read example
 * It obtains the file name (abs. or rel.) as an argument
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>

int main(int argc, char ** args) {
	if(argc != 2) {
		printf("Please include the file name as a program argument!!!!\n");
		return 1;
	}
	else {
		FILE * file = fopen(args[1], "r");
		
		if(!file) {
			printf("Sorry, can't work with that file...\n");
			return 0;
		}

		else {
			char c;

			c = fgetc(file);
			printf("The file contains:\n");

			while(c != EOF) {
				printf("%c",c);
				c = fgetc(file);
			}

			fclose(file);
			return 0;
		}
	}
}

