/*
 * Horizontal Enemy source
 *
 * @author J. Alvarez
 */
#include <stdlib.h>
#include <time.h>
#include "Enemy.h"
#include "HorizontalEnemy.h"
#include "MovingMapEntity.h"
#include "Map.h"

HorizontalEnemy::HorizontalEnemy(int id, int x, int y, Map * map): Enemy(id, x, y, 
		map) {
	horizontalValue = 0;
	horizontalDirection = 1;
}

void HorizontalEnemy::move() {
	if(horizontalValue == ENEMY_HORIZONTAL_MOVES)
		horizontalDirection = -1;
	if(horizontalValue == 0)
		horizontalDirection = 1;

	if(horizontalDirection == -1)
		HorizontalEnemy::moveLeft();
	else
		HorizontalEnemy::moveRight();

	horizontalValue += horizontalDirection;
}

void HorizontalEnemy::moveRight() {
	if(MovingMapEntity::canMoveToCell(x+1, y, false))
		x++;
}

void HorizontalEnemy::moveLeft() {
	if(MovingMapEntity::canMoveToCell(x-1, y, false))
		x--;
}
