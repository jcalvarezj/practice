/*
 * Map header file definition
 */
#include "MapCell.h"
#include "Constants.h"

#ifndef MAP_H
#define MAP_H

class Map {
public:
	Map();
	void drawMap();
	void setPlayerCell(int posX, int posY);
	void saveMap();
	void loadMap();
private:
	MapCell cells[N][M];
	MapCell * playerCell;
};

#endif // MAP_H
