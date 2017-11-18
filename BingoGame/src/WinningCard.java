
public class WinningCard {
	private BingoCard card;
	final String winningRule;

	public WinningCard(BingoCard card, String rule) {
		this.card = card;
		this.winningRule = rule;
	}
	
	public BingoCard card() {
		return this.card;
	};

}
