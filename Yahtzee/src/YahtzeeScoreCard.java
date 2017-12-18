import java.util.ArrayList;

public class YahtzeeScoreCard {

	private YahtzeeScoreCardRow[] rows;

	public YahtzeeScoreCard() {
		this.rows = new YahtzeeScoreCardRow[13];
		this.rows[0] = new YahtzeeScoreCardRow("Aces        ");
		this.rows[1] = new YahtzeeScoreCardRow("Twos        ");
		this.rows[2] = new YahtzeeScoreCardRow("Threes      ");
		this.rows[3] = new YahtzeeScoreCardRow("Fours       ");
		this.rows[4] = new YahtzeeScoreCardRow("Fives       ");
		this.rows[5] = new YahtzeeScoreCardRow("Sixes       ");
		this.rows[6] = new YahtzeeScoreCardRow("3 of A Kind ");
		this.rows[7] = new YahtzeeScoreCardRow("4 of a Kind ");
		this.rows[8] = new YahtzeeScoreCardRow("Full House  ");
		this.rows[9] = new YahtzeeScoreCardRow("Sm. Straight");
		this.rows[10] = new YahtzeeScoreCardRow("Lg. Straight");
		this.rows[11] = new YahtzeeScoreCardRow("Yahtzee     ");
		this.rows[12] = new YahtzeeScoreCardRow("Chance      ");
	}

	public int finalScore() {
		int top = sumRows(0, 5);
		int bottom = sumRows(6,12);
		if (top >= 63)
			return top + 35 + bottom;
		return top + bottom;
	}

	public boolean inARow(ArrayList<Die> dice, int toMatch) {
		for (int i = 1; i + toMatch - 1 <= 6; i++ ) {
			boolean found = true;
			for (int j = i; j < i + toMatch; j++) {
				if (sumOf(dice, j) < j)
					found = false;
			}
			if (found)
				return true;
		}
		return false;
	}

	public YahtzeeScoreCardRow[] rows(ArrayList<Die> dice) {
		calculateScores(dice);
		return this.rows;
	}

	public boolean sameDice(ArrayList<Die> dice, int ofAKind) {
		// TODO: Need to check for exact count in some cases
		for (int i = 1; i <= 6; i++) {
			if (sumOf(dice, i) >= i * ofAKind)
				return true;
		}
		return false;
	}

	public int sumOf(ArrayList<Die> dice, int toMatch) {
		int total = 0;
		for (Die die : dice)
			if (die.sideUp == toMatch || toMatch == -1)
				total += die.sideUp;
		return total;
	}

	public int sumOf(ArrayList<Die> dice) {
		return sumOf(dice, -1);
	}

	private void calculateScores(ArrayList<Die> dice) {
		this.rows[0].setScore(sumOf(dice,1));
		this.rows[1].setScore(sumOf(dice,2));
		this.rows[2].setScore(sumOf(dice,3));
		this.rows[3].setScore(sumOf(dice,4));
		this.rows[4].setScore(sumOf(dice,5));
		this.rows[5].setScore(sumOf(dice,6));
		this.rows[6].setScore(sameDice(dice, 3) ? sumOf(dice) : 0);
		this.rows[7].setScore(sameDice(dice, 4) ? sumOf(dice) : 0);
		this.rows[8].setScore((sameDice(dice, 2) && sameDice(dice, 3)) ? 25 : 0);
		this.rows[9].setScore(inARow(dice, 4) ? 30 : 0);
		this.rows[10].setScore(inARow(dice, 5) ? 40 : 0);
		this.rows[11].setScore(sameDice(dice, 5) ? 50 : 0);
		this.rows[12].setScore(sumOf(dice));
	}

	private int sumRows(int from, int to) {
		int accum = 0;
		for (int i = from; i <= to; i++)
			accum += rows[i].score();
		return accum;
	}

}
