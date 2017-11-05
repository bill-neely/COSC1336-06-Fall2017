import java.util.Scanner;

public class Utility {
	
	public static int askForInt(Scanner scan, String prompt) {
		do {
			try {
				String answer = Utility.askForString(scan, prompt);
				int number = Integer.parseInt(answer);
				return number;
			} catch (NumberFormatException ex) {
				System.out.println("---Sorry, you must enter an Integer.");
			}
		} while(true);
	}

	public static String askForString(Scanner scan, String prompt) {
		System.out.println(prompt);
		String answer = scan.nextLine();
		return answer;
	}

	public static int[] uniqueArrayInt(int length, int lower, int upper) {
		int[] numbers = new int[length];
		do {
			for (int i = 0; i < numbers.length; i++)
				numbers[i] = randBetween(lower, upper);
		} while (!Utility.isUnique(numbers));	
		return numbers;
	}

	public static int randBetween(int lower, int upper) {
		return (int) (Math.random() * ((upper-lower) + 1)) + lower;
	}

	public static boolean isUnique(int arr[]) {
	    for (int i = 0; i <= arr.length-2; i++)
	      for (int j = i + 1; j < arr.length; j++)
	        if (arr[i] == arr[j])
	          return false;
	    return true;
	  }
	
}
