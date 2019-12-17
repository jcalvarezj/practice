/*
 * Random Enemy source
 *
 * @author J. Alvarez
 */
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "RandomEnemy.h"
#include "MovingMapEntity.h"
#include "Map.h"

RandomEnemy::RandomEnemy(int id, int x, int y, Map * map): Enemy(id, x, y, 
		map) {}

void RandomEnemy::move() {
	int direction = rand() % 4;

	switch(direction) {
		case MOVE_UP:
			if(MovingMapEntity::canMoveToCell(x, y-1, false))
				y--;
			break;
		case MOVE_DOWN:
			if(MovingMapEntity::canMoveToCell(x, y+1, false))
				y++;
			break;
		case MOVE_LEFT:
			if(MovingMapEntity::canMoveToCell(x-1, y, false))
				x--;
			break;
		case MOVE_RIGHT:
			if(MovingMapEntity::canMoveToCell(x+1, y, false))
				x++;
			break;
	}
}
