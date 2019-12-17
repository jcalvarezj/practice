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

Enemy::Enemy(): MovingMapEntity(0,0,NULL) {}

Enemy::Enemy(int id, int x, int y, Map * map): id(id), MovingMapEntity(x, y, 
		map) {
	srand(time(NULL));
}

int Enemy::getId() {
	return id;
}

