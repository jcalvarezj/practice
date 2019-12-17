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
#include "VerticalEnemy.h"
#include "HorizontalEnemy.h"
#include "RandomEnemy.h"
#include "Map.h"

/*
 * Loads the specified cover on the CLI
 * @param coverId The id of the cover to load
 */
void loadCover(int coverId);

/*
 * Frees memory from unused enemies
 */
void cleanEnemies(Enemy ** enemies);

int main(int argc, char ** args) {
	bool gameOver = false, victory = false, levelFinished = false,
		 mapError = false;
	int playerIX = 0, playerIY = 0, currentLevel = 1;
	int enemiesIX[N_ENEMIES], enemiesIY[N_ENEMIES];

	Map map;
	mapError = !map.loadMap(currentLevel, playerIX, playerIY, enemiesIX,
			enemiesIY);

	if(mapError)
		return -1;

	std::string name = "";
	std::cout << "Enter your hero's name: ";
	std::cin >> name;
	std::cout << "\n\t\tGo for the treasure (" << CELL_TREASURE << "), " <<
		name << "!\n\t\tRemember to avoid the enemy! (" << CELL_ENEMY << ")"
		<< std::endl;


	Player hero(name, playerIX, playerIY, & map);

	Enemy * enemies[] = {
		new VerticalEnemy(0, enemiesIX[0], enemiesIY[0], & map),
		new HorizontalEnemy(1, enemiesIX[1], enemiesIY[1], & map),
		new RandomEnemy(2, enemiesIX[2], enemiesIY[2], & map)
	};

	loadCover(START);
	std::cout << "Next level:" << currentLevel+1 << std::endl;

	map.setPlayerCell(hero.getX(), hero.getY());

	for(int i = 0; i < N_ENEMIES; i++)
		map.setEnemyCell(i, enemies[i]->getX(), enemies[i]->getY());

	map.drawMap();

	while(!gameOver && !victory && !mapError) {
		hero.getUserInput();

		if (map.setPlayerCell(hero.getX(), hero.getY()))
			hero.die();
		else
			for(int i = 0; i < N_ENEMIES; i++) {
				enemies[i]->move();
				if(map.setEnemyCell(i, enemies[i]->getX(), enemies[i]->getY()))
					hero.die();
			}
		
		map.drawMap();

		levelFinished = hero.hasTreasure();
		victory = levelFinished && currentLevel == N_LEVELS;
		
		if(!victory)
			gameOver = !hero.isAlive();
		
		if(levelFinished && !victory) {
			loadCover(NEXT_LEVEL);
			currentLevel++;
			std::cout << "Next level:" << currentLevel << std::endl;

			levelFinished = false;
			cleanEnemies(enemies);
			map = Map();

			mapError = !map.loadMap(currentLevel, playerIX, playerIY, enemiesIX,
					enemiesIY);

			if(!mapError) {
				enemies[0] = new RandomEnemy(0, enemiesIX[0], enemiesIY[0], & map);
				enemies[1] = new RandomEnemy(1, enemiesIX[1], enemiesIY[1], & map);
				enemies[2] = new RandomEnemy(2, enemiesIX[2], enemiesIY[2], & map);

				std::cout << "Enemies loaded at: - " << enemiesIY[0] << " - " << enemiesIX[0] << std::endl; 
				std::cout << "Enemies loaded at: - " << enemiesIY[1] << " - " << enemiesIX[1] << std::endl; 
				std::cout << "Enemies loaded at: - " << enemiesIY[2] << " - " << enemiesIX[2] << std::endl; 
				hero = Player(name, playerIX, playerIY, & map);
				map.setPlayerCell(hero.getX(), hero.getY());

				for(int i = 0; i < N_ENEMIES; i++)
					map.setEnemyCell(i, enemies[i]->getX(), enemies[i]->getY());

				map.drawMap();
			}
		}
	}

	if(gameOver) {
		loadCover(GAME_OVER);
		cleanEnemies(enemies);
	}
	else {
		if(mapError)
			return -1;
		if(victory)
			loadCover(VICTORY);
	}

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
		case NEXT_LEVEL:
			fileName = NEXT_LEVEL_FILE;
			message = "\n-- LEVEL COMPLETE! ADVANCING TO NEXT LEVEL! --";
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

void cleanEnemies(Enemy ** enemies) {
	for(int i=0; i<N_ENEMIES; i++)
		delete enemies[i];
}
