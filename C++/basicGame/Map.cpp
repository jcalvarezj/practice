/*
 * Map class logic implementation
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include "Map.h"
#include "MapCell.h"
#include "Constants.h"

Map::Map() {
	playerCell = NULL;

	for(int i = 0; i < N_ENEMIES; i++)
		enemyCells[i] = NULL;
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

bool Map::loadMap(int level, int & playerX, int & playerY,
	   int (&enemiesX)[N_ENEMIES], int (&enemiesY)[N_ENEMIES]) {
	bool loadOk = false;

	std::stringstream ss;
	ss << MAP_FILE << level << ".dat";
	std::string fileName = ss.str();

	std::cout << "Loading map... " << fileName << std::endl;

	std::ifstream inputFile(fileName.c_str());

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

		loadOk = true;
	}
	else
		std::cout << "Could not open map file " << fileName << std::endl; 

	inputFile.close();

	return loadOk;
}

bool Map::playerEnemyCollision(int id) {
	return playerCell == enemyCells[id];
}
