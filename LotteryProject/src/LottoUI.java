import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;

public class LottoUI {

	static Scanner scan = new Scanner(System.in);
    private static NumberFormat formatter;
	
	public static void main(String[] args) {
	    formatter = NumberFormat.getCurrencyInstance();
	    formatter.setMaximumFractionDigits(0);
		ArrayList<LottoSix> gamesPlayed = new ArrayList<LottoSix>();
		do {
			LottoSix theGame = new LottoSix();
			displayWelcomeMessage();
			displayRules(theGame);
			int toSell =  Utility.askForInt(scan, "How many tickets do you want to sell?"); 
			theGame.runTheGame(toSell);
			displayTotalSales(theGame);
			displayWinningNumbers(theGame);
			displayTicketSummary(theGame);
			displayProfit(theGame);
			gamesPlayed.add(theGame);
		} while (playAgain());
		displayGamesPlayedSummary(gamesPlayed);
		System.out.println("Bye!");
		scan.close();
	}

	private static void displayGamesPlayedSummary(ArrayList<LottoSix> gamesPlayed) {
		int overallSales = 0;
		int overallProfit = 0;
		for (LottoSix game : gamesPlayed) {
			overallSales += game.totalSales();
			overallProfit += game.profit();
		}
		System.out.println("You played " + gamesPlayed.size() + " times.");
		System.out.println("You sold " + formatter.format(overallSales) + " worth of tickets.");
		if (overallProfit >= 0)
			System.out.print("Your profit was ");
		else
			System.out.print("You lost ");
		System.out.println(formatter.format(overallProfit));
	}
	
		private static void displayProfit(LottoSix theGame) {
		System.out.println("Total Prize Money is: " + formatter.format(theGame.totalPrizes()));
		if (theGame.profit() >= 0)
			System.out.println("The Lotto made " + formatter.format(theGame.profit()));
		else 
			System.out.println("The Lotto lost " + formatter.format(theGame.profit()));
	}

	private static void displayRules(LottoSix theGame) {
		System.out.println(" Tickets cost " + formatter.format(theGame.ticketCost) + " each.");
		for (int i = 0; i <= theGame.numbersPerDraw; i++) {
			int prize = theGame.theRules.prizeFor(i);
			if (prize != 0)
				System.out.println("  Match " + i + " numbers and win " + formatter.format(prize) + "!");
		}
	}

	public static void displayTicketSummary(LottoSix theGame) {
		for (int i = 0; i < 7; i++)
			System.out.println(theGame.numberofWinnersByMatch[i] + " tickets matched " + i + " numbers and won " + formatter.format(theGame.prizeMoneyByMatch[i]));
	}

	private static void displayTotalSales(LottoSix theGame) {
		System.out.println(theGame.ticketsSold.length + " were sold and raised " + formatter.format(theGame.profit()));
	}

	private static void displayWelcomeMessage() {
		System.out.println("Welcome to the Pick 6 Lottery Game!");
	}

	private static void displayWinningNumbers(LottoSix theGame) {
		System.out.print("The winning numbers are: ");
		for (int number : theGame.winningNumbers)
			System.out.print(number + " ");
		System.out.println();
	}

	private static boolean playAgain() {
		String answer = Utility.askForString(scan, "Do you want to play again (y/n)?");
		return (answer.toLowerCase().equals("y"));
	}
	
}

