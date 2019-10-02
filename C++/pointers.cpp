/*
 * Basic pointers example 
 *
 * @author J. Alvarez
 */
#include <iostream>

using namespace std;

void modify(int * refVar);
void printArray(int * arr, int size);

int main(int argc, char ** args) {
	
	//
	// NORMAL VARIABLE EXAMPLE
	//
	
	int a = 3;
	int * pA = &a;

	cout << "The value of the address is " << pA << endl;
	cout << "The value in the address is " << * pA << endl;

	* pA = 888;
	
	cout << "New value by hand is " << a << endl;

	modify(&a);

	cout << "New value by method is " << a << endl;

	cout << "------------------------------------" << endl;

	//
	// ARRAY BASIC EXAMPLES
	//
	
	int X[] = {1,2,3,4,5,6};
	int * pNum = X;
	int n = sizeof(X)/sizeof(int);

	cout << "Before modifying array" << endl; 

	printArray(X,n);

	pNum[0] = 8;

	cout << "After modifying array" << endl; 

	printArray(X,n);

	cout << "If we print our pointer as array" << endl;

	printArray(pNum,n);

	pNum++;

	cout << "If we move our pointer" << endl; 

	printArray(pNum,n-1);

	cout << "So, the first position pNum[0] is " << pNum[0] << endl; 

	pNum = &X[3];
	
	cout << "Making the pointer point at the 4th position directly" << endl;

	printArray(pNum,n-3);	
	cout << "------------------------------------" << endl;

	//
	// MOVING POINTER IN A STRUCTURE
	//
	
	int S[] = {1,2,3,4,5,6};

	int size = sizeof(S)/sizeof(int);

	int * pStart = S;
	int * pEnd = &S[size-1];

	do {
		cout << "Now at: " << * pStart << endl; 
		pStart++;
	} while (pStart != pEnd);

	cout << "Now at: " << * pStart << endl;

	//
	// AND BACKWARDS
	//

	pStart = S;

	do {
		cout << "Now at: " << * pEnd << endl;
		pEnd--;
	} while (pEnd != pStart);

	cout << "Now at: " << * pEnd << endl;

	return 0;
}

void modify(int * refVar) {
	* refVar = 8;
}

void printArray(int * arr, int size) {
	for (int i=0; i<size; i++)
		cout << " " << arr[i] << " ";
   	cout << endl;
}
