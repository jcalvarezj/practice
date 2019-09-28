/*
 * First Object Oriented Example 
 *
 * @author J. Alvarez
 */
#include <iostream>
#include "Person.h"

using namespace std;

int main(int argc, char ** args) {
	
	Person p;

	p.setAge(25);
	p.setName("Andre");
	p.setId(123456);

	cout << "p: " << p.toString();
	cout << endl;

	{
		Person q(30,"James",80008);

		cout << "q: " << q.toString();
		cout << endl;
	}

	cout << "(Instance scope just happened)" << endl;

	cout << "Program finishing..." << endl;

	return 0;
}

