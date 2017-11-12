
public class BingoRules {

	public String isWinner(BingoCard card, Bingo theGame) {
		String winReason = checkColumns(card, theGame);
		if (winReason != null)
			return winReason;
 		winReason = checkRows(card, theGame);
 		if (winReason != null)
			return winReason;
		winReason = checkDiagonals(card, theGame);
		if (winReason != null)
			return winReason;
		return null;
	}
}
