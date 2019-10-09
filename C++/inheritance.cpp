/*
 * Basic inheritance example 
 * Classes defined in this file to make it short (not following best practices)
 *
 * @author J. Alvarez
 */
#include <iostream>


class Animal {
	public:
		void live() {
			std::cout << name << " living" << std::endl;
		}

		void setName(std::string name) {
			this->name = name;
		}
	private:
		std::string name;
};

class Cat: public Animal {
	public:
		void meow() {
			std::cout << "MEOW!" << std::endl;
		}
};

class Dog: public Animal {
	public:
		void bark() {
			std::cout << "WOOF!" << std::endl;
		}
};

int main(int argc, char ** args) {
	Cat c;
	c.live();
	c.meow();

	Dog d;
	d.live();
	d.bark();

	return 0;
}

