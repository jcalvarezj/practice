/*
 * This is an example of how to return objects in methods and some ways to
 * instantiate objects of a type. Short example, so the class is defined in this
 * file (not following best practices of separate files).
 *
 * Based on John Purcell's examples (www.caveofprogramming.com)
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>

const int NANIMALS = 3; // Remember modifying createAnimals() when changing it

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

Animal * createAnimals() {
	Animal * animals = new Animal[NANIMALS];
	animals[0].setName("Bird");
	animals[1].setName("Lizard");
	animals[2].setName("Wombat");
	return animals;
}

void printArray(Animal array[], int n) {
	std::cout << "There are " << n << " animals:" << std::endl;

	for(int i=0; i<n; i++) {
		std::cout << "Animal at " << i << " is " << array[i].getName() << std::endl;
	}
}

int main(int argc, char ** args) {
	
	Animal * a = new Animal("Pepe");
	a->speak();

	Animal b = * a;

	delete a;

	Animal * c = createAnimal();
	c->speak();
	delete c;

	Animal * d = createAnimals();

	printArray(d,NANIMALS);

	delete [] d;

	return 0;
}

