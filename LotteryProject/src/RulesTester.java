
public class RulesTester {

	public static void main(String[] args) {
		int[] winningNumbers = new int[] {10, 13, 17, 42, 47, 50};
		Ticket match3 = new Ticket(new int[] {10, 13, 17, 1, 2, 3});
		System.out.println(Rules.isWinner(match3, winningNumbers).numbersMatched == 3);
		System.out.println(Rules.isWinner(match3, winningNumbers).prize == 2);		
	}

}
