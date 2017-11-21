import java.util.ArrayList;

public class YahtzeeUI {

	public static void main(String[] args) {
		Yahtzee theGame = new Yahtzee();
		int counter = 0;
		while (theGame.isNotOver() && counter<5) {
			counter++;
		//    takeATurn()
		//    show the score card
		//    ask - ready to take another turn?
		}
		// displayFinalScore(theGame);
		// if (!playAgain()) then quit
	}

	public static void takeATurn() {
		// theGame.startTurnAndRollDice()
		// showScoringOptions(theGame)
		// showDice(theGame)
		// if theGame.canRollAgain()
		// 	choose a score or roll again
		// else
		//  choose a score
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
