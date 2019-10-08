/*
 * Header file definition
 */

#ifndef PEOPLE_H
#define PEOPLE_H

#include <string>

namespace reg {
	class Person {
		public:
			Person();
			Person(std::string name): name(name){};
			void speak();
		private:
			std::string name;
	};
} /* namespace reg */

#endif /* PEOPLE_H */

