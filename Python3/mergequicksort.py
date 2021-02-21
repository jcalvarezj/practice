def merge(numbers, left, right):
    """
    Combines the left and right solutions
    """
    # 3.1. Alternate moving indices for left and right according to left[i] < right[j]
    #    and store in numbers[k] (variable that's local to the recursive environment)
    i = 0
    j = 0
    k = 0

    print(f'~~ COMBINING ~~ ------------- {left} WITH {right}')

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            numbers[k] = left[i]
            i += 1                
        else:
            numbers[k] = right[j]
            j += 1
        k += 1
            

    # 3.2. Put the rest of the numbers from left in numbers (if some remain and the
    #    above loop finished because of right)
    while i < len(left):
        numbers[k] = left[i]
        i += 1
        k += 1
    
    # 3.3. And viceversa
    while j < len(right):
        numbers[k] = right[j]
        j += 1
        k += 1

    print(f'\t~~ LEADS TO ~~ ---------- {numbers[0:len(numbers)]}')


def mergesort(numbers):
    """
    In-place sorting of a list of numbers using mergesort
    (Chooses partition point as the exact middle point)
    low: leftmost sorting index
    high: rightmost sorting index
    """
    print(f'>>> PROCESSING >>> ---- {numbers}')

    # 0. Base case (Lists of size == 1 are already solved; do nothing). Solve for
    #    bigger problems

    if len(numbers) > 1:
        # 1. Divide
        mid = len(numbers) // 2
        left = numbers[:mid]
        right = numbers[mid:len(numbers)]

        # 2. Conquer
        mergesort(left)
        mergesort(right)

        # 3. Combine
        merge(numbers, left, right)


def partition(numbers, low, high):
    """
    Chooses initial pivot as last element and rearranges the list's elements to
    be left and right of the pivot, accordingly if they are smaller or greater
    than it. Then it returns the pivot's position
    """
    pivot = numbers[high]
    i = low - 1

    for j in range(low, high):
        if numbers[j] < pivot:
            i += 1
            numbers[i], numbers[j] = numbers[j], numbers[i]

    numbers[i + 1], numbers[high] = numbers[high], numbers[i + 1]
    return i + 1


def quicksort(numbers, low, high):
    """
    In-place sorting of a list of numbers using quicksort
    numbers: the list of numbers to sort
    low: leftmost sorting index
    high: rightmost sorting index
    """
    # 0. Base case (single element lists are already solved; do nothing). Solve for
    #    bigger problems
    
    if low < high:
        # 1. Divide (choose pivot and put lower/higher values left/right)
        pivot_index = partition(numbers, low, high)

        # 2. Conquer (solve for left and right side to the pivot)
        quicksort(numbers, low, pivot_index - 1)
        quicksort(numbers, pivot_index + 1, high)


if __name__ == "__main__":
    x = [8, 7, 6, 5, 4, 3, 2, 1]
    print('Please choose your sorting algorithm:')
    print('1: Mergesort')
    print('2: Quicksort')
    try:
        option = int(input())
        print('')
        if option < 1 or option > 2:
            raise ValueError()
        else:
            if option == 1:
                mergesort(x)
            else:
                quicksort(x, 0, len(x) - 1)
            print(f'\nSorted list: {x}')
    except ValueError:
        print('Only options are 1 or 2!!!!')
