/*
 * Basic inheritance example 
 * Classes defined in this file to make it short (not following best practices)
 *
 * @author J. Alvarez
 */
#include <iostream>


class Animal {
	private:
		std::string name;
	public:
		void live() {
			std::cout << name << " living" << std::endl;
			eat();
		}

		void setName(std::string name) {
			this->name = name;
		}
	private:
		void eat() {
			std::cout << "I eat stuff" << std::endl;
		}
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
	c.setName("Louis");
	c.live();
	c.meow();

	Dog d;
	d.setName("Dudley");
	d.live();
	d.bark();

	return 0;
}

