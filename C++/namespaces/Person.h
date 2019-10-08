/*
 * Header file definition
 */

#ifndef PERSON_H
#define PERSON_H

#include <string>

class Person {
	public:
		Person();
		Person(std::string name): name(name) {};
		void speak();
	private:
		std::string name;
};

#endif /* PERSON_H */
