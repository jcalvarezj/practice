/*
 * Basic example of polymorphic array (array of pointers)
 *
 * @author J. Alvarez
 */
#include <iostream>

struct Thing {
	int value;
	Thing(int value): value(value) {}
};

struct SubThing: Thing {
	SubThing(int value): Thing(value) {}
};

int main(int argc, char const *argv[])
{
	Thing * * things = new Thing * [8];

	for(int i=0; i<8; i++)
		things[i] = new SubThing(i);

	for(int i=0; i<8; i++)
		std::cout << "" << things[i]->value << std::endl;
	
	for(int i=0; i<8; i++)
		delete things[i];

	delete [] things;
	
	return 0;
}

