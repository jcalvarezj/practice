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

void Map::drawMap() {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++)
			std::cout << cells[i][j].getId();
		std::cout << std::endl;
	}
}

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

bool Map::playerEnemyCollision(int id) {
	return playerCell == enemyCells[id];
}
