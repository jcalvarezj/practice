function fibonacciMemoization(n, solution) {
    if (n === 0 || n === 1)
        return solution[n];
    else {
        if (!solution[n]) 
            solution[n] = fibonacciMemoization(n-1, solution) + fibonacciMemoization(n-2, solution);
        return solution[n];
    }
}

function fibonacci(n) {
    return fibonacciMemoization(n, [0, 1]);
}

console.log(fibonacci(0))
console.log(fibonacci(1))
console.log(fibonacci(2))
console.log(fibonacci(3))
console.log(fibonacci(4))
console.log(fibonacci(5))
console.log(fibonacci(6))