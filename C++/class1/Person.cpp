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

string Person::getName() {
	return name;
}

void Person::setName(string nName) {
	name = nName;
}

int Person::getAge() {
	return age;
}

void Person::setAge(int nAge) {
	age = nAge;
}
