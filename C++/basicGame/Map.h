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
	MapCell cells[N][M];
private:
	MapCell * playerCell;
};

#endif // MAP_H
