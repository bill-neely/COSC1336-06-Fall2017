import java.util.ArrayList;

public class Bingo {

	private BingoCard[] cards;
	private String lastBallDrawn;
	private int[] masterBoard;
	private boolean hasWinner;
	private BingoRules rules;
	private ArrayList<WinningCard> winningCards;

	public Bingo() {
		this.winningCards = new ArrayList<WinningCard>();
		this.rules = new BingoRules();
		this.hasWinner = false;
		this.masterBoard = new int[76];  // We will ignore index 0
	}

	public BingoCard[] cards() {
		return this.cards;
	}

	public void createBingoCards(int cardsToMake) {
		this.cards = new BingoCard[cardsToMake];
		for (int i = 0; i < cardsToMake; i++) {
			this.cards[i]= new BingoCard();
		}
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

	public boolean hasWinner() {
		return this.hasWinner;
	}

	public boolean isBallDrawn(int number) {
			if (number ==-1)
				return true;
			if (masterBoard[number] != 0)
				return true;
		return false;
	}

	public String lastBallDrawn() {
		return this.lastBallDrawn;
	}

	public int[] masterBoard() {
		return this.masterBoard;
	}
	
	public ArrayList<WinningCard> winningCards() {
		return this.winningCards;
	}

	private void checkforWinners() {
		for (BingoCard card : cards) {
			String win = rules.isWinner(card, this);
			if (win != null) {
				this.hasWinner = true;
				this.winningCards.add(new WinningCard(card, win));
			}
		}	
	}

	private String letterFor(int ball) {
		if (ball >= 1 && ball <= 15)
			return "B";
		if (ball >= 16 && ball <= 30)
			return "I";
		if (ball >= 31 && ball <= 45)
			return "N";
		if (ball >= 46 && ball <= 60)
			return "G";
		return "O";
	}
	
}
