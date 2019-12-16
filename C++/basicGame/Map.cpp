/*
 * Map class logic implementation
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <fstream>
#include <string>
#include "Map.h"
#include "MapCell.h"
#include "Constants.h"

/*
 * Map constructor. Creates a new map and loads its cells from a file if
 * loadDefault parameter is true
 */
Map::Map(bool loadDefault) {
	playerCell = NULL;

	for(int i = 0; i < N_ENEMIES; i++)
		enemyCells[i] = NULL;

	if(loadDefault) {
		for(int i = 0; i < M; i++) {
			cells[0][i].setId(CELL_WALL);
			cells[N-1][i].setId(CELL_WALL);
		}

		for(int i = 0; i < N; i++) {
			cells[i][0].setId(CELL_WALL);
			cells[i][M-1].setId(CELL_WALL);
		}
	}
}

/*
 * Draws the map on the CLI
 */
void Map::drawMap() {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++)
			std::cout << cells[i][j].getId();
		std::cout << std::endl;
	}
}

/*
 * Updates the pointer of the character cell to the current character position
 * @param x The current x position of the character
 * @param y The current y position of the character
 * @return Boolean informing that a death collition occurred
 */
bool Map::setPlayerCell(int x, int y) {
	bool death = false;

	if(playerCell)
		playerCell->setId(CELL_EMPTY);

	playerCell = & cells[y][x];

	for(int i = 0; i < N_ENEMIES; i++) 
		if(playerEnemyCollision(i)) {
			playerCell->setId(CELL_DEATH);
			death = true;
		}

	if(!death)
		playerCell->setId(CELL_PLAYER);

	return death;
}

/*
 * Updates the pointer of the specified enemy cell to the enemy's current
 * position, and if it is the same as the player's, the player dies
 * @param id The id of the enemy
 * @param x The current x position of the specified enemy
 * @param y The current y position of the specified enemy
 * @return Boolean informing the game that a death collision occurred
 */
bool Map::setEnemyCell(int id, int x, int y) {
	bool death = false;

	if(enemyCells[id])
		enemyCells[id]->setId(CELL_EMPTY);

	enemyCells[id] = & cells[y][x];

	if(playerEnemyCollision(id)) {
		enemyCells[id]->setId(CELL_DEATH);
		death = true;
	}
	else
		enemyCells[id]->setId(CELL_ENEMY);

	return death;
}

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
void Map::loadMap(int level, int & playerX, int & playerY,
	   int (&enemiesX)[N_ENEMIES], int (&enemiesY)[N_ENEMIES]) {
	std::cout << "Loading map..." << std::endl; 

	std::ifstream inputFile(MAP_FILE);

	if(inputFile.is_open()) {
		std::string buffer = "";
		int currentLine = 0;
		int currentEnemy = 0;
		
		while(getline(inputFile, buffer)) {
			for(int k = 0; k < buffer.length(); k++) {
				if(buffer[k] == CELL_START) {
					playerX = k;
					playerY = currentLine;
				}
				else {
					if(buffer[k] == CELL_ENEMY) {
						enemiesX[currentEnemy] = k;
						enemiesY[currentEnemy] = currentLine;
						currentEnemy++;
					}
					cells[currentLine][k].setId(buffer[k]);
				}
			}

			currentLine++;
		}
	}
	else
		std::cout << "Could not open map in " << MAP_FILE <<
		   ". Probably an OS permission problem? Using default" << std::endl; 

	inputFile.close();
}

/*
 * Returns whether there is or not a collision between the player and an enemy
 * @param id The id of an enemy
 * @return boolean indicating whether there is a collision
 */
bool Map::playerEnemyCollision(int id) {
	return playerCell == enemyCells[id];
}
