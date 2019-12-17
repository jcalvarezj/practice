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
	/*
	 * HorizontalEnemy constructor
	 * @see Enemy
	 */
	HorizontalEnemy(int id, int x, int y, Map * map);

	/*
	 * @see Enemy
	 */
	void move();
private:
	int horizontalValue;
	int horizontalDirection;

	/*
	 * Moves the enemy to the right
	 */
	void moveRight();

	/*
	 * Moves the enemy to the left
	 */
	void moveLeft();
};

#endif // HORIZONTAL_ENEMY_H

