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
	/*
	 * Map constructor. Creates a new map and loads its cells from a file if
	 * loadDefault parameter is true
	 */
	Map(bool loadDefault);

	/*
	 * Draws the map on the CLI
	 */
	void drawMap();

	/*
	 * Updates the pointer of the character cell to the current character
	 * position
	 * @param x The current x position of the character
	 * @param y The current y position of the character
	 * @return Boolean informing that a death collition occurred
	 */
	bool setPlayerCell(int posX, int posY);

	/*
	 * Updates the pointer of the specified enemy cell to the enemy's current
	 * position, and if it is the same as the player's, the player dies
	 * @param id The id of the enemy
	 * @param x The current x position of the specified enemy
	 * @param y The current y position of the specified enemy
	 * @return Boolean informing the game that a death collision occurred
	 */
	bool setEnemyCell(int id, int x, int y);

	/*
	 * This method loads the map from the *.dat file specified in the MAP_FILE
	 * constant according to entered level. It updates the position variables for
	 * the game's player and enemies
	 * @param level Number of level
	 * @param playerX x position of the game's player
	 * @param playerY y position of the game's player
	 * @param enemiesX x positions of the game's enemies
	 * @param enemiesY y positions of the game's enemies
	 */
	void loadMap(int level, int & playerX, int & playerY,
	   int (&enemiesX)[N_ENEMIES], int (&enemiesY)[N_ENEMIES]);
	MapCell cells[N][M];
private:
	MapCell * playerCell;
	MapCell * enemyCells[N_ENEMIES];

	/*
	 * Returns whether there is or not a collision between the player and an
	 * enemy
	 * @param id The id of an enemy
	 * @return boolean indicating whether there is a collision
	 */
	bool playerEnemyCollision(int id);
};

#endif // MAP_H
