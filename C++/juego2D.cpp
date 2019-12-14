/*
 * Basic CLI 2D game thingy. A character moving around a 2D map, according to
 * user input. Saves state in a file.
 *
 * For Platzi's C++ course challenge.
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <fstream>

#define LEFT 'A'
#define RIGHT 'D'
#define UP 'W'
#define DOWN 'S'
#define DIE 'X'
#define N 8
#define M 10
#define CELL '_'
#define ICON 'I'
#define SAVE_FILE "mapState.dat"


/*
 * Obtains user input and performs movement with it
 * @param map The current map
 * @param pos The pointer to the current horizontal character position
 * @param pos The pointer to the current vertical character position
 * @param action The action character entered by user
 */
void inputAction(const char map[][M], int * posI, int * posJ, char action, bool * gameOver);

/*
 * Prints the current status of the specified map
 * @param map The map
 * @param pos Current character position
 */
void printMap(const char map[][M], int posI, int posJ);

/*
 * Updates the character's position according to the save file's map
 * @param posI Pointer to vertical position to be updated
 * @param posJ Pointer to horizontal position to be updated
 */
void setPositionFromFile(int * posI, int * posJ);

/*
 * Saves the finished game's map status on the defined SAVE_FILE file, with the
 * character's last position marked as a *
 * @param map The map of the game
 * @param posI The last horizontal position of the character
 * @param posJ The last vertical position of the character
 */
void saveGame(char map[][M], int posI, int posJ);

/*
 * Main program
 */
int main() {
	int charPosI = 0, charPosJ = 0;
	char action = '0';
	bool gameOver = false;

	char map[N][M];

	setPositionFromFile(& charPosI, & charPosJ);

	for(int i = 0; i < N; i++)
		for(int j = 0; j < M; j++)
			map[i][j] = CELL;

	printMap(map, charPosI, charPosJ);

	while(!gameOver) {
		std::cout << "Enter a key for the desired action:\n Up (W) - Down (S) -"
			<< "Left (A) - Right (D) - Die (X)" << std::endl;
		std::cin >> action;
		inputAction(map, & charPosI, & charPosJ, action, & gameOver);
	}

	saveGame(map, charPosI, charPosJ);

	std::cout << "-- Game Over! --" << std::endl;

	return 0;
}

void inputAction(const char map[][M], int * posI, int * posJ, char action,
	   bool * gameOver) {
	switch(std::toupper(action)) {
		case LEFT:
			if(* posJ > 0)
				* posJ = * posJ - 1;
			break;
		case RIGHT:
			if(* posJ < M-1)
				* posJ = * posJ + 1;
			break;
		case UP:
			if(* posI > 0)
				* posI = * posI - 1;
			break;
		case DOWN:
			if(* posI < N-1)
				* posI = * posI + 1;
			break;
		case DIE:
			* gameOver = true;
			break;
		default:
			std::cout << "INVALID ACTION!" << std::endl;
			break;
	}
	printMap(map, * posI, * posJ);
}

void printMap(const char map[][M], int posI, int posJ) {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++)
			if(i == posI && j == posJ)
				std::cout << ICON;
			else
				std::cout << map[i][j];
		std::cout << std::endl;
	}
	std::cout << "  -- Now at: " << posI << ", " << posJ << std::endl;
}

void setPositionFromFile(int * posI, int * posJ) {
	std::ifstream inputFile(SAVE_FILE);

	if(inputFile.is_open()) {
		bool found = false;
		int currentLine = 0;
		std::string readBuffer;
		while(getline(inputFile, readBuffer) && !found) {
			for(int k = 0; k < readBuffer.length(); k++) {
				if(readBuffer[k] == '*') {
					* posI = currentLine;
					* posJ = k;
					found = true;
				}
			}
			currentLine++;
		}

		if(!found) {
			std::cout << "Could not find saved position in file. File is not";
			std::cout << " valid. Using origin position" << std::endl;
		}
	}
	else {
		std::cout << "Could not open save file " << SAVE_FILE << ", using ";
		std::cout << "origin position" << std::endl;
	}

	inputFile.close();

}

void saveGame(char map[][M], int posI, int posJ) {
	std::ofstream saveFile(SAVE_FILE);
	
	if(saveFile.is_open()) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				if (i == posI && j == posJ)
					saveFile << '*';
				else
					saveFile << map[i][j];
			saveFile << std::endl;
		}
	}
	else
		std::cout << "Couldn't open " << SAVE_FILE << "OS problem" << std::endl;

	saveFile.close();
}
