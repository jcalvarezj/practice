/*
 * MovingMapEntity source
 *
 * @author J. Alvarez
 */
#include "MovingMapEntity.h"

MovingMapEntity::MovingMapEntity(Map * map): map(map){}

int MovingMapEntity::getX() {
	return x;
}

int MovingMapEntity::getY() {
	return y;
}

bool MovingMapEntity::canMoveToCell(int x, int y) {
	return map->cells[y][x].getId() != CELL_WALL && x >= 0 && x < M && 
		y >= 0 && y < N;
}
