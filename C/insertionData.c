/*
 * My implementation of insertion sort. (Requires file nums.dat with the dataset
 * of numbers separated by new line) 
 *
 * @author J. Alvarez
 */

#include <stdlib.h>
#include <stdio.h>

#define MAX_LENGTH 10

void printArray(int array[], int n) {
	int i;

	printf("\t\t");

	for(i=0; i<n; i++)
		printf(" %d ",array[i]);

	printf("\n");
}

void insertionSort(int array[], int n) {
	int i,j;
	for(i=1; i<n; i++) {		
		j=i;
		while(j>0 && array[j]<array[j-1]) {
			int aux = array[j];
			array[j] = array[j-1];
			array[j-1] = aux;
			j--;
		}
	}
}

int main(int argc, char ** args) {
	int size = 0, i = 0;

	char buffer[MAX_LENGTH];

	FILE * input = fopen("nums.dat","r");

	while(fgets(buffer,MAX_LENGTH,input))
		size++;
	
	int A[size];

	fseek(input, SEEK_SET, 0);

	while(fgets(buffer,MAX_LENGTH,input)) {
		A[i] = atoi(buffer);
		i++;
	}

	printf("\nThe array to sort is this one:\n");
	printArray(A,size);

	insertionSort(A,size);
	
	printf("\n-------------------------------------------------------------\n");
	printf("\nThe sorted array is this one:\n");

	printArray(A,size);

	fclose(input);

	return 0;
}

