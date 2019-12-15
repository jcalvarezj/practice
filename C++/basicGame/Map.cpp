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

Map::Map() {
	playerCell = NULL;
}

void Map::drawMap() {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++)
			std::cout << cells[i][j].getId();
		std::cout << std::endl;
	}
}

void Map::setPlayerCell(int posX, int posY) {
	if(playerCell)
		playerCell->setId(CELL_EMPTY);

	playerCell = &cells[posY][posX];
	playerCell->setId(CELL_ICON);
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
		std::cout << "Could not open map in " << SAVE_FILE << std::endl; 
	
	saveFile.close();
}

void Map::loadMap() {
	std::ifstream inputFile(SAVE_FILE);

	if(inputFile.is_open()) {
		std::string buffer = "";
		int currentLine = 0;
		
		while(getline(inputFile, buffer)) {
			for(int k = 0; k < buffer.length(); k++)
				cells[currentLine][k].setId(buffer[k]);

			currentLine++;
		}
	}
	else
		std::cout << "Could not open map in " << SAVE_FILE << std::endl; 
	
	inputFile.close();
}
