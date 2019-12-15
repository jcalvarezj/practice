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
private:
	int x,y;
	std::string name;
};

#endif /* PLAYER_H */

