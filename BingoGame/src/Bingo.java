import java.util.ArrayList;

public class Bingo {

	private int[] masterBoard;

	public Bingo() {
		this.masterBoard = new int[76];  // We will ignore index 0
	}

	public void drawBall() {
		int ball = 0;
		boolean stillDrawing = true;
		while (stillDrawing) {
			ball = Utility.randBetween(1, 75);
			if (!isBallDrawn(ball))
				stillDrawing = false;
		}
		this.masterBoard[ball] = ball;
		this.lastBallDrawn = letterFor(ball) + "-" + ball;
		checkforWinners();
	}

	public boolean isBallDrawn(int number) {
			if (number ==-1)
				return true;
			if (masterBoard[number] != 0)
				return true;
		return false;
	}
}
