/*
 * Header file definition
 */
#include <string>
#include "Map.h"

#ifndef PLAYER_H
#define PLAYER_H

class Player {
public:
	Player(std::string name, Map * map);
	void getUserInput();
	int getX();
	int getY();
	bool isAlive();
	bool hasTreasure();
private:
	int x,y;
	bool alive, treasureInHand;
	std::string name;
	Map * map;
	bool canMoveToCell(int x, int y);
};

#endif /* PLAYER_H */

