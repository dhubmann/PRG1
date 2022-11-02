/* 
 * Operators
 * Working with variables and operators
 * Author: Daniel Hubmann
 * Last Change: 27.10.2022
 */

public class Operators {

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));

		// mat.number: 01130491
		// sum of first 4 numbers beginning from the left
		// 5
		int sum = 0 + 1 + 1 + 3;
		// System.out.println(sum);
		// product of next three numbers
		// 0
		int product = 0 * 4 * 9;
		// System.out.println(product);

		// difference between pre-incremented product and post-incremented sum
		// 1 - 5 = -4 and sum = 6
		int diff = ++product - sum++;
		// System.out.println(diff);

		// product of difference and sum
		// -4 * 6 = -24
		int result = diff * sum;
		// System.out.println(result);

		// last number of mat.number + 1 = 2
		// division and modulo of 'result' with 2
		// printing result of division as an integer will lead to loss of decimal places
		// -12 and 0
		int intDiv = result / 2;
		int remainder = result % 2;

		// print solutions
		System.out.println("Result = " + result);
		System.out.println("Integer division =  " + intDiv);
		System.out.println("Remainder = " + remainder);
		// double division = result / 2;
		// declaring a double or float variable is not allowed
		// printing result of division as floating point number with .00 precision
		// using '2.0' instead of '2'
		System.out.printf("Division = %.2f", result / 2.0);

	}

}
