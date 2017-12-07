import java.util.ArrayList;

public class YahtzeeScoreTester {

	public static void main(String[] args) {
		sumOfTests();
		sameDiceTests();
		inARowTests();
		rowTests();
		recordScoreTests();
		printScoreCard();
	}

	private static void printScoreCard() {
		System.out.println("recordScoreTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {1,2,3,4,5});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		
		scoreCard.rows(dice)[2].recordScore();
		
		for (int i = 0; i < scoreCard.rows(dice).length; i++) {
			if (scoreCard.rows(dice)[i].isScored()) {
				System.out.print("   ");
				System.out.print(scoreCard.rows(dice)[i].label + "\t");
				System.out.println(scoreCard.rows(dice)[i].score());
			} else {
				System.out.print((i+1) + ". ");
				System.out.print(scoreCard.rows(dice)[i].label + "\t");
				System.out.println("(" + scoreCard.rows(dice)[i].score() + ")");			
			}
		}
		
	}

	private static void recordScoreTests() {
		System.out.println("recordScoreTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {1,2,3,4,5});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		
		System.out.println(scoreCard.rows(dice)[0].isScored() == false);
		System.out.println(scoreCard.rows(dice)[0].score() == 1);
		scoreCard.rows(dice)[0].recordScore();
		System.out.println(scoreCard.rows(dice)[0].isScored() == true);
		System.out.println(scoreCard.rows(dice)[0].score() == 1);

		dice = makeSomeDice(new int[] {1,1,1,1,5});
		System.out.println(scoreCard.rows(dice)[4].score() == 5);
		System.out.println(scoreCard.rows(dice)[0].score() == 1);

		
	}

	private static void rowTests() {
		System.out.println("RowTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {1,2,3,4,5});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		System.out.println(scoreCard.rows(dice).length == 13);
		System.out.println(scoreCard.rows(dice)[0].label.trim().equals("Aces"));
		System.out.println(scoreCard.rows(dice)[12].label.trim().equals("Chance"));
		
		System.out.println(scoreCard.rows(dice)[0].isScored() == false);
		System.out.println(scoreCard.rows(dice)[12].isScored() == false);

		System.out.println(scoreCard.rows(dice)[0].score() == 1);
		System.out.println(scoreCard.rows(dice)[11].score() == 0);
		System.out.println(scoreCard.rows(dice)[12].score() == 15);
		
		dice = makeSomeDice(new int[] {3,3,3,2,2});
		System.out.println(scoreCard.rows(dice)[8].score() == 25);
		
		dice = makeSomeDice(new int[] {3,3,3,2,1});
		System.out.println(scoreCard.rows(dice)[8].score() == 0);
		
	}

	private static void inARowTests() {
		System.out.println("InARowTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {1,2,3,4,5});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		System.out.println(scoreCard.inARow(dice, 3) == true);
		System.out.println(scoreCard.inARow(dice, 5) == true);

		dice = makeSomeDice(new int[] {3,2,6,6,6});
		System.out.println(scoreCard.inARow(dice, 2) == true);
		System.out.println(scoreCard.inARow(dice, 3) == false);
	}

	public static void sameDiceTests() {
		System.out.println("SameDiceTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {5,3,1,1,4});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		System.out.println(scoreCard.sameDice(dice, 3) == false);
		System.out.println(scoreCard.sameDice(dice, 2) == true);
		System.out.println(scoreCard.sameDice(dice, 1) == true);

		dice = makeSomeDice(new int[] {5,5,5,5,5});
		System.out.println(scoreCard.sameDice(dice, 4) == true);
	}

	public static void sumOfTests() {
		System.out.println("SumOfTests");
		ArrayList<Die> dice;
		dice = makeSomeDice(new int[] {5,3,1,1,4});
		YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
		System.out.println(scoreCard.sumOf(dice, 1) == 2);
		System.out.println(scoreCard.sumOf(dice, 5) == 5);
		System.out.println(scoreCard.sumOf(dice, 6) == 0);
		System.out.println(scoreCard.sumOf(dice) == 14);
	}

	private static ArrayList<Die> makeSomeDice(int[] values) {
		ArrayList<Die> dice = new ArrayList<Die>();
		for (int i : values)
			dice.add(new Die(i));
		return dice;
	}

}
