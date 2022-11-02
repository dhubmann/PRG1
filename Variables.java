/* 
 * Variables
 * Console output of different variables in specific format
 * Author: Daniel Hubmann
 * Last Change: 13.10.2022
 */

public class Variables {

	public static void main(String[] args) {
	
		java.util.Locale.setDefault(new java.util.Locale("en", "US"));
		
		boolean myBool = true;
		char firstChar = 70;
		char secondChar = 'H';
		byte myByte = 8;
		short myShort = 16;
		int myInt = 32;
		long myLong = 64;
		float myFloat = 32.32f;
		double myDouble = 64.64;
		int myMat = 1130491;
		
		System.out.println("boolean: " + myBool);
		System.out.println("------");
		System.out.printf("%3d\n", myByte);
		System.out.printf("%3d\n", myShort);
		System.out.printf("%3d\n", myInt);
		System.out.printf("%3d\n", myLong);
		System.out.printf("%5.1f\n", myFloat);
		System.out.printf("%5.1f\n", myDouble);
		System.out.println("------");
		System.out.printf("%c%c\n", firstChar, secondChar);
		System.out.println("Matriculation number: " + myMat);

	}

}
