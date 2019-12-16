/*
 * Enemy class source
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "MovingMapEntity.h"
#include "Map.h"

/*
 * Constructor for Enemy instances
 * @param id The id of the enemy
 * @param x The initial horizontal position of the enemy
 * @param y The initial vertical position of the enemy
 * @map Pointer to the game's map
 */
Enemy::Enemy(int id, int x, int y, Map * map): id(id), MovingMapEntity(x, y, 
		map) {
	srand(time(NULL));
}

/*
 * Returns the enemy's id
 */
int Enemy::getId() {
	return id;
}

/*
 * Moves the enemy to a new position (if it's a valid cell)
 */
void Enemy::move() {
	//TODO Implement on subclasses for different behaviors
	int direction = rand() % 4 + 1;

	switch(direction) {
		case MOVE_UP:
			if(canMoveToCell(x,y-1))
				y--;
			break;
		case MOVE_DOWN:
			if(canMoveToCell(x,y+1))
				y++;
			break;
		case MOVE_LEFT:
			if(canMoveToCell(x-1,y))
				x--;
			break;
		case MOVE_RIGHT:
			if(canMoveToCell(x+1,y))
				x++;
			break;
	}
}
