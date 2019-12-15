/*
 * Header file definition
 */
#include <string>

#ifndef PLAYER_H
#define PLAYER_H

class Player {
public:
	Player(std::string name);
	void getUserInput();
	int getX();
	int getY();
	bool isAlive();
private:
	int x,y;
	bool alive;
	std::string name;
};

#endif /* PLAYER_H */

