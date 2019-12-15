/*
 * This is a basic example of a 2D CLI game using Object Oriented Programming
 *
 * @author J. Alvarez
 */
#include <iostream>
#include "Player.h"
#include "Map.h"

int main(int argc, char ** args) {
	bool gameOver = false;
	Map map;
	Player hero("Pepe",& map);

	std::cout << "Loading map..." << std::endl; 

	map.loadMap();

	std::cout << "Game start" << std::endl;

	map.setPlayerCell(hero.getX(), hero.getY());
	map.drawMap();

	while(!gameOver) {
		hero.getUserInput();
		map.setPlayerCell(hero.getX(), hero.getY());
		map.drawMap();
		gameOver = !hero.isAlive();
	}

	std::cout << "-- GAME OVER --" << std::endl; 

	map.saveMap();

	return 0;
}

