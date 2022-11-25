
import java.util.Scanner;

public class TestGeometricShapes {

	// Creates a new rectangle
	public static void createRectangle() {
		// Print number of rectangle
		Rectangle rectangle = new Rectangle();
		System.out.println("Rectangle #" + rectangle.getNumRec() + ":");

		// Set coordinates
		// change to user input later
		// check input?!?!
		System.out.println("Setting coordinates");
		
		rectangle.getFirstPoint().setX(1);
		rectangle.getFirstPoint().setY(1);
		rectangle.getSecondPoint().setX(4);
		rectangle.getSecondPoint().setY(3);
		
		System.out.println(rectangle.getFirstPoint().x + " " + rectangle.getFirstPoint().y + "...");
		
		System.out.println(rectangle.width());
		System.out.println(rectangle.height());
		System.out.println(rectangle.area());

	}

	// Reads user input for first x in rectangle coordinates
	public static int readRectangleCoords(Scanner scanner) {
		boolean prompt = true;
		int input = 0;
		while (prompt) {
			System.out.print("  First point:  x coordinate: ");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				if (scanner.nextLine().equals("")) {
					prompt = false;
				} else {
					continue;
				}
			} else {
				scanner.nextLine();
			}
		}
		return input;
	}


	// Starts menu with available options
	public static void startMenu() {
		String dash = "-";
		System.out.println(dash.repeat(80));
		System.out.println("Available commands:");
		System.out.println("  \"New rectangle\" - create a new rectangle");
		System.out.println("  \"New circle\" - create a new circle");
		System.out.println("  \"Quit\" - quit program");
		System.out.println(dash.repeat(80));
	}

	// Reads input from user
	public static String readInput(Scanner scanner) {
		boolean prompt = true;
		String newRec = "new rectangle";
		String newCir = "new circle";
		String quit = "quit";
		String input = "";
		while (prompt) {
			System.out.print("> ");
			if (scanner.hasNextLine()) {
				input = scanner.nextLine();

				if (input.equalsIgnoreCase(newRec)) {
					// create new rectangle
					createRectangle();

					// To-Do: get rid of prompt = false
					// keep promptingF
					// only stop prompting when 'quit' is entered
					prompt = false;
				} else if (input.equalsIgnoreCase(newCir)) {
					// create new circle
					// createCircle();
					// keep prompting
					prompt = false;
				} else if (input.equalsIgnoreCase(quit)) {
					// do nothing, just quit
					prompt = false;
				} else {
					// keep prompting
					continue;
				}
			} else {
				scanner.nextLine();
			}
		}
		return input;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		startMenu();

		String input = readInput(scanner);
		// System.out.println(input);

	}

}
