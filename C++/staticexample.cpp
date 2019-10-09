/*
 * Basic static members example. Classes included in this file to make it short
 * (not following best practice of separating them)
 * @author J. Alvarez
 */
#include <iostream>
#include <sstream>

class Thing {
	public:
		static const int MAX = 888;
		static int id;

	public:
		Thing() {
			id++;
		}

		void showId() {
			std::cout << "This instance's id is " << id << std::endl;
		}

		static void tellId() {
			std::cout << "Current id: " << id << std::endl;
		}
};

int Thing::id;

int main(int argc, char ** args) {	
	Thing::id = Thing::MAX;

	Thing a;
	a.showId();

	Thing b;
	b.showId();

	Thing::tellId();

	return 0;
}

