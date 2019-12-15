/*
 * // Description goes here
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <string>
#include "Player.h"
#include "Constants.h"

Player::Player(std::string name, Map * map): name(name), map(map) {
	x = M/2;
	y = N/2;
	alive = true;
}

void Player::getUserInput() {
	char userInput = '0';
	std::cin >> userInput;

	switch(toupper(userInput)) {
		case LEFT:
			if(Player::canMoveToCell(x-1,y))
				x--;
			break;
		case RIGHT:
			if(Player::canMoveToCell(x+1,y))
				x++;
			break;
		case UP:
			if(Player::canMoveToCell(x,y-1))
				y--;
			break;
		case DOWN:
			if(Player::canMoveToCell(x,y+1))
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


bool Player::canMoveToCell(int x, int y) {
	return map->cells[y][x].getId() != CELL_WALL && x >= 0 && x < M && 
		y >= 0 && y < N;
}
