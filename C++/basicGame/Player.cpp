/*
 * Player class source
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <string>
#include "Player.h"
#include "Map.h"
#include "MovingMapEntity.h"
#include "Constants.h"

Player::Player(std::string name, Map * map): name(name), MovingMapEntity(map) {
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
			if(MovingMapEntity::canMoveToCell(x-1,y))
				x--;
			break;
		case RIGHT:
			if(MovingMapEntity::canMoveToCell(x+1,y))
				x++;
			break;
		case UP:
			if(MovingMapEntity::canMoveToCell(x,y-1))
				y--;
			break;
		case DOWN:
			if(MovingMapEntity::canMoveToCell(x,y+1))
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

bool Player::isAlive() {
	return alive;
}

bool Player::hasTreasure() {
	return treasureInHand;
}

