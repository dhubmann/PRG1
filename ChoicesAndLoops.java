/* 
 * Choices and loops
 * Working with choices and loops
 * Author: Daniel Hubmann
 * Last Change: 27.10.2022
 */

import java.util.Scanner;

public class ChoicesAndLoops {

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));

		Scanner scanner = new Scanner(System.in);
		int amount = 0;
		// keepPrompting keeps you in the while loop as long as the entered values are
		// invalid
		// when a valid value is entered, it gets you out of the while loop
		boolean keepPrompting = true;
		// counter for while loop in part 2
		int counter = 1;
		// variables to calculate using input values in part 2
		int sum = 0;
		int min = 0;
		int max = 0;
		
		/*
		 * 
		 * if (scanner.hasNextInt()){
		 * 	num = scanner.nextInt();
		 * 	if(scanner.nextLine().equals(""))
		 * 		...
		 * 	else
		 * 		...
		 * }
		 * 
		 */

		// PART 1: ENTER AMOUNT
		System.out.print("Amount: ");
		while (keepPrompting) {
			if (scanner.hasNextInt()) {
				amount = scanner.nextInt();
				if (amount < 1) {
					// System.out.println("Amount less than 1");
					scanner.nextLine();
					System.out.print("Amount: ");
					continue;
				} else {
					keepPrompting = false;
				}
			} else {
				scanner.nextLine();
				System.out.print("Amount: ");
				continue;
			}
		}

		// PART 2: ENTER VALUES
		while (counter <= amount) {
			System.out.print(counter + "#: ");
			if (!scanner.hasNextInt()) {
				scanner.nextLine();
			}
			if (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				sum += value;
				// minimum is initially 0
				// first value has to become minimum to compare with upcoming values
				min = value < min || min == 0 ? value : min;
				max = value > max ? value : max;
				counter++;
			}
		}

		scanner.close();

		// PART 3: PRINT CALCULATIONS
		// sum of values, minimum and maximum
		System.out.println("Sum = " + sum);
		System.out.println("Minimum = " + min);
		System.out.println("Maximum = " + max);

		// mean, reciprocal of mean and additive inverse of mean
		double mean = (sum * 1.0) / amount;
		System.out.printf("Mean = %.2f\n", mean);
		System.out.printf("Reciprocal of mean = %.2f\n", (1 / mean));
		System.out.println("Additive inverse of mean = " + (mean * (-1)));

		// absolute value of mean
		double absValOfMean = mean >= 0 ? mean : (mean * (-1));
		System.out.println("Absolute value of mean = " + absValOfMean);

		// difference between minimum and maximum
		int delta = max - min;
		System.out.println("Delta of minimum and maximum = " + delta);

		// sum of all numbers between minimum and maximum
		// (including minimum and maximum)
		int totalSum = 0;
		for (int i = min; i <= max; i++) {
			totalSum += i;
		}
		System.out.println("Sum of numbers from minimum to maximum = " + totalSum);

	}

}
