/*
 * This is an example of structs, typedef, and a simple list using dynamic
 * memory allocation
 *
 * @author J. Alvarez
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 50

typedef char String[MAX_SIZE];

typedef struct {
	String name;
	int age;
	String email;
} Contact;

void read(char * buf) {
	scanf("%49s",buf);
}

void showList(Contact * contacts, int n) {
	printf("This is your contact list:\n");
	printf("Name\t\tAge\t\tEmail\n");

	int i;

	for(i=0; i<n; i++)
		printf("%s\t\t%d\t\t%s\n",contacts[i].name, contacts[i].age,
			   	contacts[i].email);
	
}

int main() {
	int stop = 0;
	char buffer[MAX_SIZE];

	Contact * list = NULL;
	int listSize = 0;

	do {
		printf("Please enter the new contact's name, or 0 to exit:\n");

		read(buffer);

		if(strcmp("0",buffer) != 0) {
			
			if(!list)
				list = malloc(sizeof(Contact));

			else 
				list = realloc(list,sizeof(Contact) * (listSize + 1));
			
			strcpy(list[listSize].name, buffer);

			printf("Please enter the contact's age:\n");
			read(buffer);
			list[listSize].age = atoi(buffer);

			printf("Please enter the contact's email:\n");
			read(buffer);
			strcpy(list[listSize].email, buffer);

			listSize++;

			printf("\n------------------Saved--------------------\n\n");

		}

		else
			stop = 1;

	} while(!stop);

	showList(list, listSize);
	
	printf("Program finished. Cleaning memory\n\n");

	free(list);

	return 0;
}

