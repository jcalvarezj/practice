/*
 * Basic string concatenation example using stringstream
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>

using namespace std;

int main(int argc, char ** args) {
	
	string name = "Pepe";

	int age = 55;

	stringstream ss;

	ss << name << " is " <<  age << " years old";

	cout << ss.str() << endl;

	return 0;
}

