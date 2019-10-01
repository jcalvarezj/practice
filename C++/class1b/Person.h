/*
 * Person class Header file definition
 */

#ifndef PERSON_H 
#define PERSON_H

using namespace std;

class Person {
	private:
		int id;
		string name;
		int age;
	public:
		Person() {};
		~Person();
		Person(int id, string name, int age): id(id), name(name), age(age) {};

		string toString();

		int getId();
		void setId(int nId);
		string getName();
		void setName(string nName);
		int getAge();
		void setAge(int nAge);
};

#endif /* PERSON_H */

