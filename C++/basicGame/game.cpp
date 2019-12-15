/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>
#include "Player.h"

int main(int argc, char ** args) {
	Player hero("Pepe");
	bool gameOver = false;

	std::cout << "Game start" << std::endl;

	while(!gameOver) {
		hero.getUserInput();
	}

	return 0;
}

