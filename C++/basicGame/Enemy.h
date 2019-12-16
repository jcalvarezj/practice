/*
 * Enemy class header file definition
 *
 * @author J. Alvarez
 */
#include "MovingMapEntity.h"
#include "Map.h"

#ifndef ENEMY_H
#define ENEMY_H

class Enemy: public MovingMapEntity {
public:
	Enemy(int id, int x, int y, Map * map);
	int getId();
	void move();
private:
	int id;
};

#endif // ENEMY_H

