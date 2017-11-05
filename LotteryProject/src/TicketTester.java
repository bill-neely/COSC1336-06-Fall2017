
public class TicketTester {

	public static void main(String[] args) {
		int howMany = 6;
		int lower = 1;
		int upper = 50;
		Ticket myTicket = new Ticket(howMany, lower, upper);
		System.out.println(myTicket.numbers().length == howMany);
		boolean testResult = true;
		for (int i=0; i<1000; i++) {
			Ticket theTicket = new Ticket(howMany, lower, upper);
			if (!Utility.isUnique(theTicket.numbers()))
					testResult = false;
		}			
		System.out.println(testResult == true);
	}
}
