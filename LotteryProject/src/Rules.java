
public class Rules {

	public static Result isWinner(Ticket aTicket, int[] winningNumbers) {
		int numberMatched = howManyMatch(aTicket.numbers(), winningNumbers);
		int prize = prizeForMatching(numberMatched);
		return new Result(numberMatched, prize);
	}
	
	public static int prizeForMatching(int numberMatched) {
		if (numberMatched <= 3 )
			return 2;
		if (numberMatched <= 4 )
			return 50;
		if (numberMatched <= 5 )
			return 2500;
		if (numberMatched <= 6 )
			return 1000000;
		return 0;
	}
	
	public static int howManyMatch(int[] winningNumbers, int[] ticketNumbers) {
		int foundMatches = 0;
		for (int i = 0; i < ticketNumbers.length; i++) 
			if (inArray(ticketNumbers[i], winningNumbers))  
				foundMatches++;
		return foundMatches;
	}

	public static boolean inArray(int number, int[] arrayOfNumbers) {
		for (int i = 0; i < arrayOfNumbers.length; i++) 
			if (arrayOfNumbers[i] == number) 
				return true;
		return false;
	}

}
