/*
 * Source file of Map Cell class
 *
 * @author J. Alvarez
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
