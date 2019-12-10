/*
 * My implementation of insertion sort 
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>

void printArray(int array[], int n) {
	int i;

	printf("\t\t");

	for(i=0; i<n; i++)
		printf(" %d ",array[i]);

	printf("\n");
}

void insertionSort(int array[], int n) {
	printf("The array starts like this:\n");
	printArray(array,n);

	int i,j;
	for(i=1; i<n; i++) {		
		j=i;
		while(j>0 && array[j]<array[j-1]) {
			int aux = array[j];
			array[j] = array[j-1];
			array[j-1] = aux;
			j--;
		}

		printf("On iteration %d the array is:\n", i);
		printArray(array,n);
	}
}

int main(int argc, char ** args) {
	int A[] = {10,9,8,7,6,5,4,3,2,1};
	int size = sizeof(A)/sizeof(int);

	insertionSort(A,size);
	
	printf("---------------------\n");

	printArray(A,size);

	return 0;
}

