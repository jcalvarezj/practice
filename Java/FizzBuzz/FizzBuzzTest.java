/*
 * This is a small program that implements unit tests with JUnit
 * Based on https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-id
 * e-cd24d38adff
 * Requires JUnit JAR file on same directory 
 * Compile and run accordingly to the JUnit version
 * Compile with javac -cp .:junit-4.10.jar FizzBuzzTest.java
 * Run with java -cp .:junit-4.10.jar org.junit.runner.JUnitCore FizzBuzzTest
 * Remember TDD: Test first, then code a little, test again, code more...
 *
 * Does not require to compile tested classes, only this
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
	String dec = "\n*************************************************\n";
	/*
	 * This method tests if FizzBuzz's getResult returns "1" given a 1 
	 */
	@Test
	public void testGetResult_returnOneIfGivenOne() {
		FizzBuzz fb = new FizzBuzz();
		String result = fb.getResult(1);
		assertEquals(dec+"IT SHOULD RETURN \"1\"!!"+dec,"1",result);
	}

	/*
	 * This method tests if FizzBuzz's getResult returns "2" when given a 2
	 */
	@Test
	public void testGetResult_returnTwoIfGivenTwo() {
		FizzBuzz fb = new FizzBuzz();
		String result = fb.getResult(2);
		assertEquals(dec+"IT SHOULD RETURN \"2\"!!"+dec,"2",result);
	}

	/*
	 * This method tests if FizzBuzz's getResult returns "Fizz" when given a
	 * multiple of 3
	 */
	@Test
	public void testGetResult_returnFizzIfGivenMultipleOfThree() {
		FizzBuzz fb = new FizzBuzz();
		String result = fb.getResult(3);
		assertEquals(dec+"IT SHOULD RETURN \"Fizz\"!!"+dec,"Fizz",result);
	}

	/*
	 * This method tests if FizzBuzz's getResult returns "Buzz" when given a
	 * multiple of 5
	 */
	@Test
	public void testGetResult_returnBuzzIfGivenMultipleOfFive() {
		FizzBuzz fb = new FizzBuzz();
		String result = fb.getResult(5);
		assertEquals(dec+"IT SHOULD RETURN \"Buzz\"!!"+dec,"Buzz",result);
	}

	/*
	 * This method tests if FizzBuzz's getResult returns "FizzBuzz" when given a
	 * multiple of both 3 and 5
	 */
	@Test
	public void testGetResult_returnBuzzIfGivenMultipleOfThreeAndFive() {
		FizzBuzz fb = new FizzBuzz();
		String result = fb.getResult(15);
		assertEquals(dec+"IT SHOULD RETURN \"FizzBuzz\"!!"+dec,"FizzBuzz",
			result);
	}

}
