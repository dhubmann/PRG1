/* 
 * Methods
 * Working with methods
 * Author: Daniel Hubmann
 * Last Change: 23.11.2022
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
	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	// Determines maximum between two integers
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	// Calculates sum of two integers
	public static int sum(int a, int b) {
		return a + b;
	}

	/*
	 * Calculates sum of all numbers from first to second integer including both
	 * integers
	 */
	public static int sumFromTo(int a, int b) {
		int min = min(a, b);
		int max = max(a, b);
		int sumFromTo = 0;
		for (int i = min; i <= max; i++) {
			sumFromTo += i;
		}
		return sumFromTo;
	}

	// Calculates delta between two integers
	public static int delta(int a, int b) {
		int min = min(a, b);
		int max = max(a, b);
		return max - min;
	}

	// Calculates mean of two integers
	public static float mean(int a, int b) {
		return (a + b) / 2.0f;
	}

	// Calculates greatest common divisor between two integers
	public static int greatestCommonDivisor(int a, int b) {
		int min = min(a, b);
		int max = max(a, b);
		int result = 1;
		while (result != 0) {
			result = max - min;
			max = max(result, min);
			min = min(result, min);
		}
		return max;
	}

	// Calculates least common multiple between two integers
	public static int leastCommonMultiple(int a, int b) {
		int lcd = (a * b) / greatestCommonDivisor(a, b);
		return lcd;
	}

	// Checks if the given value is a prime number
	public static boolean isPrime(int input) {
		if (input == 1) {
			return false;
		}
		if (input == 2 || input == 3) {
			return true;
		}
		for (int factor = 2; factor <= input / 2; factor++) {
			if (input % factor == 0) {
				return false;
			}
		}
		return true;
	}

	// Prints prime numbers within a range of two integers including both integers
	public static void primes(int a, int b) {
		int start = min(a, b);
		int end = max(a, b);
		int primeCount = 0;
		int commaCount = 0;
		// Determines amount of prime numbers (and commas) for print format
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				primeCount++;
			}
		}
		commaCount = primeCount - 1;
		// Print statement
		String result = "primes(" + start + "," + end + ") = {";
		System.out.print(result);
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i);
				if (commaCount != 0) {
					System.out.print(", ");
					commaCount--;
				}
			}
		}
		System.out.print("}");
	}

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));

		Scanner scanner = new Scanner(System.in);

		int num1 = readNumber(scanner);
		int num2 = readNumber(scanner);

		min(num1, num2);
		max(num1, num2);

		System.out.printf("min(%d,%d) = %d\n", num1, num2, min(num1, num2));
		System.out.printf("max(%d,%d) = %d\n", num1, num2, max(num1, num2));
		System.out.printf("sum(%d,%d) = %d\n", num1, num2, sum(num1, num2));
		System.out.printf("sumFromTo(%d,%d) = %d\n", num1, num2, sumFromTo(num1, num2));
		System.out.printf("delta(%d,%d) = %d\n", num1, num2, delta(num1, num2));
		System.out.printf("mean(%d,%d) = %.2f\n", num1, num2, mean(num1, num2));
		System.out.printf("gcd(%d,%d) = %d\n", num1, num2, greatestCommonDivisor(num1, num2));
		System.out.printf("lcm(%d,%d) = %d\n", num1, num2, leastCommonMultiple(num1, num2));
		primes(num1, num2);

		scanner.close();
	}

}
