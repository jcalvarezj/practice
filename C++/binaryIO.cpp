/*
 * Basic example of read and write operations on binary files to store a struct
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <fstream>

#pragma pack(push, 1)

struct Person {
	char m_name[50];
	int m_age;
	double m_height;
};

#pragma pack(pop)

int main(int argc, char const *argv[])
{
	Person person1 = {
		"Pepe",
		20,
		1.55
	};

	std::ofstream output;
	output.open("person.dat", std::ios::binary);

	if(!output.is_open()) {
		std::cout << "Could not open file to write" << std::endl;
		return 1;
	}

	output.write(reinterpret_cast<char *>(&person1), sizeof(Person));
	output.close();

	Person person2;

	std::ifstream input;
	input.open("person.dat", std::ios::binary);

	if(!input.is_open()) {
		std::cout << "Could not open file to read" << std::endl;
		return 1;
	}

	input.read(reinterpret_cast<char *>(&person2), sizeof(Person));
	input.close();

	std::cout << "I have read: " << person2.m_name << " - " << person2.m_age <<
		" - " << person2.m_height << std::endl;

	return 0;
}

