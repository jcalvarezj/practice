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

Enemy::Enemy(int id, Map * map): id(id), MovingMapEntity(map) {
	srand(time(NULL));
}

int Enemy::getId() {
	return id;
}

void Enemy::move() {
	//TODO Implement on subclasses for different behaviors
	int direction = rand() % 4 + 1;
	std::cout << "Enemy " << id << " direction: " << direction << std::endl;
}
