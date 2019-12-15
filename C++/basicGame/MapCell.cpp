/*
 * Logic of Map Cell class
 */

#include "MapCell.h"
#include "Constants.h"

MapCell::MapCell() {
	id = CELL_EMPTY;
}

char MapCell::getId() {
	return id;
}

void MapCell::setId(char id) {
	this->id = id;
}
