/*
 * Person class logic
 *
 * @author J. Alvarez
 */
#include <iostream>
#include "Person.h"

using namespace std;

int Person::getId() {
	return id;	
}

void Person::setId(int nId) {
	id = nId;
}

string getName() {
	return name;
}

void setName(string nName) {
	name = nName;
}

int getAge() {
	return age;
}

void setAge(int nAge) {
	age = nAge;
}
