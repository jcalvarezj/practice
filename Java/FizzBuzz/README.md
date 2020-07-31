## FizzBuzz

This is a small program that implements unit tests with JUnit to solve the FizzBuzz problem.
Based on https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-ide-cd24d38adff

The FizzBuzz problem goes as follows:

1. If the number is divisible by 3, the program returns "Fizz";
2. if the number is divisible by 5, the program returns "Buzz";
3. if the number is divisible by both three and five, the program returns "FizzBuzz";
4. finally, if the number is not divisible by 3 or 5, the program returns the number.

Requires JUnit JAR file on same directory.

Compile and run accordingly to the JUnit version. For example:

- Compile with `javac -cp .:junit-4.10.jar FizzBuzzTest.java`

- Run with `java -cp .:junit-4.10.jar org.junit.runner JUnitCore FizzBuzzTest`