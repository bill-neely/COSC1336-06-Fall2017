
public class FunctionTester {

	public static void main(String[] args) {
		System.out.println(DealerUI.padRight("12345", 10).equals("12345     "));
		System.out.println(DealerUI.padRight("123456789012", 10).equals("1234567890"));
		System.out.println(DealerUI.padRight(123.45f, 10).equals("123.45    "));
		System.out.println(DealerUI.padRight(1, 5).equals("1    "));
	}
}
