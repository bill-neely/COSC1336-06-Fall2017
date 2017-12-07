import java.util.Scanner;

public class YahtzeeUI {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			Yahtzee theGame = new Yahtzee();
			while (theGame.isNotOver()) {
				System.out.println();
				takeATurn(theGame);
			}
			displayFinalScore(theGame);
		} while (playAgain());
		scan.close();
	}

	private static void askEliminateOrPickScore(Yahtzee theGame) {
		String choice = askForString("    (P)ick a score, (R)oll Again");
		if (choice.toUpperCase().equals("P"))
			pickAScore(theGame);
		else
			eliminateDice(theGame);
	}

	private static int askForInt(String prompt) {
		while (true) {
			try {
				String choice = askForString(prompt);
				int answer = Integer.parseInt(choice);
				return answer;
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a valid number");
			}
		}
	}

	private static String askForString(String prompt) {
		System.out.println(prompt);
		return scan.nextLine();
	}

	private static void displayDice(Yahtzee theGame) {
		System.out.print("  ");
		for (Die aDie : theGame.Dice()) {
			System.out.print(aDie.sideUp + "\t");
		}
		System.out.println();
	}

	private static void displayFinalScore(Yahtzee theGame) {
		displayScoreCard(theGame);
		System.out.println("Final Score: " + theGame.scoreCard().finalScore());
	}

	private static void displayScoreCard(Yahtzee theGame) {
		for (int i = 0; i < theGame.scoreCard().rows(theGame.Dice()).length; i++) {
			if (theGame.scoreCard().rows(theGame.Dice())[i].isScored()) {
				System.out.print("   ");
				System.out.print(theGame.scoreCard().rows(theGame.Dice())[i].label + "\t");
				System.out.println(theGame.scoreCard().rows(theGame.Dice())[i].score());
			} else {
				System.out.print((i+1) + ". ");
				System.out.print(theGame.scoreCard().rows(theGame.Dice())[i].label + "\t");
				System.out.println("(" + theGame.scoreCard().rows(theGame.Dice())[i].score() + ")");
			}
		}

	}

	private static void eliminateDice(Yahtzee theGame) {
		// TODO: Get more than one at a time
		boolean keepGoing = true;
		while (keepGoing) {
			String choice = askForString("      (1-" + theGame.Dice().size() + ") to throw away, (R)oll");
			if (choice.toUpperCase().equals("R")) {
				theGame.rollAgain();
				keepGoing = false;
			} else {
				theGame.eliminateDie(choice);
				if (theGame.Dice().size() == 0) {
					theGame.rollAgain();
					keepGoing = false;
				} else
					displayDice(theGame);
			}
		}
	}

	private static void pickAScore(Yahtzee theGame) {
		int row;
		do {
			row = askForInt("   Choose a Row To Score");
			row -= 1;
		} while (theGame.scoreCard().rows(theGame.Dice())[row].isScored());
		theGame.pickScore(row);
	}

	private static boolean playAgain() {
		String choice = askForString("Play Again Y/N?");
		return choice.toUpperCase().equals("Y");
	}

	public static void takeATurn(Yahtzee theGame) {
		System.out.println("Start a Turn " + theGame.turnsLeft() + " turns left.");
		theGame.startATurn();
		while (theGame.inATurn()) {
			displayScoreCard(theGame);
			displayDice(theGame);
			if (theGame.rollsLeft() > 0) {
				System.out.println(theGame.rollsLeft() + " rolls left.");
				askEliminateOrPickScore(theGame);
			} else
				pickAScore(theGame);
		}
	}
}
