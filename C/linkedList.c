/*
 * Basic Linked List example
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>

typedef struct Node {
	int number;
	struct Node * next;
} Node;


Node * createNode(int number) {
	Node * newNode = malloc(sizeof(Node));

	newNode->number = number;
	newNode->next = NULL;

	return newNode;
}

Node * addToList(Node * list, Node * node) {
	if(!list)
		list = node;
	else {
		Node * aux = list;

		while(aux->next)
			aux = aux->next;

		aux->next = node;
	}

	return list;
}

void showList(Node * list) {
	Node * aux = list;
	
	if(!aux) {
		printf("The list is empty!!\n");
	}
	else {
		printf("The list contains:\n");

		while(aux->next) {
			printf(" %d ",aux->number);
			aux = aux->next;
		}
		
		printf(" %d ", aux->number);
	}

	printf("\n");

}

void freeMemory(Node * list) {
	if(list) {

		while(list->next) {
			Node * aux = list;
			list = aux->next;
			free(aux);
		}

		free(list);
	}
}

int main(int argc, char ** args) {
	
	Node * list = NULL;
	
	int stop = 0;
	int listSize = 0;
	char buffer[6];
	
	do {
		printf("\nThe list currently has %d nodes\n", listSize);

		printf("Enter a number (integer up to 5 digits) to add to the list,");
		printf(" or x to exit\n");
		
		scanf("%5s", buffer);

		if(strcmp("x",buffer) != 0) {
			Node * n = createNode(atoi(buffer));
			list = addToList(list,n);

			printf("\nThe number has been added to the list\n");
			listSize++;
		}
		else {
			stop = 1;

			showList(list);			
		}

	} while(!stop);


	printf("\nProgram finished. Cleaning up memory\n");

	freeMemory(list);

	return 0;
}


