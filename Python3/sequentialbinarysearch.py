'''
This is a simple exercise to implement sequential and binary search in Python
'''

def sequential_search(lst, element):
    """
    Searches an element inside a list and returns its index or -1 if not found
    """
    index = -1
    i = 0

    for i, e in enumerate(lst):
        if e == element:
            return i

    return -1


def binary_search(lst, element):
    """
    Search an element in an ordered list using binary search. Return the index
    if found or -1 otherwise
    """
    left = 0
    right = len(lst) - 1

    while left < right:
        mid = (right - left + 1) // 2

        if lst[mid] == element:
            return mid
        else:
            if element < lst[mid]:
                right = mid - 1
            else:
                left = mid + 1

    return -1


if __name__ == '__main__':
    x = [1, 2, 3, 4, 5, 6, 7, 8]

    try:
        print(f'The array is {x}\nEnter the element to search (numbers only): ')
        element = int(input())
        
        print('Using which search algorithm? (1 for sequential, 2 for binary)')
        algorithm = int(input())

        if algorithm == 1:
            position = sequential_search(x, element)
        else:
            if algorithm == 2:
                position = binary_search(x, element)
            else:
                print('Only options 1 or 2!!!')

        print(f'Output position: {position}')
    except ValueError:
        print('NUMBERS ONLY!!!')

