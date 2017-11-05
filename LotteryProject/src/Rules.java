
public class Rules {

	public int howManyNumbersMatch(Ticket aTicket, int[] winningNumbers) {
		int numberFound = 0;
		for (int i = 0; i < aTicket.numbers().length; i++)
			for (int j = 0; j < winningNumbers.length; j++)
				if (aTicket.numbers()[i] == winningNumbers[j])
					numberFound++;
		return numberFound;
	}

	public int prizeFor(int numbersMatched) {
		if (numbersMatched == 3)
			return 2;
		if (numbersMatched == 4)
			return 50;
		if (numbersMatched == 5)
			return 2500;
		if (numbersMatched == 6)
			return 1000000;
		return 0;
	}

}
