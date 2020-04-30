function fibonacciTabulation(n) {
	const results = new Array(n).fill(0);  
	results[0] = 0;  

	if (n >= 1) {
		results[1] = 1;

		for (let i = 2; i <= n; i++)
			results[i] = results[i-1] + results[i-2];
	}

	return results[n];
}

for (let i = 0; i < 7; i++)
	console.log(fibonacciTabulation(i))