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
#include "Enemy.h"
#include "Map.h"

void loadCover(bool isStartCover) {
	std::string fileName = isStartCover ? COVER_FILE : VICTORY_FILE;
	std::ifstream cover(fileName.c_str());

	if(cover.is_open()) {
		std::string buffer = "";
		
		while(getline(cover, buffer))
			std::cout << buffer << std::endl;
	}
	
	if(isStartCover) {
		std::cout << std::endl << "-- GAME START --" << std::endl;
		std::cout << "Press ENTER to start. Move with WASD + ENTER. Die with X "
		   << " + ENTER" << std::endl << std::endl;
	}
	else
		std::cout << "\n-- CONGRATULATIONS! YOU WON! --" << std::endl;
}

int main(int argc, char ** args) {
	bool gameOver = false;
	bool victory = false;

	Map map;
	map.loadMap();

	Player hero("Pepe", & map);
	Enemy enemy(0, & map);

	loadCover(true);

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
		loadCover(false);

	return 0;
}

