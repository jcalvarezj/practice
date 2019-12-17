/*
 * Random Enemy class header file definition
 *
 * @author J. Alvarez
 */
#include "Enemy.h"
#include "Map.h"

#ifndef RANDOM_ENEMY_H
#define RANDOM_ENEMY_H

class RandomEnemy: public Enemy {
public:
	RandomEnemy(int id, int x, int y, Map * map);
	void move();
};

#endif // RANDOM_ENEMY_H

