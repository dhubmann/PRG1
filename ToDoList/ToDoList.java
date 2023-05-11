/*
 * ToDoList
 * Application
 * Author: Daniel Hubmann
 * Last Change: 10.04.2023
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

	public static void main(String[] args) {

		application();

	}

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<String> list = new ArrayList<String>();
	private static boolean run;
//	private static int index;

	// Application
	public static void application() {

		run = true;
		while (run) {

			try {

				menu();
				int cmd = Integer.parseInt(scanner.nextLine());
				if (!(cmd >= 1 && cmd <= 5)) {
					throw new Exception();
				}
				commands(cmd);

			} catch (Exception e) {
				continue;
			}

		}

	}

	// Menu
	public static void menu() {

		System.out.println("1 - Add Entry");
		System.out.println("2 - Remove Entry");
		System.out.println("3 - Undo Last Change");
		System.out.println("4 - Print Entries");
		System.out.println("5 - Quit");
		System.out.print("> ");

	}

	public static void commands(int cmd) {

		switch (cmd) {
		case 1:
			addEntry();
			break;
		case 2:
			removeEntry();
			break;
		case 3:
			// undoLastChange();
			break;
		case 4:
			printEntries();
			break;
		case 5:
			run = false;
			break;
		}

	}

	public static void addEntry() {

		while (true) {

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("to-do.txt")))) {

				System.out.print("New Entry ('wq!' to save&quit): ");
				String entry = scanner.nextLine();
				if (entry.length() < 1) {
					throw new Exception("Nothing entered");
				}

				list.add(entry);
				writeToFile(bw);

				if (entry.equals("wq!")) {
					break;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			} finally {
//				try {
//					bw.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}

		}

	}

	public static void writeToFile(BufferedWriter bw) throws IOException {

		for (String s : list) {
			bw.write(s);
			bw.write("\n");
		}

	}

	public static void printEntries() {

		int i = 1;
		for (String s : list) {
			System.out.printf("%d#: %s\n", i++, s);
		}

	}

	public static void removeEntry() {

		while (true) {
			try {

				System.out.print("Enter index of entry to remove: ");
				int index = Integer.parseInt(scanner.nextLine());

				if (index < 1 || index > list.size()) {
					throw new Exception("Invalid index");
				}

				list.remove(index - 1);
				System.out.println("Entry removed");
				break;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		}

	}

}
