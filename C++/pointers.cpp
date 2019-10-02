/*
 * Basic pointers example 
 *
 * @author J. Alvarez
 */
#include <iostream>

using namespace std;

void modify(int * refVar);

int main(int argc, char ** args) {
	
	int a = 3;

	int * pA = &a;

	cout << "The value of the address is " << pA << endl;

	cout << "The value in the address is " << * pA << endl;

	* pA = 888;
	
	cout << "New value by hand is " << a << endl;

	modify(&a);

	cout << "New value by method is " << a << endl;

	return 0;
}

void modify(int * refVar){
	* refVar = 8;
}
