
public class PalindromeExercise {

	public static void main(String[] args) {
		System.out.println(stripBlanks("This This").equals("thisthis"));
		System.out.println(reversed("This This").equals("sihT sihT"));
		System.out.println(isPalindrome("racecar") == true);
		System.out.println(isPalindrome("Was it a CAR or a CAT I saw") == true);
	}

	private static String stripBlanks(String phrase) {
		String preppedString = "";
		// read the string 
		for (int i=0; i < phrase.length(); i++) {
			// If the character is not blank, add it to preppedString
			if (phrase.charAt(i) != ' ') {
				preppedString = preppedString + phrase.charAt(i);
			}
		}
		return preppedString.toLowerCase();
	}

	private static Object reversed(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean isPalindrome(String phrase) {
		// strip spaces and capitalization from phrase
		String testPhrase = stripBlanks(phrase);
		// compare phrase to reversed phrase
		return testPhrase.equals(reversed(testPhrase));
	}

	private static String prepareString(String phrase) {
		String preppedString = "";
		// read the string end to beginning
		for (int i=phrase.length() - 1; i >= 0; i--) {
			// If the character is not blank, add it to preppedString
			if (phrase.charAt(i) != ' ') {
				preppedString = preppedString + phrase.charAt(i);
			}
		}
		return preppedString.toLowerCase();
	}

	
}
