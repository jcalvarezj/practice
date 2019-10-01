/*
 * Person class logic
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>
#include "Person.h"

using namespace std;

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

void Person::setId(int id) {
	this->id = id;
}

string Person::getName() {
	return name;
}

void Person::setName(string name) {
	this->name = name;
}

int Person::getAge() {
	return age;
}

void Person::setAge(int age) {
	this->age = age;
}
