import java.util.ArrayList;
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
	
	private static boolean playAgain() {
		String choice = askForString("Play Again Y/N?");
		return choice.toUpperCase().equals("Y");
	}

	private static void displayFinalScore(Yahtzee theGame) {
		System.out.println("This is your final score!");
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

	private static void pickAScore(Yahtzee theGame) {
		theGame.pickScore();
		System.out.println("   Pick A score");
	}

	public static void takeATurn(Yahtzee theGame) {
		System.out.println("Start a Turn " + theGame.turnsLeft() + " turns left.");
		theGame.startATurn();
		while (theGame.inATurn()) {
			displayDice(theGame);
			// showScoringOptions(theGame)
			if (theGame.rollsLeft() > 0) {
				System.out.println(theGame.rollsLeft() + " rolls left.");
				askEliminateOrPickScore(theGame);
			} else 
				pickAScore(theGame);
		}
	}

	private static void askEliminateOrPickScore(Yahtzee theGame) {
		String choice = askForString("    (P)ick a score, (R)oll Again");
		if (choice.toUpperCase().equals("P"))
			pickAScore(theGame);
		else 
			eliminateDice(theGame);
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

	public static void RollSomeDice() {
		ArrayList<Die> myDice = new ArrayList<Die>(); 
		myDice = getDice(5);
		printOut(myDice);
	}

	private static ArrayList<Die> getDice(int numberToMake) {
		ArrayList<Die> myDice = new ArrayList<Die>();
		for (int i = 0; i < numberToMake; i++) {
			myDice.add(new Die());
		}
		return myDice;
	}

	public static void printOut(ArrayList<Die> myList) {
		System.out.println("");
		System.out.println("List has size of: " + myList.size());  
		for (Die element : myList) {
			System.out.println("  " + element.sideUp);
		}
	}
}
