"""
This is an exercise that solves the 4-letter pattern problem:
    "For a list of strings like
        ['ATGCGA', 'CAGTGC', 'TTATGT', 'AGAAGG', 'CCCCTA', 'TCACTG'],
     which represents a matrix, try to find all the 4 conitguous letter patterns
     as lists of positions."

This program will read data from the '4letterpatterns.txt' file

To execute: `python3 find_4_letter_pattern.py`
To run tests: `python3 -m unittest -v find_4_letter_pattern.py`
"""
from unittest import main as test_main
from unittest import TestCase

INPUT_FILE = '4letterpatterns.txt'


def solve_for_horizontal(data, possible_letter, current_pattern_positions,
                         all_pattern_positions):
    """
        Solves the horizontal sweep. Modifications in-place
    """
    for i, word in enumerate(data):
        for j, letter in enumerate(word):
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(i, j)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((i, j))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions
                                                        .copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(i, j)]

        possible_letter = None
        current_pattern_positions = []


def solve_for_vertical(data, possible_letter, current_pattern_positions,
                       all_pattern_positions):
    """
        Solves the vertical sweep. Modifications in-place
    """
    N = len(data)
    M = len(data[0])

    for col in range(M):
        for row in range(N):
            letter = data[row][col]
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(row, col)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((row, col))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions
                                                        .copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(row, col)]

        possible_letter = None
        current_pattern_positions = []


def solve_for_lr_diagonal(data, possible_letter, current_pattern_positions,
                          all_pattern_positions):
    """
        Solves the first diagonal (left to right) sweep. Modifications in-place
    """
    N = len(data)
    M = len(data[0])

    # (Left diagonals)
    for row in range(N - 4, -1, -1):
        col = 0
        actual_row = row + col
        while actual_row < N and col < M:
            letter = data[actual_row][col]
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(actual_row, col)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((actual_row, col))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions
                                                        .copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(actual_row, col)]
            col += 1
            actual_row = row + col
        possible_letter = None
        current_pattern_positions = []

    # (Top diagonals)
    for col in range(M - 4, 0, -1):
        row = 0
        actual_col = col + row
        while actual_col < M and row < N:
            letter = data[row][actual_col]
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(row, actual_col)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((row, actual_col))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions
                                                        .copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(row, actual_col)]
            row += 1
            actual_col = col + row
        possible_letter = None
        current_pattern_positions = []


def solve_for_rl_diagonal(data, possible_letter, current_pattern_positions,
                          all_pattern_positions):
    """
        Solves the second diagonal (right to left) sweep. Modifications in-place
    """
    N = len(data)
    M = len(data[0])

    # (Top diagonals)
    for col in range(3, M):
        row = 0
        actual_col = col - row
        while actual_col >= 0 and row < N:
            letter = data[row][actual_col]
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(row, actual_col)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((row, actual_col))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions
                                                        .copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(row, actual_col)]
            row += 1
            actual_col = col - row

        possible_letter = None
        current_pattern_positions = []

    # (Right diagonals)
    for row in range(1, N - 2):
        col = M - 1
        actual_row = row + M - col - 1
        while actual_row >= N and col >= 0:
            letter = data[actual_row][col]
            if not possible_letter:
                possible_letter = letter
                current_pattern_positions = [(actual_row, col)]
            else:
                if letter == possible_letter:
                    current_pattern_positions.append((actual_row, col))
                    if len(current_pattern_positions) == 4:
                        all_pattern_positions.append(current_pattern_positions.copy())
                        current_pattern_positions.pop(0)
                else:
                    possible_letter = letter
                    current_pattern_positions = [(actual_row, col)]
            col -= 1
            actual_row = row + M - col - 1


def solve_problem(data):
    """
    Solves the problem
    """
    possible_letter = None
    all_pattern_positions = []
    current_pattern_positions = []

    solve_for_horizontal(data, possible_letter, current_pattern_positions,
                         all_pattern_positions)
    solve_for_vertical(data, possible_letter, current_pattern_positions,
                       all_pattern_positions)
    solve_for_lr_diagonal(data, possible_letter, current_pattern_positions,
                       all_pattern_positions)
    solve_for_rl_diagonal(data, possible_letter, current_pattern_positions,
                       all_pattern_positions)

    return all_pattern_positions


def load_file(filename):
    """
    Tries to load a file and returns its lines as a list
    """
    try:
        with open(filename) as f:
            lines = f.readlines()
            return lines
    except Exception as e:
        print('Problem opening input file!!')
        print(e)
        return []


class TestSolver(TestCase):
    """
    Class to test this program
    """
    def setUp(self):
        """
        Initializes test cases
        """
        self.cases = {
            'none': (
                [
                    'ATGA',
                    'AGGG',
                    'CCCA',
                    'TCAC'
                ],
                []
            ),
            'horizontal1': (
                [
                    'ATGA',
                    'AGGG',
                    'CCCC',
                    'TCAC'
                ],
                [
                    [(2, 0), (2, 1), (2, 2), (2, 3)]
                ]
            ),
            'horizontal2': (
                [
                    'CATGA',
                    'CGGGG',
                    'CCCGG',
                    'AAAAA',
                    'CCTAA'
                ],
                [
                    [(1, 1), (1, 2), (1, 3), (1, 4)],
                    [(3, 0), (3, 1), (3, 2), (3, 3)],
                    [(3, 1), (3, 2), (3, 3), (3, 4)]
                ]
            ),
            'vertical1': (
                [
                    'GCGA',
                    'GTGC',
                    'ATGT',
                    'AAGG',
                ],
                [
                    [(0, 2), (1, 2), (2, 2), (3, 2)]
                ]
            ),
            'vertical2': (
                [
                    'ATGGA',
                    'GTGAA',
                    'GTGCG',
                    'ATGTC',
                    'ATCGC',
                ],
                [
                    [(0, 1), (1, 1), (2, 1), (3, 1)],
                    [(1, 1), (2, 1), (3, 1), (4, 1)],
                    [(0, 2), (1, 2), (2, 2), (3, 2)]
                ]
            ),
            'diagonal1': (
                [
                    'ATGC',
                    'CAGT',
                    'TTAT',
                    'AGAA',
                ],
                [
                    [(0, 0), (1, 1), (2, 2), (3, 3)]
                ]
            ),
            'diagonal2': (
                [
                    'GCGA',
                    'GTAC',
                    'AAGT',
                    'AAGG',
                ],
                [
                    [(0, 3), (1, 2), (2, 1), (3, 0)]
                ]
            ),
            'diagonal3': (
                [
                    'CTGAC',
                    'GATCC',
                    'AACTC',
                    'ACGGT',
                    'CCAAG'
                ],
                [
                    [(0, 1), (1, 2), (2, 3), (3, 4)],
                    [(0, 4), (1, 3), (2, 2), (3, 1)],
                    [(1, 3), (2, 2), (3, 1), (4, 0)]
                ]
            ),
            'full': (
                [
                    'ATGCGA',
                    'CAGTGC',
                    'TTATGT',
                    'AGAAGG',
                    'CCCCAA',
                    'TCACTG'
                ],
                [
                    [(4, 0), (4, 1), (4, 2), (4, 3)], 
                    [(0, 4), (1, 4), (2, 4), (3, 4)],
                    [(0, 6), (1, 6), (2, 6), (3, 6)],
                    [(1, 6), (2, 6), (3, 6), (4, 6)],
                    [(2, 6), (3, 6), (4, 6), (5, 6)],
                    [(0, 0), (1, 1), (2, 2), (3, 3)],
                    [(1, 1), (2, 2), (3, 3), (4, 4)]
                ]
            )
        }

    def tearDown(self):
        """
        Clean up after testing
        """
        del(self.cases)

    def test_0_none(self):
        """
        Tests the case when the input doesn't have any patterns at all
        Should return an empty list
        """
        result = solve_problem(self.cases['none'][0])
        self.assertEqual(result, self.cases['none'][1])

    def test_1_horizontal_single(self):
        """
        Test the case of an input with one horizontal pattern
        """
        result = solve_problem(self.cases['horizontal1'][0])
        self.assertEqual(result, self.cases['horizontal1'][1])

    def test_2_horizontal_double(self):
        """
        Test the case of an input with two horizontal patterns, one of them is
        tricky (has 5 letters in a row, so two patterns are expected)
        """
        result = solve_problem(self.cases['horizontal2'][0])
        self.assertEqual(result, self.cases['horizontal2'][1])

    def test_3_vertical_single(self):
        """
        Test the case of an input with one vertical pattern
        """
        result = solve_problem(self.cases['vertical1'][0])
        self.assertEqual(result, self.cases['vertical1'][1])

    def test_4_vertical_double(self):
        """
        Test the case of an input with two vertical pattens and a tricky one
        """
        result = solve_problem(self.cases['vertical2'][0])
        self.assertEqual(result, self.cases['vertical2'][1])

    def test_5_diagonal_lefttoright(self):
        """
        Test the case of an input with one left to right diagonal pattern
        """
        result = solve_problem(self.cases['diagonal1'][0])
        self.assertEqual(result, self.cases['diagonal1'][1])

    def test_6_diagonal_righttoleft(self):
        """
        Test the case of an input with one right to left diagonal pattern
        """
        result = solve_problem(self.cases['diagonal2'][0])
        self.assertEqual(result, self.cases['diagonal2'][1])

    def test_7_diagonal_both(self):
        """
        Test the case of an input with both types of diagonal patterns
        """
        result = solve_problem(self.cases['diagonal3'][0])
        self.assertEqual(result, self.cases['diagonal3'][1])


if __name__ == '__main__':
    print(f'Processing for the {INPUT_FILE} file...')
    lines = load_file(INPUT_FILE)
    result = solve_problem(lines)

    if len(lines) == 0:
        print('No patterns detected!!')
    else:
        print('This is the list of pattern positions:')
        print(result)
