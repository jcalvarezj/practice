/*
 * Constants header file definition
 */

#ifndef CONSTANTS_H
#define CONSTANTS_H

#define UP 'W'
#define DOWN 'S'
#define LEFT 'A'
#define RIGHT 'D'
#define DIE 'X'
#define N 15
#define M 10
#define N_ENEMIES 3
#define N_LEVELS 3
#define CELL_EMPTY ' '
#define CELL_PLAYER 'I'
#define CELL_WALL 'X'
#define CELL_ENEMY 'O'
#define CELL_DEATH '#'
#define CELL_START '*'
#define CELL_TREASURE '$'
#define MAP_FILE "map"
#define COVER_FILE "cover.txt"
#define NEXT_LEVEL_FILE "nextlevel.txt"
#define VICTORY_FILE "victory.txt"
#define GAME_OVER_FILE "gameover.txt"
#define ENEMY_VERTICAL_MOVES 4
#define ENEMY_HORIZONTAL_MOVES 4

enum ENEMY_MOVES {MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT};
enum COVERS {START, NEXT_LEVEL, VICTORY, GAME_OVER};

#endif // CONSTANTS_H
