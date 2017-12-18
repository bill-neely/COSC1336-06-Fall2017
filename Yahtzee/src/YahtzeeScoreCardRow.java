
public class YahtzeeScoreCardRow {

	final String label;
	private boolean isScored;
	private int score;

	public YahtzeeScoreCardRow(String label) {
		this.label = label;
		this.isScored = false;
	}

	public boolean isScored() {
		return this.isScored;
	}

	public void recordScore() {
		this.isScored = true;
	}

	public int score() {
		return this.score;
	}

	public void setScore(int score) {
		if (!this.isScored)
			this.score = score;
	}

}
