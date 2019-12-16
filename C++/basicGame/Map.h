/*
 * Map class header file definition
 *
 * @author J. Alvarez
 */
#include "MapCell.h"
#include "Constants.h"

#ifndef MAP_H
#define MAP_H

class Map {
public:
	Map(bool loadDefault);
	void drawMap();
	void setPlayerCell(int posX, int posY);
	void saveMap();
	void loadMap();
	MapCell cells[N][M];
private:
	MapCell * playerCell;
	MapCell * enemyCells[N_ENEMIES];
	bool playerEnemyCollision(int id);
};

#endif // MAP_H
