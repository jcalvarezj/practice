/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include "People.h"
#include <iostream>

namespace reg {
	Person::Person() {

	}

	void Person::speak() {
		std::cout << "Nombre: " << name << std::endl; 
	}
}
