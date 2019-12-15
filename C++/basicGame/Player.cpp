/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <string>
#include "Player.h"
#include "Constants.h"

Player::Player(std::string name): name(name) {
	x = 0;
	y = 0;
	alive = true;
}

void Player::getUserInput() {
	char userInput = '0';
	std::cin >> userInput;

	switch(toupper(userInput)) {
		case LEFT:
			x--;
			break;
		case RIGHT:
			x++;
			break;
		case UP:
			y--;
			break;
		case DOWN:
			y++;
			break;
		case DIE:
			alive = false;
			break;
	}

	std::cout << "Hero at " << x << ", " << y << std::endl;
}

int Player::getX() {
	return x;
}

int Player::getY() {
	return y;
}

bool Player::isAlive() {
	return alive;
}
