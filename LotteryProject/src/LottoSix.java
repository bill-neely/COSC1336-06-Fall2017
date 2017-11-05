
public class LottoSix {
	
	public final int numbersPerDraw;
	public final int minimumNumber;
	public final int maximumNumber;
	public final int ticketCost;
	public final int[] numberofWinnersByMatch;
	public final int[] prizeMoneyByMatch;
	public Ticket[] ticketsSold;
	public int[] winningNumbers;
	public Rules theRules;
	
	public LottoSix() {
		this.theRules = new Rules();
		this.numbersPerDraw = 6;
		this.minimumNumber = 1;
		this.maximumNumber = 50;
		this.ticketCost = 1;
		this.numberofWinnersByMatch = new int[7];
		this.prizeMoneyByMatch = new int[7];		
	}

	public void calculateWinners() {
		for (Ticket aTicket : ticketsSold ) {
			int numbersMatched = this.theRules.howManyNumbersMatch(aTicket, winningNumbers);
			this.numberofWinnersByMatch[numbersMatched]++; 
			int prize = this.theRules.prizeFor(numbersMatched);
			this.prizeMoneyByMatch[numbersMatched] += prize;			
		}
	}

	public void sellTickets(int toSell) {
		this.ticketsSold = new Ticket[toSell];
		for (int i = 0; i < this.ticketsSold.length; i++) 
			this.ticketsSold[i] = new Ticket(this.numbersPerDraw, this.minimumNumber, this.maximumNumber);
	}

	public void drawNumbers() {
		this.winningNumbers = Utility.uniqueArrayInt(this.numbersPerDraw, this.minimumNumber, this.maximumNumber);
	}

	public int totalPrizes() {
		int totalPrizes = 0;
		for (int prize : this.prizeMoneyByMatch)
			totalPrizes += prize;
		return totalPrizes;
	}

	public int profit() {
		return this.totalSales() - this.totalPrizes();
	}

	public void runTheGame(int ticketsToSell) {
		this.sellTickets(ticketsToSell);
		this.drawNumbers();
		this.calculateWinners();		
	}

	public int totalSales() {
		return this.ticketsSold.length * this.ticketCost;
	}

}
