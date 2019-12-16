/*
 * Player class header file definition
 *
 * @author J. Alvarez
 */
#include <string>
#include "Map.h"
#include "MovingMapEntity.h"

#ifndef PLAYER_H
#define PLAYER_H

class Player: public MovingMapEntity {
public:
	Player(std::string name, Map * map);
	void getUserInput();
	bool isAlive();
	bool hasTreasure();
private:
	bool alive, treasureInHand;
	std::string name;
	bool canMoveToCell(int x, int y);
};

#endif /* PLAYER_H */

