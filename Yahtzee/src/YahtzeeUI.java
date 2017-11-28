import java.util.ArrayList;

public class YahtzeeUI {

	public static void main(String[] args) {
		Yahtzee theGame = new Yahtzee();
		while (theGame.isNotOver()) {
			takeATurn(theGame);
			//    show the score card
			//    ask - ready to take another turn?
		}
		// displayFinalScore(theGame);
		// if (!playAgain()) then quit
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
		System.out.println("Start a Turn");
		theGame.startATurn();
		while (theGame.inATurn()) {
			displayDice(theGame);
			// showScoringOptions(theGame)
			if (theGame.rollsLeft() > 0)
				theGame.rollAgain();
			else 
				pickAScore(theGame);
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
