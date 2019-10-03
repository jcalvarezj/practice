/*
 * Basic string concatenation example using stringstream
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>

int main(int argc, char ** args) {
	
	std::string name = "Pepe";

	int age = 55;

	std::stringstream ss;

	ss << name << " is " <<  age << " years old";

	std::cout << ss.str() << std::endl;

	return 0;
}

