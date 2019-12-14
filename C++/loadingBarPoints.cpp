/*
 * Loading bar with points example
 * @author J. Alvarez
 */
#include <iostream>
#include <unistd.h>

using namespace std;

int main(int argc, char ** args) {
	
	// Code goes here

	cout << "[";
	cout.flush();

	for (int i=0; i<10; i++) {
		usleep(1000000);
		cout << ".";
		cout.flush();
	}

	cout << "]" << endl;

	return 0;
}

