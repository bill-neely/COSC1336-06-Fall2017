
public class RulesTester {

	public static void main(String[] args) {
		Rules theRules = new Rules();
		int[] winningNumbers = new int[] {1,2,3,4,5,6};
		Ticket aTicket = new Ticket(new int[] {1,2,3,4,49,50});
		System.out.println(theRules.howManyNumbersMatch(aTicket, winningNumbers) == 4);
		aTicket = new Ticket(new int[] {21,32,33,34,49,50});
		System.out.println(theRules.howManyNumbersMatch(aTicket, winningNumbers) == 0);
		aTicket = new Ticket(new int[] {1,32,33,34,49,50});
		System.out.println(theRules.howManyNumbersMatch(aTicket, winningNumbers) == 1);
	}

}
