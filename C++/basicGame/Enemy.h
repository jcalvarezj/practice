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
	Enemy(int id, Map * map);
	int getId();
private:
	int id;
	void move();
};

#endif // ENEMY_H

