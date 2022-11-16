/* 
 * Methods
 * Working with methods
 * dh
 * Last Change: 10.11.2022
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TestMethods {

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
		int min;
		return min = (a < b) ? a : b;
	}

	// Determines maximum between two integers
	public static int maxFunction(int a, int b) {
		int max;
		return max = (a > b) ? a : b;
	}

	///////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	///////////////////////////////////////////////////////////////////////////////

	// Prime function with only one parameter
	public static void primeFunction(int numToCheck) {
		boolean isPrime = true;
		int counter = numToCheck - 2;

		if (numToCheck < 2) {
			System.out.println("Number is not prime!");
		}

		if (numToCheck == 2) {
			System.out.println(numToCheck + " is prime!");
		}

		for (int factor = 2; factor < numToCheck; factor++) {
			if (numToCheck % factor == 0) {
				isPrime = false;
				System.out.println("Number is not prime!");
				break;
			} else {
				System.out.println(numToCheck + " is prime!");
				counter--;
			}
		}

		if (counter == 0) {
			System.out.println(numToCheck + " is really prime!");
		}

	}

	// Prime function with two integers
	public static List<Integer> primeFun(int a, int b) {
		int start = minFunction(a, b);
		int end = maxFunction(a, b);
		List<Integer> primes = new ArrayList<Integer>();

		for (int numToCheck = start; numToCheck <= end; numToCheck++) {
			int counter = 0;

			if (numToCheck < 2) {
				counter++;
			}

			for (int factor = 2; factor <= numToCheck / 2; factor++) {

				if (numToCheck == 2) {
					primes.add(numToCheck);
					break;
				}

				if (numToCheck % factor == 0) {
					// isPrime = false;
					// System.out.println("Number is not prime!");
					counter++;
					break;
				}

			}

			if (counter == 0) {
				primes.add(numToCheck);
			}

		}

		return primes;

	}

	public static PrimeNumber primeF(int a, int b) {
		PrimeNumber p = new PrimeNumber();
		int start = minFunction(a, b);
		int end = maxFunction(a, b);

		for (int numToCheck = start; numToCheck <= end; numToCheck++) {
			int counter = numToCheck - 2;
			if (numToCheck == 2) {
				p.value = numToCheck;
			}
			for (int factor = 2; factor < numToCheck; factor++) {
				if (numToCheck % factor == 0) {
					// isPrime = false;
					// System.out.println("Number is not prime!");
					break;
				} else {
					// System.out.println(numToCheck + " is prime!");
					counter--;
				}
				if (counter == 0) {
					p.value = numToCheck;
				}
			}
		}

		return p;
	}

	// Checking if number is prime
	public static boolean isPrime(int input) {
		int counter = 0;

		if (input < 2) {
			return false;
		}

		if (input == 2) {
			return true;
		}

		for (int factor = 2; factor <= input / 2; factor++) {

			if (input % factor == 0) {
				counter++;
			}

		}

		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// Prints prime numbers within a range
	public static void newPrimeFunction (int a, int b) {
		int start = minFunction(a, b);
		int end = maxFunction(a, b);
		int numCount = 0;
		int commaCount = 0;
		
		// Create number count
		for (int i = start; i <= end; i++) {
			if(isPrime(i)) {
				numCount++;
			}
		}
		System.out.println("numCount: " + numCount);
		
		commaCount = numCount-1; // 4 (when 5 numbers)
		
		String result = "primes(" + start + "," + end + ") = {";
		System.out.print(result);
		
		for (int i = start; i <= end; i++) {
			if(isPrime(i)) {
				System.out.print(i);
				if(commaCount!=0) {
					System.out.print(", ");
					commaCount--;
				}
			}
			
		}
		// System.out.print(numbers);
		System.out.print("}");
		
		
	}

	///////////////////////////////////////////////////////////////////////////////
	//
	//
	//
	///////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num1 = readNumber(scanner);
		int num2 = readNumber(scanner);

		// gcdFunction(num1, num2);
		// primeFunction(num1, num2);

		// primeFun(num1, num2);

		newPrimeFunction(num1, num2);
	

		// System.out.printf("primes(%d,%d) = {%s}\n", num1, num2, primeFun(num1,
		// num2));

	}

}
