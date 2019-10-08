/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>
#include "Person.h"
#include "People.h"

// using namespace reg; // This will make the default Person as the one in reg

int main(int argc, char ** args) {
	
	Person a("Jairo");
	a.speak();

	reg::Person b("Jose");
	b.speak();

	return 0;
}

