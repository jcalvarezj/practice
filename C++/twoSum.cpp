/*
 * This program solves the two sum problem: given S, find all the pairs of two
 * integers in an unsorted array that sum up to S
 *
 * Naive O(N^2) solution
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <set>

using namespace std;

void solve(set<pair<int, int>> & solution, int * array, int S, int N) {
	for (int i = 0; i < N-1; i++)
		for (int j = i+1; j < N; j++)
			if (array[i] + array[j] == S)
				solution.insert(pair<int, int>(array[i], array[j]));
}

void printSolution(const set<pair<int, int>> & solution) {
	for(auto it = solution.begin(); it != solution.end(); it++)
		std::cout << it->first << " - " << it->second << std::endl;	
}

int main(int argc, char const *argv[])
{
	int array[] = {5, 0, 2, 4, 7, 3};
	int N = sizeof(array) / sizeof(int);
	int S = 7;

	set<pair<int, int>> solution;

	solve(solution, array, S, N);

	printSolution(solution);

	return 0;
}

