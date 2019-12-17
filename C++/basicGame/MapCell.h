/*
 * Map Cell header file definition
 *
 * @author J. Alvarez
 */

#ifndef MAP_CELL_H
#define MAP_CELL_H

class MapCell {
public:

	/*
	 * Constructor for Map Cells. By default sets their id as CELL_EMPTY
	 */
	MapCell();

	/*
	 * Returns the id of the Map Cell
	 * @return The id of the cell
	 */
	char getId();

	/*
	 * Sets the id of the cell to a new value
	 * @param id The new id
	 */
	void setId(char id);
private:
	char id;
};

#endif // MAP_CELL_H

