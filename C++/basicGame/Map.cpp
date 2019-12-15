/*
 * Map class logic implementation
 *
 * @author J. Alvarez
 */
#include <iostream>
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
