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
private:
	int x,y;
	bool alive;
	std::string name;
	Map * map;
	bool canMoveToCell(int x, int y);
};

#endif /* PLAYER_H */

