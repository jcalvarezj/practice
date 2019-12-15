/*
 * This is a basic example of a 2D CLI game using Object Oriented Programming
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <fstream>
#include <string>
#include "Constants.h"
#include "Player.h"
#include "Map.h"

void loadCover() {
	std::ifstream cover(COVER_FILE);

	if(cover.is_open()) {
		std::string buffer = "";
		
		while(getline(cover, buffer))
			std::cout << buffer << std::endl;
	}
	
	std::cout << std::endl << "-- GAME START --" << std::endl;
	std::cout << "Press ENTER to start. Move with WASD + ENTER. Die with X +"
	   << " ENTER" << std::endl	<< std::endl;
}

int main(int argc, char ** args) {
	bool gameOver = false;
	bool victory = false;
	Map map;
	Player hero("Pepe",& map);

	std::cout << "Loading map..." << std::endl; 

	map.loadMap();

	loadCover();

	map.setPlayerCell(hero.getX(), hero.getY());
	map.drawMap();

	while(!gameOver && !victory) {
		hero.getUserInput();
		map.setPlayerCell(hero.getX(), hero.getY());
		map.drawMap();
		victory = hero.hasTreasure();
		if(!victory)
			gameOver = !hero.isAlive();
	}

	if(gameOver)
		std::cout << "-- GAME OVER --" << std::endl;

	if(victory)
		std::cout << "\n-- CONGRATULATIONS! YOU WIN! --" << std::endl;

	return 0;
}

