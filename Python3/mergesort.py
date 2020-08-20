def mergesort(numbers):
    """
    In-place sorting of a list of numbers
    """
    print(f'>>> PROCESSING >>> ---- {numbers}')
    # 0. Base case
    if len(numbers) > 1:
        # 1. Divide
        mid = len(numbers) // 2
        left = numbers[:mid]
        right = numbers[mid:]

        # 2. Conquer
        mergesort(left)
        mergesort(right)

        # 3. Combine

        # 3.1. Alternate moving indices for left and right according to left[i] < right[j]
        #    and store in numbers[k]

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
                

        # 3.2. Put the rest of the numbers from left in numbers (if some remain and
        #      the above loop finished because of right)
        
        while i < len(left):
            numbers[k] = left[i]
            i += 1
            k += 1
        
        # 3.3. And viceversa
        
        while j < len(right):
            numbers[k] = right[j]
            i += 1
            k += 1
        

if __name__ == "__main__":
    x = [5, 4, 3, 2, 1]
    mergesort(x)
    print(x)
