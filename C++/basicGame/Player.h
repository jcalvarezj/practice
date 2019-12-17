/*
 * Player class header file definition
 *
 * @author J. Alvarez
 */
#include <string>
#include "Map.h"
#include "MovingMapEntity.h"

#ifndef PLAYER_H
#define PLAYER_H

class Player: public MovingMapEntity {
public:
	/*
	 * Creates an instance of Player with a name
	 * @see MovingMapEntity
	 * @param name The name of the player
	 */
	Player(std::string name, int x, int y, Map * map);

	/*
	 * Obtains commands by CLI input
	 */
	void getUserInput();

	/*
	 * @return The boolean "alive" status of the Player
	 */
	bool isAlive();

	/*
	 * Sets "alive" to false
	 */
	void die();

	/*
	 * @return Boolean indicating whether the Player obtained the level treasure
	 */
	bool hasTreasure();
private:
	bool alive, treasureInHand;
	std::string name;
};

#endif /* PLAYER_H */

