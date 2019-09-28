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

	p.setAge(15);
	p.setName("NGH");
	p.setId(123456);

	cout << "TEST: " << p.getAge() << " " << p.getName() << " " << p.getId();
	cout << endl;

	return 0;
}

