/*
 * Vertical Enemy class header file definition
 *
 * @author J. Alvarez
 */
#include "Enemy.h"
#include "Map.h"

#ifndef VERTICAL_ENEMY_H
#define VERTICAL_ENEMY_H

class VerticalEnemy: public Enemy {
public:
	/*
	 * VerticalEnemy constructor
	 * @see Enemy
	 */
	VerticalEnemy(int id, int x, int y, Map * map);

	/*
	 * @see Enemy
	 */
	void move();
private:
	int verticalValue;
	int verticalDirection;

	/*
	 * Moves the enemy down
	 */
	void moveDown();

	/*
	 * Moves the enemy up
	 */
	void moveUp();
};

#endif // VERTICAL_ENEMY_H

