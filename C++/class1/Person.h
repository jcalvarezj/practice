/*
 * Person class Header file definition
 */

#ifndef PERSON_H 
#define PERSON_H

using namespace std;

class Person {
	private:
		int id;
	private:
		string name;
	private:
		int age;
	public:
		int getId();
		void setId(int nId);
		string getName();
		void setName(string nName);
		int getAge();
		void setAge(int nAge);
};

#endif /* PERSON_H */

