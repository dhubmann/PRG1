/*
 * Labtest PRG1
 * Working with Objects
 * Author: Daniel Hubmann
 * Last Change: 23.02.2023
 */

/*
 * The goal of the labtest was to create 5 parts of a program within 3 hours time.
 * (Each part is separated by three '+'s.)
 * 
 * 1st part
 * The user is prompted to enter an amount. An array of Person objects is created with the respective amount.
 * The user is then prompted to enter each Person's email address, height & weight.
 * 
 * 2nd part
 * Entered data is printed to the console in reverse order
 * 
 * 3rd part
 * Each Person's email is printed followed by their Body-Mass-Index.
 * 
 * 4th part
 * The average Body-Mass-Index between the Person objects is printed.
 * 
 * 5th part
 * The given input is encrypted and printed to the console.
 * The value of amount (entered in the 1st part) is added to each character's integer value, shifting it respectively.
 */

import java.util.Scanner;

public class Labtest {

	public static void main(String[] args) {

		runProgram();

	}

	private static Scanner scanner = new Scanner(System.in);
	private static Person[] array;
	private static int AMOUNT;
	private static int counter;
	private static int index;

	// Start program
	public static void runProgram() {

		// 1 - Create Person Array & Read Data
		readAmount(); // "Enter amount: "
		printSeparator();

		createArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = new Person();
			index = i;
			readEmail(); // "Enter email: "
			readHeight(); // "Enter height: "
			readWeight(); // "Enter weight: "
		}

		// 2 - Print Data in Reverse Order
		printSeparator();
		printData();

		// 3 - Print Email & BMI of each Person
		printSeparator();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i].getEmail());
			System.out.print(";");
			System.out.printf("%.2f", array[i].BMI());
			System.out.println();
		}

		// 4 - Print Average BMI between every Person
		printSeparator();
		averageBMI();

		// 5 - Encrypt Data of each Person
		// To-Do: fix - returns integers
		printSeparator();
		encrypt();
		printSeparator();
	}

	public static void encrypt() {

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].getEmail().length(); j++) {
				char email = array[i].getEmail().charAt(j);
				System.out.print(email += AMOUNT);
			}
			System.out.print(";");

			String height = Integer.toString(array[i].getHeight());
			for (int j = 0; j < height.length(); j++) {
				char h = height.charAt(j);
				System.out.print(h += AMOUNT);
			}
			System.out.print(";");

			String weight = Integer.toString(array[i].getWeight());
			for (int j = 0; j < weight.length(); j++) {
				char w = weight.charAt(j);
				System.out.print( w += AMOUNT);
			}
			System.out.print("\n");

		}
	}

	// Calculates and prints average Body-Mass-Index of Person objects
	public static void averageBMI() {
		
		double avg = 0;
		for (int i = 0; i < array.length; i++) {
			avg += array[i].BMI();
		}
		System.out.printf("%.2f\n", avg / AMOUNT);
		
	}

	public static void printData() {

		for (int i = array.length - 1; i >= 0; i--) {
			String email = array[i].getEmail();
			int height = array[i].getHeight();
			int weight = array[i].getWeight();

			System.out.print(email);
			System.out.print(";");
			System.out.print(height);
			System.out.print(";");
			System.out.print(weight);
			System.out.println();
		}

	}

	public static void readAmount() {

		int temp = 0;
		while (true) {
			try {
				System.out.print("Enter amount: ");
				temp = Integer.parseInt(scanner.nextLine());
				if (temp < 0) {
					throw new Exception();
				}
				AMOUNT = temp;
				break;
			} catch (Exception e) {
				continue;
			}
		}

	}

	public static void readEmail() {

		while (true) {
			try {
				System.out.print("Enter email: ");
				array[index].setEmail(scanner.nextLine());

				if (array[index].getEmail().length() < 1) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				continue;
			}
		}
	}

	public static void readHeight() {

		while (true) {
			try {
				System.out.print("Enter height: ");
				array[index].setHeight(Integer.parseInt(scanner.nextLine()));
				if (array[index].getHeight() < 0) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				continue;
			}
		}
	}

	public static void readWeight() {
		while (true) {
			try {
				System.out.print("Enter weight: ");
				array[index].setWeight(Integer.parseInt(scanner.nextLine()));
				if (array[index].getWeight() < 0) {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				continue;
			}
		}
	}

	public static void createArray() {
		array = new Person[AMOUNT];
	}

	public static void printSeparator() {
		System.out.println("+++");
	}

}
