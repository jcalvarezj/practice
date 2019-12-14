/*
 * Basic 1D game thingy
 *
 * @author J. Alvarez
 */
#include <iostream>

#define LEFT 'A'
#define RIGHT 'D'
#define UP 'W'
#define DOWN 'S'
#define DIE 'X'
#define N 8
#define M 10
#define CELL '_'
#define ICON 'I'


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
 * Main program
 */
int main() {

	int charPosI = 0, charPosJ = 0;
	char action = '0';
	bool gameOver = false;

	char map[N][M];

	for(int i=0; i<N; i++)
		for(int j=0; j<M; j++)
			map[i][j] = CELL;

	printMap(map, charPosI, charPosJ);

	while(!gameOver) {
		std::cout << "Enter a key for the desired action:\n Up (W) - Down (S) -"
			<< "Left (A) - Right (D) - Die (X)" << std::endl;
		std::cin >> action;
		inputAction(map, & charPosI, & charPosJ, action, & gameOver);
	}

	return 0;
}

void inputAction(const char map[][M], int * posI, int * posJ, char action, bool * gameOver) {
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
	for(int i=0; i<N; i++) {
		for(int j=0; j<M; j++)
			if(i == posI && j == posJ)
				std::cout << ICON;
			else
				std::cout << map[i][j];
		std::cout << std::endl;
	}
	std::cout << "  -- Now at: " << posI << ", " << posJ << std::endl;
}
