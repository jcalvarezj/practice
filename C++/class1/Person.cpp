/*
 * Person class logic
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>
#include "Person.h"

using namespace std;

Person::Person() {

}

Person::Person(int nId, string nName, int nAge) {
	id = nId;
	name = nName;
	age = nAge;
}

Person::~Person() {
	cout << "Person of id " << id << " has been destroyed" << endl;
}

string Person::toString() {
	stringstream ss;
	ss << id << " - " << name << " - " << age;
	return ss.str();
}

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
