import java.util.Random;

public class ScrabbleUp {

	public static void main(String[] args) {

		scrabble("Hello World");
		scrabble("password123");
		scrabble("aBCDEfgHIjKlMNopQrSTUvWxyZ");
	}

	public static void scrabble(String str) {

		char[] arrayedStr = str.toCharArray();
		Random random = new Random();

		for (int i = 0; i < str.length(); i++) {

			int j = random.nextInt(i + 1); // 0 - str.length-1
			char temp = arrayedStr[i];
			arrayedStr[i] = arrayedStr[j];
			arrayedStr[j] = temp;

		}
		str = new String(arrayedStr);
		System.out.println(str);
	}

}
