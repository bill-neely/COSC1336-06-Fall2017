public class FourMethods {
	
	public static void main(String args[]) {
	    System.out.println(areaOfARectangle(4, 8) == 32);
	    System.out.println(average(23.0f, 45.0f, 90.0f) == 52.666668f);
	    System.out.println(charsAtTheEnd("This is a sentence", 6).equals("ntence"));
	    System.out.println(isPrimeNumber(1) == false);
	    System.out.println(isPrimeNumber(7) == true);
	    System.out.println(isPrimeNumber(9) == false); 
	  }

	private static String charsAtTheEnd(String sentence, int number) {
		return sentence.substring(sentence.length() - (number));
	}

	private static boolean isPrimeNumber(int i) {
		if (i <= 1) {
			return false;
		}
		for (int j = 2; j <= i/2; j++) {
			if (i % j == 0) 
				return false;
		}
		return true;
	}

	private static float average(float f, float g, float h) {
		return (f + g + h) / 3.0f;
	}

	private static int areaOfARectangle(int length, int height) {
		return length * height;
	} 
}
