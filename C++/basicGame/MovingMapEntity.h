/*
 * MovingMapEntity class header file definition
 *
 * @author J. Alvarez
 */
#include "Map.h"

#ifndef MOVING_MAP_ENTITY_H
#define MOVING_MAP_ENTITY_H

class MovingMapEntity {
public:
	MovingMapEntity(int x, int y, Map * map);
	int getX();
	int getY();
protected:
	int x, y;
	Map * map;
	bool canMoveToCell(int x, int y);
};

#endif // MOVING_MAP_ENTITY_H

