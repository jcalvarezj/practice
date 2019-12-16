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

void Map::setPlayerCell(int x, int y) {
	if(playerCell)
		playerCell->setId(CELL_EMPTY);

	playerCell = & cells[y][x];
	playerCell->setId(CELL_PLAYER);
}

void setEnemyCell(int id, int x, int y) {
	if(enemyCell[id])
		enemyCell[id]->setId(CELL_EMPTY);

	enemyCell[id] = & cells[y][x];

	if(playerEnemyCollision(id))
		enemyCell[id]->setId(CELL_DEATH);
	else
		enemyCell[id]->setId(CELL_ENEMY);
}

void Map::saveMap() {
	std::ofstream saveFile(SAVE_FILE);

	if(saveFile.is_open()) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				saveFile << cells[i][j].getId();
			saveFile << std::endl;
		}
	}
	else
		std::cout << "Could not save map in " << SAVE_FILE 
			". Probably an OS permission problem?" << std::endl; 
	
	saveFile.close();
}

void Map::loadMap() {
	std::cout << "Loading map..." << std::endl; 

	std::ifstream inputFile(SAVE_FILE);

	if(inputFile.is_open()) {
		std::string buffer = "";
		int currentLine = 0;
		
		while(getline(inputFile, buffer)) {
			for(int k = 0; k < buffer.length(); k++)
				if(buffer[k] != CELL_PLAYER)
					cells[currentLine][k].setId(buffer[k]);

			currentLine++;
		}
	}
	else
		std::cout << "Could not open map in " << SAVE_FILE <<
		   ". Probably an OS permission problem? Using default" << std::endl; 

	inputFile.close();
}

bool Map::playerEnemyCollision(int id) {
	return playerCell == enemyCells[id];
}
