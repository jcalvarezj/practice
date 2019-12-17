/*
 * Horizontal Enemy class header file definition
 *
 * @author J. Alvarez
 */
#include "Enemy.h"
#include "Map.h"

#ifndef HORIZONTAL_ENEMY_H
#define HORIZONTAL_ENEMY_H

class HorizontalEnemy: public Enemy {
public:
	HorizontalEnemy(int id, int x, int y, Map * map);
	void move();
private:
	int horizontalValue;
	int horizontalDirection;
	void moveRight();
	void moveLeft();
};

#endif // HORIZONTAL_ENEMY_H

