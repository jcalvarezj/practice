/*
 * Example of string reversion using pointers
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <cstring>

int main(int argc, char ** args) {
	
	if (argc != 2) {
		std::cout << "USAGE: <executable> \"<string to reverse>\". If you want "
			"quotes, use the \\ escape character before each of them"
			<< std::endl;
		return 1;
	}

	else {
		std::cout << "Ok, let's reverse the " << args[1] << " string"
		   << std::endl; 

		int n = strlen(args[1]);

		std::cout << "The size of the input is: " << n << std::endl; 

		char * pStart = args[1];
		char * pEnd = &args[1][n-1];

		while(pStart < pEnd) {
			char aux = * pStart;
			* pStart = * pEnd;
			* pEnd = aux;
			pStart++;
			pEnd--;
		}

		std::cout << "The result is: " << args[1] << std::endl;

		return 0;
	}
}

