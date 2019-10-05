/*
 * This is an example of how to return objects in methods. Short example, so the
 * class is defined in this file (not following best practices).
 *
 * Based on John Purcell's examples (www.caveofprogramming.com)
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>

class Animal {
	private:
		std::string name;
	public:
		Animal(): name("Give me a name") {};

		Animal(std::string name): name(name) {};

		Animal(const Animal & other) {
			std::stringstream ss;

			ss << other.name << "_COPY";
			name = ss.str();

			std::cout << name << " has been copied!!!!" << std::endl;
		}

		~Animal() {
			std::cout << name << " has been destroyed :(" << std::endl;
		}

		void speak() {
			std::cout << "My name is " << name << std::endl;
		}

		std::string getName() {
			return name;
		}

		void setName(std::string name) {
			this->name = name;
		}
};

Animal * createAnimal() {
	Animal * aNew = new Animal("Epep");
	return aNew;
}

int main(int argc, char ** args) {
	
	Animal * a = new Animal("Pepe");

	a->speak();

	Animal b = * a;

	delete a;

	Animal * c = createAnimal();

	c->speak();

	delete c;

	return 0;
}

