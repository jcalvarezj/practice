/*
 * Basic example of polymorphic array (array of pointers)
 *
 * @author J. Alvarez
 */
#include <iostream>

struct Cosa {
	int a = 8;
};

struct Tipo: Cosa {
};

int main(int argc, char const *argv[])
{
	Cosa * * cosas = new Cosa * [8];

	for(int i=0; i<8; i++)
		cosas[i] = new Tipo;

	std::cout << "" << cosas[0]->a << std::endl; 
	
	for(int i=0; i<8; i++)
		delete cosas[i];

	delete [] cosas;
	
	return 0;
}

