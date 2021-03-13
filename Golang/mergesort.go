// This program sorts an array using mergesort
package main

import "fmt"

func merge(array []int, left []int, right []int) {
	i, j, k := 0, 0, 0
	N, M := len(left), len(right)
	fmt.Println("Working with: ", array, left, right)

	for i < N && j < M {
		if left[i] < right[j] {
			array[k] = left[i]
			i++
		} else {
			array[k] = right[j]
			j++
		}
		k++
	}

	for i < N {
		array[k] = left[i]
		i++
		k++
	}

	for j < M {
		array[k] = right[j]
		j++
		k++
	}

	fmt.Println("\t with: ", array, left, right)
}


func mergesort(array []int) {
	N := len(array)
	if N > 1 {
		mid := N / 2

		left := array[:mid]
		right := array[mid:N]

		leftC := make([]int, len(left))
		rightC := make([]int, len(right))

		copy(leftC, left)
		copy(rightC, right)

		mergesort(leftC)
		mergesort(rightC)

		merge(array, leftC, rightC)
	}
}


func main() {
	problem := []int {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
	fmt.Println("Initial array: ", problem)
	mergesort(problem)
	fmt.Println("Sorted array: ", problem)
}
