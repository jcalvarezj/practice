/*
 * Enemy class header file definition
 *
 * @author J. Alvarez
 */
#include "MovingMapEntity.h"
#include "Map.h"
#include <iostream>
#ifndef ENEMY_H
#define ENEMY_H

class Enemy: public MovingMapEntity {
public:
	/*
	 * Default constructor
	 */
	Enemy();

	/*
	 * Constructor for Enemy instances
	 * @param id The id of the enemy
	 * @param x The initial horizontal position of the enemy
	 * @param y The initial vertical position of the enemy
	 * @map Pointer to the game's map
	 */
	Enemy(int id, int x, int y, Map * map);

	/*
	 * Returns the enemy's id
	 */
	int getId();

	/*
	 * Moves the enemy to a new position (if it's a valid cell)
	 */
	virtual void move(){}
protected:
	int id;
};

#endif // ENEMY_H

