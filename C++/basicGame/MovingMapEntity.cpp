/*
 * MovingMapEntity source
 *
 * @author J. Alvarez
 */
#include "Map.h"
#include "MovingMapEntity.h"
#include <iostream>
MovingMapEntity::MovingMapEntity(int x, int y, Map * map): x(x), y(y), map(map){
}

int MovingMapEntity::getX() {
	return x;
}

int MovingMapEntity::getY() {
	return y;
}

bool MovingMapEntity::canMoveToCell(int x, int y, bool isPlayer) {
	char cellId = map->cells[y][x].getId();
	if(isPlayer)
		return cellId != CELL_WALL && x >= 0 && x < M && y >= 0 && y < N;
	else
		return cellId != CELL_WALL && cellId != CELL_TREASURE && x >= 0 && x < M
			&& y >= 0 && y < N;
}
