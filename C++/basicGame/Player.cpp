/*
 * Player class source
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <string>
#include "Player.h"
#include "Constants.h"

Player::Player(std::string name, Map * map): name(name), map(map) {
	x = 1;
	y = 1;
	alive = true;
	treasureInHand = false;
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

	if(map->cells[y][x].getId() == '$')
		treasureInHand = true;

	std::cout << "Hero is now at " << x << ", " << y << std::endl;
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

bool Player::hasTreasure() {
	return treasureInHand;
}

