/* 
 * Choices and loops
 * Working with choices and loops
 * Author: Daniel Hubmann
 * Last Change: 14.11.2022
 */

import java.util.Scanner;

public class ChoicesAndLoops {

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));
		
		Scanner scanner = new Scanner(System.in);
		int amount = 0;
		boolean keepPrompting = true;
		int counter = 1;
		int sum = 0;
		int min = 2147483647;
		int max = -2147483648;

		// PART 1: ENTER AMOUNT
		while (keepPrompting) {
			System.out.print("Amount: ");
			if (scanner.hasNextInt()) {
				amount = scanner.nextInt();
				if (amount > 0 && scanner.nextLine().equals("")) {
					keepPrompting = false;
				} else if (amount < 1 && scanner.nextLine().equals("")) {
					continue;
				} else {
					continue;
				}
			} else {
				scanner.nextLine();
			}
		}

		// TO-DO: Min Max Berechnung fixen
		// PART 2: ENTER VALUES
		while (counter <= amount) {
			System.out.print(counter + "#: ");
			if (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				if (scanner.nextLine().equals("")) {
					sum += value;
					min = value < min ? value : min;	
					max = value > max ? value : max;
					counter++;
				} 
			} else {
				scanner.nextLine();
			}
		}

		scanner.close();

		// PART 3: PRINT CALCULATIONS
		System.out.println("Sum = " + sum);
		System.out.println("Minimum = " + min);
		System.out.println("Maximum = " + max);

		double mean = (sum * 1.0) / amount;
		System.out.printf("Mean = %.2f\n", mean);
		System.out.printf("Reciprocal of mean = %.2f\n", (1 / mean));
		System.out.printf("Additive inverse of mean = %.2f\n", (mean*(-1)));
		
		double absValOfMean = mean >= 0 ? mean : (mean * (-1));
		System.out.printf("Absolute value of mean = %.2f\n", absValOfMean);

		int delta = max - min;
		System.out.println("Delta of minimum and maximum = " + delta);

		int totalSum = 0;
		for (int i = min; i <= max; i++) {
			totalSum += i;
		}
		System.out.println("Sum of numbers from minimum to maximum = " + totalSum);

	}

}
