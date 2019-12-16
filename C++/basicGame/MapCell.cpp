/*
 * Source file of Map Cell class
 */

#include "MapCell.h"
#include "Constants.h"

/*
 * Constructor for Map Cells. By default sets their id as CELL_EMPTY
 */
MapCell::MapCell() {
	id = CELL_EMPTY;
}

/*
 * Returns the id of the Map Cell
 * @return The id of the cell
 */
char MapCell::getId() {
	return id;
}

/*
 * Sets the id of the cell to a new value
 * @param id The new id
 */
void MapCell::setId(char id) {
	this->id = id;
}
