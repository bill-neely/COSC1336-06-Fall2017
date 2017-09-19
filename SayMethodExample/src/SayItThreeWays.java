
public class SayItThreeWays {

	public static void main(String[] args) {
		say("This is a String");
		say(1000);
		say("$", 3.15f);
	}

	private static void say(String symbol, float number) {
		say(symbol + Float.toString(number));
	}
	
	private static void say(int number) {
		say(Integer.toString(number));
	}

	private static void say(String phrase) {
		System.out.println(phrase);
	}

}
