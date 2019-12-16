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

/*
 * Loads the specified cover on the CLI
 * @param coverId The id of the cover to load
 */
void loadCover(int coverId);

int main(int argc, char ** args) {
	bool gameOver = false, victory = false;
	int playerIX = 0, playerIY = 0, currentLevel = 0;
	int enemiesIX[N_ENEMIES], enemiesIY[N_ENEMIES];

	Map map(false);
	map.loadMap(currentLevel, playerIX, playerIY, enemiesIX, enemiesIY);

	Player hero("Pepe",playerIX, playerIY, & map);

	Enemy enemies[] = {
		Enemy(0, enemiesIX[0], enemiesIY[0], & map),
		Enemy(1, enemiesIX[1], enemiesIY[1], & map),
		Enemy(2, enemiesIX[2], enemiesIY[2], & map),
	};

	loadCover(START);

	map.setPlayerCell(hero.getX(), hero.getY());

	for(int i = 0; i < N_ENEMIES; i++)
		map.setEnemyCell(i, enemies[i].getX(), enemies[i].getY());

	map.drawMap();

	while(!gameOver && !victory) {
		hero.getUserInput();
		if (map.setPlayerCell(hero.getX(), hero.getY()))
			hero.die();
		for(int i = 0; i < N_ENEMIES; i++) {
			enemies[i].move();
			if(map.setEnemyCell(i, enemies[i].getX(), enemies[i].getY()))
				hero.die();
		}
		
		map.drawMap();
		victory = hero.hasTreasure();

		if(!victory)
			gameOver = !hero.isAlive();
	}

	if(gameOver)
		loadCover(GAME_OVER);
	else
		if(victory)
			loadCover(VICTORY);

	return 0;
}

void loadCover(int coverId) {
	std::string fileName = "";
	std::string message = "";
	switch(coverId) {
		case START:
			fileName = COVER_FILE;
			message = std::string("\n-- GAME START --\nPress ENTER to start.")
				+" Move with WASD + ENTER. Die with X + ENTER\n\n";
			break;
		case VICTORY:
			fileName = VICTORY_FILE;
			message = "\n-- CONGRATULATIONS! YOU WON! --";
			break;
		case GAME_OVER:
			fileName = GAME_OVER_FILE;
			message = "\n-- GAME OVER --";
			break;
	}
	std::ifstream cover(fileName.c_str());

	if(cover.is_open()) {
		std::string buffer = "";
		
		while(getline(cover, buffer))
			std::cout << buffer << std::endl;
	}
	
	std::cout << message << std::endl;
}

