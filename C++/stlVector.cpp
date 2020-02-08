/*
 * Basic STL vector example
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <vector>

int main(int argc, char const *argv[])
{
	std::vector<std::string> people;
	people.push_back("lola");
	people.push_back("lalo");
	people.push_back("lelo");
	people.push_back("lala");
	people.push_back("lolo");

	std::cout << "Normal for:" << std::endl; 

	for (int i = 0; i < people.size(); i++)
		std::cout << (i+1) << " - " << people[i] << std::endl;

	std::cout << std::endl; 

	std::cout << "Iterator for" << std::endl; 

	for (std::vector<std::string>::iterator it = people.begin();
			it != people.end(); it++)
		std::cout << * it << std::endl;
	
	std::cout << std::endl;

	std::cout << "And backwards:" << std::endl;

	for (std::vector<std::string>::iterator it = people.end();
			it != people.begin(); it--) {
		std::vector<std::string>::iterator current = it - 1;
		std::cout << * current << std::endl;
	}

	return 0;
}

