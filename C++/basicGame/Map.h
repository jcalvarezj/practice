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
	bool setPlayerCell(int posX, int posY);
	bool setEnemyCell(int id, int x, int y);
	void saveMap();
	void loadMap(int level, int & playerX, int & playerY,
	   int (&enemiesX)[N_ENEMIES], int (&enemiesY)[N_ENEMIES]);
	MapCell cells[N][M];
private:
	MapCell * playerCell;
	MapCell * enemyCells[N_ENEMIES];
	bool playerEnemyCollision(int id);
};

#endif // MAP_H
