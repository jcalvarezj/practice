/*
 * Basic 1D game thingy
 *
 * @author J. Alvarez
 */
#include <iostream>

#define LEFT 'A'
#define RIGHT 'D'
#define DIE 'X'
#define N 10
#define CELL '_'
#define ICON 'I'


/*
 * Obtains user input and performs movement with it
 * @param map The current map
 * @param pos The pointer to the current character position
 * @param action The action character entered by user
 */
void inputAction(const char map[], int * pos, char action, bool * gameOver);

/*
 * Prints the current status of the specified map
 * @param map The map
 * @param pos Current character position
 */
void printMap(const char map[], int pos);

/*
 * Main program
 */
int main() {

	int charPos = 0;
	char action = '0';
	bool gameOver = false;

	char map[N];

	for(int i=0; i<N; i++)
		map[i] = CELL;

	printMap(map, charPos);

	while(!gameOver) {
		std::cout << "Enter an action:\nLeft (A) - Right (D) - Die (X)" << std::endl;
		std::cin >> action;
		inputAction(map, & charPos, action, & gameOver);
	}

	return 0;
}

void inputAction(const char map[], int * pos, char action, bool * gameOver) {
	switch(std::toupper(action)) {
		case LEFT:
			if(* pos > 0)
				* pos = * pos - 1;
			break;
		case RIGHT:
			if(* pos < N-1)
				* pos = * pos + 1;
			break;
		case DIE:
			* gameOver = true;
			break;
		default:
			std::cout << "INVALID ACTION!" << std::endl;
			break;
	}
	printMap(map, * pos);
}

void printMap(const char map[], int pos) {
	for(int i=0; i<N; i++)
		if(i!=pos)
			std::cout << map[i];
		else
			std::cout << ICON;
	std::cout << "  -- Now at: " << pos << std::endl;
}
