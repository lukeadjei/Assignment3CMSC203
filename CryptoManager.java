package assignment3Package;
/*
 * Class: CMSC203 
 * Instructor:Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 10/25/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Luke Adjei
*/



/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		
		int length = plainText.length();
		
		for (int i = 0; i < length-1; i++) {
			int currentCharacterAscii = (int)plainText.charAt(i);
			
			if (currentCharacterAscii < (int)LOWER_RANGE || currentCharacterAscii > (int)UPPER_RANGE){
				return false;
			}
			
		}
		return true;
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		String newString = "";
		
		if(isStringInBounds(plainText) == false) {
			return "The selected string is not in bounds, Try again.";
		}
		
		if (key < LOWER_RANGE) {
			while (key < LOWER_RANGE) {
				key += 64;
			}
		}
		else if (key > UPPER_RANGE) {
			while (key > UPPER_RANGE) {
				key -= 64;
			}
		}

		for(int i = 0; i < plainText.length(); i++) {
			int currentLetter = (int)plainText.charAt(i);
			currentLetter += key;
			
			while (currentLetter > UPPER_RANGE) {
				currentLetter -= 64;
			}
			
			
			newString += (char)currentLetter;
		}
		
		
		return newString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		String modifiedString = bellasoStr;
		
		if (plainText.length() != bellasoStr.length()) {
			if (bellasoStr.length() < plainText.length()) {
				int i = 0;
				
				while (modifiedString.length() != plainText.length()) {
					
					modifiedString += bellasoStr.charAt(i);
					i++;
					
					if (i == bellasoStr.length()) {
						i = 0;
					}
				}
			}
			else {
				modifiedString = modifiedString.substring(0, plainText.length());
			}
			
		}
		
		
		String newString = "";
		
		for(int i = 0; i < modifiedString.length(); i++) {
			
			
			int currentAscii = ((int)modifiedString.charAt(i) + (int)plainText.charAt(i));
		
			while (currentAscii > (int)UPPER_RANGE) {
				currentAscii -= 64;
			}
			while (currentAscii < (int)LOWER_RANGE) {
				currentAscii += 64;
			}
			
			newString += (char)currentAscii;	
		}
		return newString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String newString = "";
		
		if (key < LOWER_RANGE) {
			while (key < LOWER_RANGE) {
				key += 64;
			}
		}
		else if (key > UPPER_RANGE) {
			while (key > UPPER_RANGE) {
				key -= 64;
			}
		}

		for(int i = 0; i < encryptedText.length(); i++) {
			int currentLetter = (int)encryptedText.charAt(i);
			currentLetter -= key;
			
			while (currentLetter < LOWER_RANGE) {
				currentLetter += 64;
			}
			
			
			newString += (char)currentLetter;
		}
		
		
		return newString;

	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		String modifiedString = bellasoStr;
	
		if (encryptedText.length() != bellasoStr.length()) {
			
			if (bellasoStr.length() < encryptedText.length()) {
				int i = 0;
				
				while (modifiedString.length() != encryptedText.length()) {
					
					modifiedString += bellasoStr.charAt(i);
					i++;
					
					if (i == bellasoStr.length()) {
						i = 0;
					}
					
				}
			}
			else {
				modifiedString = modifiedString.substring(0, encryptedText.length());
			}
			
		}
		
		String newString = "";
		
		for(int i = 0; i < encryptedText.length(); i++) {
			
			
			int currentAscii = ((int)encryptedText.charAt(i) - (int)modifiedString.charAt(i));
		
			while (currentAscii < (int)LOWER_RANGE) {
				currentAscii += 64;
			}
			
			while (currentAscii > (int)UPPER_RANGE) {
				currentAscii -= 64;
			}
			newString += (char)currentAscii;	
		}
		return newString;
	}
}
