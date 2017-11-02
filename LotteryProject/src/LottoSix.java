
public class LottoSix {

	private Ticket[] ticketsSold;
	public int[] prizeMoney;
	public int[] matchedTickets;
	public int[] winningNumbers;
	
	public LottoSix() {
		this.prizeMoney = new int[7];
		this.matchedTickets = new int[7];
	}
	
	public void checkForWinners() {
		for (Ticket aTicket : this.ticketsSold) {
			Result result = Rules.isWinner(aTicket, winningNumbers);
			prizeMoney[result.numbersMatched] += result.prize;
			matchedTickets[result.numbersMatched] ++;
		}
	}

	
}
