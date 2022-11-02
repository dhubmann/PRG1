/* 
 * Methods
 * Working with methods
 * Author: Daniel Hubmann
 * Last Change: 31.10.2022
 */

import java.util.Scanner;

public class TestMethods {

	// What's the point of "return"
	// Should I print to the console and return???

	// MINIMUM
	// returns the minimum between two integers
	public static int min(int a, int b) {
		int min = (a < b) ? a : b;
		System.out.printf("min(%d,%d) = %d\n", a, b, min);
		return min;
	}

	// MAXIMUM
	// returns the maximum between two integers
	public static int max(int a, int b) {
		int max = (a > b) ? a : b;
		System.out.printf("max(%d,%d) = %d\n", a, b, max);
		return max;
	}

	// SUM
	// calculates the sum of two integers
	public static int sum(int a, int b) {
		int sum = a + b;
		System.out.printf("sum(%d,%d) = %d\n", a, b, sum);
		return sum;
	}
	
	// SUM FROM TO
	// calculates sum from minimum to maximum (inclusive(
	public static int sumFromTo(int a, int b) {
		int sum = 0;
		int min = (a < b) ? a : b;
		int max = (a > b) ? a : b;
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		System.out.printf("sumFromTo(%d,%d) = %d\n", a, b, sum);
		return sum;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean invalid = true;
		int num1 = 0;
		int num2 = 0;

		// prompt for first number
		// check if entered value is an integer and greater than 0
		// System.out.println("1st #");
		System.out.print("Enter a positive number: ");
		while (invalid) {
			if (s.hasNextInt()) {
				num1 = s.nextInt();
				if (num1 <= 0) {
					s.nextLine();
					// System.out.println("1st #");
					System.out.print("Enter a positive number: ");
					continue;
				} else {
					invalid = false;
				}
			} else {
				s.nextLine();
				// System.out.println("1st #");
				System.out.print("Enter a positive number: ");
				continue;
			}
		}

		// reset invalid to true to prompt for second number
		// check second value the same way as first value
		invalid = true;
		// System.out.println("2nd #");
		System.out.print("Enter a positive number ");
		while (invalid) {
			if (s.hasNextInt()) {
				num2 = s.nextInt();
				if (num2 <= 0) {
					s.nextLine();
					// System.out.println("1st #");
					System.out.print("Enter a positive number ");
					continue;
				} else {
					invalid = false;
				}
			} else {
				s.nextLine();
				// System.out.println("1st #");
				System.out.print("Enter a positive number ");
				continue;
			}
		}

		// Print solutions
		min(num1, num2);
		max(num1, num2);
		sum(num1, num2);
		sumFromTo(num1, num2);

	}

}
