/* 
 * Methods
 * Working with methods
 * Author: Daniel Hubmann
 * Last Change: 09.11.2022
 */

import java.util.Scanner;

public class Methods {

	// Reads positive integer from user
	public static int readNumber(Scanner scanner) {
		boolean keepPrompting = true;
		int input = 0;
		while (keepPrompting) {
			System.out.print("Enter a positive number: ");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				if (input > 0 && scanner.nextLine().equals("")) {
					keepPrompting = false;
				} else if (input < 1 && scanner.nextLine().equals("")) {
					continue;
				} else {
					continue;
				}
			} else {
				scanner.nextLine();
			}
		}
		return input;
	}

	// Determines minimum between two integers
	public static int minFunction(int a, int b) {
		return (a < b) ? a : b;
	}

	// Determines maximum between two integers
	public static int maxFunction(int a, int b) {
		return (a > b) ? a : b;
	}

	// Calculates sum of two integers
	public static int sumFunction(int a, int b) {
		return a += b;
	}

	// Calculates sum from first to second integer including both integers
	public static int sumFromTo(int a, int b) {
		int min = minFunction(a, b);
		int max = maxFunction(a, b);
		int sumFromTo = 0;
		for (int i = min; i <= max; i++) {
			sumFromTo += i;
		}
		return sumFromTo;
	}

	// Calculates delta between two integers
	public static int deltaFunction(int a, int b) {
		int min = minFunction(a, b);
		int max = maxFunction(a, b);
		return max - min;
	}

	// Calculates mean of two integers
	public static double meanFunction(int a, int b) {
		return (a + b) / 2.0;
	}

	// Calculates greatest common divider between two integers
	public static int gcdFunction(int a, int b) {
		int min = minFunction(a, b);
		int max = maxFunction(a, b);
		int remainder = max % min;
		while (remainder != 0) {
			max = min;
			min = remainder;
			remainder = max % min;
		}
		return min;
	}

	// Calculates least common multiple between two integers
	public static int lcmFunction(int a, int b) {
		int lcd = (a * b) / gcdFunction(a, b);
		return lcd;
	}

	///////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	///////////////////////////////////////////////////////////////////////////////

	// Calculates all prime numbers between two integers
	// 1 is not prime
	// return type should probably be an object
	// since we need to be able to return varying amounts of integers

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));

		// Create scanner variable in main method
		// Use scanner variable as parameter in methods
		Scanner scanner = new Scanner(System.in);

		int num1 = readNumber(scanner);
		int num2 = readNumber(scanner);

		minFunction(num1, num2);
		maxFunction(num1, num2);

		// Print statements
		System.out.printf("min(%d,%d) = %d\n", num1, num2, minFunction(num1, num2));
		System.out.printf("max(%d,%d) = %d\n", num1, num2, maxFunction(num1, num2));
		System.out.printf("sum(%d,%d) = %d\n", num1, num2, sumFunction(num1, num2));
		System.out.printf("sumFromTo(%d,%d) = %d\n", num1, num2, sumFromTo(num1, num2));
		System.out.printf("delta(%d,%d) = %d\n", num1, num2, deltaFunction(num1, num2));
		System.out.printf("mean(%d,%d) = %.2f\n", num1, num2, meanFunction(num1, num2));
		System.out.printf("gcd(%d,%d) = %d\n", num1, num2, gcdFunction(num1, num2));
		System.out.printf("lcm(%d,%d) = %d\n", num1, num2, lcmFunction(num1, num2));

		scanner.close();
	}

}
