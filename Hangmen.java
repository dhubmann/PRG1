/*
 * Hangman
 * Working with FilesIO & Command Line Arguments
 * Author: Daniel Hubmann
 * Last Change: 01.02.2022
 */

import java.io.*;
import java.util.*;

public class Hangmen {

	public static void main(String[] args) {

		try {
			readWords(args[0]);
			gameplay();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: No file name given!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}

		// DRAWING.get(1);

	}

	private static List<String> words = new ArrayList<String>();
	private static final HashMap<Integer, String> DRAWING = new HashMap<Integer, String>();

	static {
		DRAWING.put(1, "===");
		DRAWING.put(2, " |\n |\n |\n |\n===");
		DRAWING.put(3, "  ____\n |\n |\n |\n |\n===");
		DRAWING.put(4, "  ____\n |/\n |\n |\n |\n===");
		DRAWING.put(5, "  ____\n |/  |\n |\n |\n |\n===");
		DRAWING.put(6, "  ____\n |/  |\n |   0\n |\n |\n===");
		DRAWING.put(7, "  ____\n |/  |\n |   0\n |   |\n |\n===");
		DRAWING.put(8, "  ____\n |/  |\n |   0\n |   |\n |  /\n===");
		DRAWING.put(9, "  ____\n |/  |\n |   0\n |   |\n |  / \\\n===");
		DRAWING.put(10, "  ____\n |/  |\n |   0\n |  /|\n |  / \\\n===");
		DRAWING.put(11, "  ____\n |/  |\n |   0\n |  /|\\\n |  / \\\n===");
	}

	private static int wordCount = 0;
	private static String wordToGuess;
	private static String currentState;
	private static int misses;
	private static int wins = 0;
	private static boolean incorrect;
	private static boolean gameOver = false;
	private static List<Character> wrongGuesses = new ArrayList<Character>();
	private static Scanner scanner = new Scanner(System.in);
	private static final String DOUBLE_DASH = "=";
	private static final String SINGLE_DASH = "-";
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final int MAX_MISSES = 11;

	// Reads words from text file
	// To-Do: exceptions
	private static void readWords(String input) throws Exception {

		File file = new File(input);
		if (file.exists() == false) {
			throw new FileNotFoundException("Error: File not found!");
		}

		// Adds words to list
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line;
			while ((line = br.readLine()) != null) {
				// To-Do: change to better alternative?
				// check if line is empty
				line = line.trim();
				if (line.isEmpty()) {
					continue;
				} else {
					words.add(line);
				}
			}
			Collections.shuffle(words);
		} catch (IOException e) {
			System.out.println("Error: Could not read file!");
		}

		// Checks if file was empty
		if (words.size() == 0) {
			throw new Exception("Error: Empty file!");
		}

		// Checks for corrupt file
		// To-Do: change checking for invalid characters
		// doesn't work yet ?! (codePost worked)
		Iterator<String> it = words.iterator();
		if (it.next().matches("[a-zA-Z]+") == false) {
			throw new Exception("Error: Corrupt file!");
		}

	}

	// Prints menu below title (printed every guess)
	public static void gameMenu() {

		System.out.println();
		System.out.print("Word:");
		for (int i = 0; i < wordToGuess.length(); i++) {
			System.out.print(" ");
			System.out.print(currentState.charAt(i));
		}

		System.out.println();
		if (misses == 0) {
			System.out.println("Misses (0/11)");
		} else {
			System.out.printf("Misses (%d/11): ", misses);
			for (int i = 0; i < wrongGuesses.size(); i++) {
				System.out.print(wrongGuesses.get(i));
				if (i == wrongGuesses.size() - 1) {
					break;
				} else {
					System.out.print(", ");
				}
			}
			System.out.println();
		}

	}

	// Starts new game (# of rounds is equal to # of words to guess)
	public static void gameplay() {

		while (!gameOver) {
			titleMenu();
			roundMenu();
			// reset variables before every round
			misses = 0;
			incorrect = true;
			wrongGuesses.clear();

			while (misses < MAX_MISSES && incorrect) {

				try {
					gameMenu();
					// prompt
					System.out.print("Next guess: ");
					String input = scanner.nextLine();
					System.out.println();

					// check for valid input
					// throws exception?!
					checkValidity(input);

					// check if input is in wordToGuess
					checkInput(input);
//					if (wordToGuess.toLowerCase().contains(input.toLowerCase())) {
//						replaceChar(input);
//						if (currentState.equals(wordToGuess)) {
//							incorrect = false;
//						}
//					} else {
//						wrongGuesses.add(input.toUpperCase().charAt(0));
//						misses++;
//					}

					// keep printing drawing if there are misses
					if (misses != 0) {
						System.out.println(DRAWING.get(misses));
						System.out.println();
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

//				gameMenu();
//				// prompt
//				System.out.print("Next guess: ");
//
//				// To-Do: change to try-catch
//				if (scanner.hasNextLine()) {
//					String input = scanner.nextLine();
//					System.out.println();
//
//					// check if input is valid
//					if (!checkInput(input)) {
//						continue;
//					}
//					// check if input is in wordToGuess
//					if (wordToGuess.toLowerCase().contains(input.toLowerCase())) {
//						replaceChar(input);
//						if (currentState.equals(wordToGuess)) {
//							incorrect = false;
//						}
//					} else {
//						wrongGuesses.add(input.toUpperCase().charAt(0));
//						misses++;
//					}
//
//					// keep printing drawing if there are misses
//					if (misses != 0) {
//						System.out.println(DRAWING.get(misses));
//						System.out.println();
//					}
//
//				} else {
//					scanner.nextLine();
//				}
			}

			// end of round
			gameMenu();
			System.out.println();
			printStatement();

			// game is over when every word was played
			if (wordCount == words.size()) {
				scoreMenu();
				gameOver = true;
			}

		}
	}

	// Replaces character in currentState
	public static void replaceChar(String input) {
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.toLowerCase().charAt(i) == input.toLowerCase().charAt(0)) {
				currentState = currentState.substring(0, i) + wordToGuess.charAt(i) + currentState.substring(i + 1);
			}
		}
	}

	// Checks for invalid input
	// To-Do: testing
//	public static boolean checkInputOld(String input) {
//		if (input.length() != 1) {
//			System.out.println("Invalid input!");
//			System.out.println();
//		} else if (ALPHABET.indexOf(input.toLowerCase()) == -1) {
//			System.out.println("Invalid character!");
//			System.out.println();
//			// To-Do: keep testing (fixed a few things already)
//		} else if (wrongGuesses.contains(input.toUpperCase().charAt(0))
//				|| currentState.toLowerCase().contains(input.toLowerCase())) {
//			System.out.println("Character already guessed!");
//			System.out.println();
//		} else {
//			return true;
//		}
//		return false;
//	}

	// Checks if input is in wordToGuess
	// To-Do: testing
	public static void checkInput(String input) {
		if (wordToGuess.toLowerCase().contains(input.toLowerCase())) {
			replaceChar(input);
			if (currentState.equals(wordToGuess)) {
				incorrect = false;
			}
		} else {
			wrongGuesses.add(input.toUpperCase().charAt(0));
			misses++;
		}
	}

	// Checks for valid input
	// To-Do: testing
	public static void checkValidity(String input) throws Exception {
		if (input.length() != 1) {
			throw new Exception("Invalid input!");
		} else if (ALPHABET.indexOf(input.toLowerCase()) == -1) {
			throw new Exception("Invalid character!");
			// To-Do: keep testing (fixed a few things already)
		} else if (wrongGuesses.contains(input.toUpperCase().charAt(0))
				|| currentState.toLowerCase().contains(input.toLowerCase())) {
			throw new Exception("Character already guessed!");
		}
	}

	public static void printSeparatorLine(String s) {
		System.out.println(s.repeat(80));
	}

	// Prints menu title (printed once at the start)
	public static void titleMenu() {
		printSeparatorLine(DOUBLE_DASH);
		System.out.printf("HANGMEN " + "(%d Word(s))\n", words.size());
	}

	// Prints top of current round
	public static void roundMenu() {
		printSeparatorLine(SINGLE_DASH);
		wordToGuess = words.get(wordCount);
		currentState = "_".repeat(wordToGuess.length());
		System.out.printf("Word #%d:\n", ++wordCount);
		System.out.println();
	}

	// Prints statement at end of round
	public static void printStatement() {
		if (!incorrect) {
			System.out.println("YOU WIN!");
			wins++;
		} else {
			System.out.println("YOU LOSE!");
		}
	}

	// Prints score menu (printed once at the end)
	public static void scoreMenu() {
		printSeparatorLine(DOUBLE_DASH);
		System.out.printf("WINS: %d/%d", wins, wordCount);
		System.out.println();
	}

}
