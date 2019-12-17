/*
 * Vertical Enemy source
 *
 * @author J. Alvarez
 */
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "VerticalEnemy.h"
#include "MovingMapEntity.h"
#include "Map.h"

VerticalEnemy::VerticalEnemy(int id, int x, int y, Map * map): Enemy(id, x, y, 
		map) {
	verticalValue = 0;
	verticalDirection = 1;
}

void VerticalEnemy::move() {
	if(verticalValue == ENEMY_VERTICAL_MOVES)
		verticalDirection = -1;
	if(verticalValue == 0)
		verticalDirection = 1;

	if(verticalDirection == -1)
		VerticalEnemy::moveUp();
	else
		VerticalEnemy::moveDown();

	verticalValue += verticalDirection;
}

void VerticalEnemy::moveDown() {
	if(MovingMapEntity::canMoveToCell(x, y+1, false))
		y++;
}

void VerticalEnemy::moveUp() {
	if(MovingMapEntity::canMoveToCell(x, y-1, false))
		y--;
}
