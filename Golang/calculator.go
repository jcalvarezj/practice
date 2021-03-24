// Basic calculator example that reads user input of simple mathematical operations
// For example: <number><operator><number>
// Supported operators: +, -, *, /

package main

import (
	"os"
	"fmt"
	"bufio"
	"strconv"
	"strings"
)

func identifyOperator(str string) string {
	operator := ""
	i := 0
	for i < len(str) && operator == "" {
		char := string(str[i])
		if char == "+" || char == "-" || char == "*" || char == "/" {
			operator = char
		}
		i++
	}
	return operator
}

func operate(a, b float64, operator string) float64 {
	switch operator {
		case "+":
			return a + b
		case "-":
			return a - b
		case "*":
			return a * b
		case "/":
			return a / b
		default:
			return "NaN"
	}
}

func getInput() {
	fmt.Println("Please enter the operation and press enter: ")
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Scan()

	return scanner.Text()
}

func main() {
	operator := identifyOperator(getInput())

	if operator == "" {
		panic("No operator found in the string! Exiting!")
	} else {
		numbers := strings.Split(input, operator)
		num1, err1 := strconv.ParseFloat(numbers[0], 64)
		num2, err2 := strconv.ParseFloat(numbers[1], 64)

		if err1 != nil || err2 != nil {
			panic("Only numbers allowed as input!! Exiting!!")
		} else {
			result := operate(num1, num2, operator)
			fmt.Println("Answer: ", result)
		}
	}
}
