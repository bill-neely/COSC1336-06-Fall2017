
public class TicketTester {

	public static void main(String[] args) {
		Ticket myTicket = new Ticket();
		System.out.println(myTicket.numbers().length == 6);
		boolean unique = true;
		for (int i = 0; i < 1000; i++) {
			Ticket theTicket = new Ticket();
			if (Utility.isUnique(theTicket.numbers()) == false) 
					unique = false;
		}
		System.out.println(unique == true);
	}


}
