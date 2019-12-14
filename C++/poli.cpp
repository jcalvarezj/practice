/*
 * Basic polimorphism example
 *
 * @author J. Alvarez
 */
#include <iostream>

class A {
public:
	int num;

	A(int num): num(num){}

	virtual void doSomething() {};
};

class X: public A {
public:
	X(int num): A(num){}

	void doSomething() {
		std::cout << "XXXXXXXXXX " << num << std::endl;
	}
};

class Y: public A {
public:
	Y(int num): A(num){}

	void doSomething() {
		std::cout << "YYYYYYYYYY " << num << std::endl;
	}
};

int main(int argc, char ** args) {
	A * thing;

	X x(10);
	Y y(5);

	thing = &x;
	thing->doSomething();

	thing = &y;
	thing->doSomething();

	return 0;
}

