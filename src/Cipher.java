import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Cipher {
	public static void main(String[] args) {

		String sahil = "apple banana jgvj bhjbh      fool";

		System.out.println(Arrays.toString(getwords(sahil)));

		System.out.println(isEnglish(sahil));

		// System.out.println(rotationCipherEncrypt("Hello Sahil",7,ALPHABET));
		// System.out.println();
	}

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.() '\"![]/%-_;?-=:"
			+ '\n' + '\r';
	private static final String SIMPLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	// Set this variable to the default alphabet you wish to use
	private static final String DEFAULT_ALPHABET = ALPHABET;

	/**
	 * Returns plaintext encrypted by the rotation cipher with a shift of
	 * movement.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param plainText
	 *            the plain text to be encrypted.
	 * @param shiftAmount
	 *            the number of characters in ALPHABET to shift by.
	 * @return returns the encrypted plainText.
	 */
	public static String rotationCipherEncrypt(String plainText, int shiftAmount, String alphabet) {
		String newText = "";

		for (int i = 0; i < plainText.length(); i++) {
			int index = alphabet.indexOf(plainText.substring(i, i + 1)); // substring
																			// to
																			// get
																			// letter
																			// in
																			// plaintext,
																			// indexOf
																			// to
																			// get
																			// its
																			// #

			index += shiftAmount; // add shift amount to index

			while (index < 0) {
				index = index + alphabet.length();
			}
			while (index > plainText.length() - 1) {
				index %= alphabet.length();

			}
			newText += alphabet.substring(index, index + 1);

		}

		return newText;
	}

	public static String rotationCipherEncrypt(String plainText, int shiftAmount) {
		return rotationCipherEncrypt(plainText, shiftAmount, DEFAULT_ALPHABET);
	}

	/**
	 * Returns a the result of decrypting cipherText by shiftAmount using the
	 * rotation cipher.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param cipherText
	 *            the encrypted text.
	 * @param shiftAmount
	 *            the key to decrypt the cipher.
	 * @return returns the decrypted cipherText.
	 */
	public static String rotationCipherDecrypt(String cipherText, int shiftAmount, String alphabet) {
		String DecryptedTxt = "";

		for (int i = 0; i < cipherText.length(); i++) {
			int index = alphabet.indexOf(cipherText.substring(i, i + 1));

			index -= shiftAmount;

			while (index < 0) {
				index = index + alphabet.length();
			}
			while (index > cipherText.length() - 1) {
				index %= alphabet.length();

			}

			DecryptedTxt += alphabet.substring(index, index + 1);

		}

		return DecryptedTxt;
	}

	public static String rotationCipherDecrypt(String cipherText, int shiftAmount) {
		return rotationCipherDecrypt(cipherText, shiftAmount, DEFAULT_ALPHABET);
	}

	/**
	 * Returns plaintext encrypted by the vigenere cipher encoded with the
	 * String code
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param plainText
	 *            the plain text to be encrypted.
	 * @param code
	 *            the code to use as the encryption key.
	 * @return returns the encrypted plainText.
	 */
	public static String vigenereCipherEncrypt(String plainText, String code, String alphabet) {
		String encryptedText = "";
		String plainLetter = "";
		int nextCodeLetter = 0;
		int indexPlainLttr = 0;

		for (int i = 0; i < plainText.length(); i++) {
			// get letter at i in plaintext
			plainLetter = plainText.substring(i, i + 1);

			// find the index of plainLetter in alphabet
			indexPlainLttr = alphabet.indexOf(plainLetter);

			// get the letter in String code that has that index
			// find the index of the code letter
			String codeLetter = code.substring(nextCodeLetter, nextCodeLetter + 1);
			nextCodeLetter++;

			if (nextCodeLetter > code.length()-1) {
				nextCodeLetter = 0;
			}

			int shiftIndex = alphabet.indexOf(codeLetter);
			
			if(shiftIndex >= alphabet.length()) {
				shiftIndex = shiftIndex - alphabet.length();
			}
			// shift plainLetter index by that amount
			indexPlainLttr += shiftIndex;
			
			

			// use substring to get that encoded letter out of alphabet
			// add it into your encryptedText output
			encryptedText += alphabet.substring(indexPlainLttr, indexPlainLttr + 1);
		}

		return encryptedText;
	}

	public static String vigenereCipherEncrypt(String plainText, String code) {
		return vigenereCipherEncrypt(plainText, code, DEFAULT_ALPHABET);
	}

	/**
	 * Returns the result of decrypting cipherText with the key code.
	 * 
	 * @param alphabet
	 *            the alphabet to be used for the encryption
	 * @param cipherText
	 *            the encrypted text.
	 * @param code
	 *            the decryption key
	 * @return returns the decrypted cipherText.
	 */
	public static String vigenereCipherDecrypt(String cipherText, String code, String alphabet) {
		String decryptedText = "";
		
		for(int i = 0; i < cipherText.length(); i++) {
			// get letter at i in cipher Text
			
			// find the index of that letter in alphabet
			
			// 
		}
		
		return decryptedText;
	}

	public static String vigenereCipherDecrypt(String cipherText, String code) {
		return vigenereCipherDecrypt(cipherText, code, DEFAULT_ALPHABET);
	}

	/**
	 * returns a copy of the input plaintext String with invalid characters
	 * stripped out.
	 * 
	 * @param plaintext
	 *            The plaintext string you wish to remove illegal characters
	 *            from
	 * @param alphabet
	 *            A string of all legal characters.
	 * @return String A copy of plain with all characters not in alphabet
	 *         removed.
	 */
	private static String stripInvalidChars(String plaintext, String alphabet) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < plaintext.length(); i++) { // loop through plaintext
			if (alphabet.indexOf(plaintext.charAt(i)) >= 0) // get index of char
				b.append(plaintext.charAt(i)); // if it exists, keep it
			else
				// otherwise skip it &
				System.out.println("Stripping letter: \"" + plaintext.charAt(i) // display
																				// a
																				// message
						+ "\"");
		}
		return b.toString();
	}

	/**
	 * returns true if plaintext is valid English.
	 * 
	 * @param plaintext
	 *            the text you wish to test for whether it's valid English
	 * @return boolean returns true if plaintext is valid English.
	 */
	private static boolean isEnglish(String plaintext) {
		String[] words = getwords(plaintext);
		Dictionary d = Dictionary.buildDictionary("C:\\Omar\\eclipse workspace\\CipherBlankTemplate\\words.txt");
		double wordcount = 0;

		for (int i = 0; i < words.length; i++) {
			if (d.isWord(words[i])) {
				wordcount++;
			}
		}

		if ((wordcount / words.length) >= 0.5) {
			return true;
		}

		return false;
	}

	private static String[] getwords(String plaintext) {
		plaintext.trim();
		ArrayList list = new ArrayList();
		list.add(0);

		String space = " ";
		// Search for zeros that have no zeor before it

		if (!plaintext.substring(plaintext.length() - 1, plaintext.length()).equals(" ")) {

			plaintext = plaintext + space;

		}

		for (int i = 0; i < plaintext.length(); i++) {

			if (i != 0) {
				if (plaintext.substring(i, i + 1).equals(" ") && !plaintext.substring(i - 1, i).equals(" ")) {
					list.add(i);
				}
			}
		}

		System.out.println(list);

		String[] words = new String[list.size() - 1];

		for (int i = 0; i < list.size() - 1; i++) {
			String word = plaintext.substring((int) list.get(i), (int) list.get(i + 1));
			words[i] = word.trim();
		}
		return words;
	}

}