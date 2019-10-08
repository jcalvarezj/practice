/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include "Person.h"
#include <iostream>

Person::Person() {

}

void Person::speak() {
	std::cout << "MY NAME IS " << name << std::endl; 
}
