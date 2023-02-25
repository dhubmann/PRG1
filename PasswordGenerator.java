/*
 * PasswordGenerator
 * Working with integer values of chars and Math.random();
 * Author: Daniel Hubmann
 * Last Change: 21.02.2023
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) {

		run();

	}

	private static String password;
	private static Scanner scanner = new Scanner(System.in);
	private static int length;
	private static ArrayList<String> list = new ArrayList<String>();
	private static int amount;

	public static void run() {

		while (true) {
			try {
				System.out.println("Enter # of Passwords");
				System.out.print("> ");
				amount = Integer.parseInt(scanner.nextLine());
				if (amount < 1) {
					throw new Exception();
				}

				break;
			} catch (Exception e) {
				continue;
			}
		}

		while (true) {
			try {
				System.out.println("Enter Length of Passwords");
				System.out.println("(between 10 and 30 Digits)");
				System.out.print("> ");
				length = Integer.parseInt(scanner.nextLine());
				if (length < 10 || length > 30) {
					throw new Exception();
				}

				for (int i = 0; i < amount; i++) {
					generate();
				}

				passwords();
				break;
			} catch (Exception e) {
				continue;
			}
		}

	}

	// Prints generated passwords from list
	public static void passwords() {
		for (String el : list) {
			System.out.println(el);
		}
	}

	// Generates new password with given length
	public static void generate() {

		password = "";
		for (int i = 1; i <= length; i++) {
			addChar();
		}
		list.add(password);

	}

	// Adds a char from range 33 ('!') to 126 ('~') to password
	public static void addChar() {

		int min = 33;
		int max = 126;
		int range = (max - min) + 1;
		int random = (int) (Math.random() * range) + min;
		char c = (char) random;
		password += c;

	}

}
