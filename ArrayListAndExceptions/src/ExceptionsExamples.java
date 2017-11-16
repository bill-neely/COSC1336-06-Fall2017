import java.util.Scanner;

public class ExceptionsExamples {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int number = askForInt(1, 6);
		System.out.println("You entered: " + number);
	}

	public static int askForInt(int min, int max) {
		while (true) {
			try {
				System.out.println("Enter a number between " + min + " and " + max);
				int answer = Integer.parseInt(scan.nextLine());
				if (answer < min || answer > max)
					throw new IllegalArgumentException();
				return answer;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid value:");
			} catch (IllegalArgumentException ex) {
				System.out.println("You must enter a number in range.");
			}
		}
	}
}
