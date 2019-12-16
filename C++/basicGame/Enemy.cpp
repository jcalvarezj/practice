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

Enemy::Enemy(Map * map): MovingMapEntity(map) {
	srand(time(NULL));
}

void Enemy::move() {
	int direction = rand() % 4 + 1;
	std::cout << "Enemy " << id << " direction: " << direction << std::endl;
}
