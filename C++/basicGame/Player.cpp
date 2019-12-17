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

Player::Player(std::string name, int x, int y, Map * map): name(name),
	MovingMapEntity(x, y, map) {
	alive = true;
	treasureInHand = false;
}

void Player::getUserInput() {
	char userInput = '0';
	std::cin >> userInput;

	switch(toupper(userInput)) {
		case LEFT:
			if(MovingMapEntity::canMoveToCell(x-1, y, true))
				x--;
			break;
		case RIGHT:
			if(MovingMapEntity::canMoveToCell(x+1, y, true))
				x++;
			break;
		case UP:
			if(MovingMapEntity::canMoveToCell(x, y-1, true))
				y--;
			break;
		case DOWN:
			if(MovingMapEntity::canMoveToCell(x, y+1, true))
				y++;
			break;
		case DIE:
			alive = false;
			break;
	}

	if(map->cells[y][x].getId() == CELL_TREASURE)
		treasureInHand = true;
}

bool Player::isAlive() {
	return alive;
}

void Player::die() {
	alive = false;
}

bool Player::hasTreasure() {
	return treasureInHand;
}

