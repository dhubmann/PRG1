/* 
 * Geometric Shapes
 * Working with Classes and Objects
 * Author: Daniel Hubmann
 * Last Change: 22.12.2022
 */

import java.util.Scanner;

public class GeometricShapes {

	public static void main(String[] args) {

		java.util.Locale.setDefault(new java.util.Locale("en", "US"));

		runProgram();

	}

	// Static variables
	private static Scanner scanner;

	// Starts program
	public static void runProgram() {
		scanner = new Scanner(System.in);
		while (true) {
			menu();
			if (scanner.hasNextLine()) {
				String input = scanner.nextLine();
				if (input.equalsIgnoreCase("new rectangle")) {
					createRectangle();
				} else if (input.equalsIgnoreCase("new circle")) {
					createCircle();
				} else if (input.equalsIgnoreCase("quit")) {
					break;
				}
			} else {
				scanner.nextLine();
			}
		}
		scanner.close();
	}

	// Starts menu with available options
	public static void menu() {
		System.out.println("-".repeat(80));
		System.out.println("Available commands:");
		System.out.println("  \"New rectangle\" - create new rectangle");
		System.out.println("  \"New circle\" - create new circle");
		System.out.println("  \"Quit\" - quit program");
		System.out.println("-".repeat(80));
		System.out.print("> ");
	}

	// Creates new rectangle and prints it to console
	public static void createRectangle() {
		Rectangle rectangle = new Rectangle();
		System.out.println("Rectangle #" + Rectangle.getNumRectangles() + ":");

		// Set coordinates
		int x1 = checkInput("  First point:  x coordinate: ");
		rectangle.getFirstPoint().setX(x1);

		int y1 = checkInput("  First point:  y coordinate: ");
		rectangle.getFirstPoint().setY(y1);

		int x2 = checkInput("  Second point: x coordinate: ");
		rectangle.getSecondPoint().setX(x2);

		int y2 = checkInput("  Second point: y coordinate: ");
		rectangle.getSecondPoint().setY(y2);

		// Print rectangle
		rectangle.dimensions();
		rectangle.draw();

	}

	// Creates new circle and prints it to console
	public static void createCircle() {
		// Print number of circles created
		Circle circle = new Circle();
		System.out.println("Circle #" + Circle.getNumCircles() + ":");

		// Read user input and set coordinates and radius
		int x = checkInput("  Center: x coordinate: ");
		circle.getCenter().setX(x);

		int y = checkInput("  Center: y coordinate: ");
		circle.getCenter().setY(y);

		int radius = checkRadius("  Radius: ");
		circle.setRadius(radius);

		// Print circle
		circle.dimensions();
		circle.draw();

	}

	// Checks user input to set points
	public static int checkInput(String prompt) {
//		while (true) {
//			System.out.print(prompt);
//			if (scanner.hasNextInt()) {
//				int input = scanner.nextInt();
//				if (scanner.nextLine().equals("")) {
//					return input;
//				}
//			} else {
//				scanner.nextLine();
//			}
//		}

		while (true) {
			try {
				System.out.print(prompt);
				int input = Integer.parseInt(scanner.nextLine());

				return input;

			} catch (Exception e) {
				continue;
			}
		}
	}

	// Checks user input to set radius
	public static int checkRadius(String prompt) {
		while (true) {
			System.out.print(prompt);
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				if (scanner.nextLine().equals("") && input >= 0) {
					return input;
				}
			} else {
				scanner.nextLine();
			}
		}
	}

}
