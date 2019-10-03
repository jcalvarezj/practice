/*
 * Basic pointers example 
 *
 * @author J. Alvarez
 */
#include <iostream>

void modify(int * refVar);
void printArray(int * arr, int size);

int main(int argc, char ** args) {
	
	//
	// NORMAL VARIABLE EXAMPLE
	//
	
	int a = 3;
	int * pA = &a;

	std::cout << "The value of the address is " << pA << std::endl;
	std::cout << "The value in the address is " << * pA << std::endl;

	* pA = 888;
	
	std::cout << "New value by hand is " << a << std::endl;

	modify(&a);

	std::cout << "New value by method is " << a << std::endl;

	std::cout << "------------------------------------" << std::endl;

	//
	// ARRAY BASIC EXAMPLES
	//
	
	int X[] = {1,2,3,4,5,6};
	int * pNum = X;
	int n = sizeof(X)/sizeof(int);

	std::cout << "Before modifying array" << std::endl; 

	printArray(X,n);

	pNum[0] = 8;

	std::cout << "After modifying array" << std::endl; 

	printArray(X,n);

	std::cout << "If we print our pointer as array" << std::endl;

	printArray(pNum,n);

	pNum++;

	std::cout << "If we move our pointer" << std::endl; 

	printArray(pNum,n-1);

	std::cout << "So, the first position pNum[0] is " << pNum[0] << std::endl; 

	pNum = &X[3];
	
	std::cout << "Making the pointer point at the 4th position directly"
	   << std::endl;

	printArray(pNum,n-3);	
	std::cout << "------------------------------------" << std::endl;

	//
	// MOVING POINTER IN A STRUCTURE
	//
	
	int S[] = {1,2,3,4,5,6};

	int size = sizeof(S)/sizeof(int);

	int * pStart = S;
	int * pEnd = &S[size-1];

	do {
		std::cout << "Now at: " << * pStart << std::endl; 
		pStart++;
	} while (pStart != pEnd);

	std::cout << "Now at: " << * pStart << std::endl;

	//
	// AND BACKWARDS
	//

	pStart = S;

	do {
		std::cout << "Now at: " << * pEnd << std::endl;
		pEnd--;
	} while (pEnd != pStart);

	std::cout << "Now at: " << * pEnd << std::endl;

	return 0;
}

void modify(int * refVar) {
	* refVar = 8;
}

void printArray(int * arr, int size) {
	for (int i=0; i<size; i++)
		std::cout << " " << arr[i] << " ";
   	std::cout << std::endl;
}
