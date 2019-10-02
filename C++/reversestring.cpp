/*
 * Example of string reversion using 
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <cstring>

using namespace std;

int main(int argc, char ** args) {
	
	if (argc != 2) {
		cout << "USAGE: <executable> \"<string to reverse>\". If you want "
		"quotes, use the \\ escape character before each of them" << endl;
		return 1;
	}

	else {
		cout << "Ok, let's reverse the " << args[1] << " string" << endl; 

		int n = strlen(args[1]);

		cout << "The size of the input is: " << n << endl; 

		char * pStart = args[1];
		char * pEnd = &args[1][n-1];

		return 0;
	}
}

