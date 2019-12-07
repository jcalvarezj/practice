/*
 * Challenge #2 from Platzi's C course
 * I modified mchojrin's code for it to enable deletion of a node according to
 * user input
 * @author J. Alvarez and mchojrin from Platzi
 */

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int number;
	struct Node * next;
} NODE;

NODE * createNode( int number )
{
	NODE * newNode;

	newNode = malloc( sizeof(NODE) );
	newNode->next = NULL;
	newNode->number = number;

	return newNode;
}

NODE * deleteNode( NODE * list, int number ) {
	NODE * aux = list;

	if (aux->number == number) {
		list = aux->next;

		free(aux);
	}
	else {
		while(aux->next->number != number)
			aux = aux->next;

		NODE * toDelete = aux->next;

		aux->next = aux->next->next;

		free(toDelete);
	}

	return list;
}

int main( int argc, const char * arg[] )
{
	NODE * start = NULL, * current, *next;
	char goOn;
	int listSize = 0, number;

	do {
		printf( "La lista contiene %d nodos. Ingrese el siguiente numero (0 para finalizar)\n", listSize );
		scanf("%d", &number );
		if ( number ) {
			if ( !start ) {
				start = createNode( number );
				listSize++;
			} else {
				current = start;
				while ( current->next ) {
					current = current->next;
				}
				current->next = createNode( number );
				listSize++;
			}
			goOn = 1;
		} else {
			goOn = 0;
		}
	} while ( goOn );

	current = start;
	printf( "La lista contiene los numeros: \n" );
	while (current) {
		printf( "%d", current->number );
		printf( current->next ? ", " : "\n" );
		current = current->next;
	}

	int nodoABorrar;

	printf("Por favor ingrese el numero de nodo a borrar: ");
	scanf("%d",&nodoABorrar);


	printf("Vamos a borrar el nodo con numero %d\n",nodoABorrar);
	start = deleteNode(start,nodoABorrar);
	current = start;

	printf( "La lista queda asi: \n" );
	while (current) {
		printf( "%d", current->number );
		printf( current->next ? ", " : "\n" );
		current = current->next;
	}

	current = start;
	while (current) {
		next = current->next;
		free( current );
		current = next;
	}

	return 0;
}
