/*
 * This is a small program that implements unit tests with JUnit
 * Based on https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-id
 * e-cd24d38adff
 */

/*
 * This class represents the FizzBuzz class; it works as follows:
 * 1. If the number is divisible by 3, the program returns “Fizz”,
 * 2. if the number is divisible by 5, the program returns “Buzz”,
 * 3. if the number is divisible by both three and five, the program returns
 * “FizzBuzz”,
 * Finally, if the number is not divisible by 3 or 5, the program returns the
 * number.
 */
public class FizzBuzz {
	
	public String getResult(int number) {
		if(number%3 == 0 && number%5 == 0)
			return "FizzBuzz";
		else if(number%3 == 0)
			return "Fizz";
		else if(number%5 == 0)
			return "Buzz";
		else
			return String.valueOf(number);
	}

}
