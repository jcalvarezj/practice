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

for (let i = 0; i < 7; i++)
	console.log(fibonacci(i))