/*
 * Map Cell header file definition
 */

#ifndef MAP_CELL_H
#define MAP_CELL_H

class MapCell {
public:
	MapCell();
	char getId();
	void setId(char id);
private:
	char id;
};

#endif // MAP_CELL_H

