
public class BingoRules {

	public String isWinner(BingoCard card, Bingo theGame) {
		String win = checkColumns(card, theGame);
		if (win != null)
			return win;
 		win = checkRows(card, theGame);
 		if (win != null)
			return win;
		win = checkDiagonals(card, theGame);
		if (win != null)
			return win;
		return null;
	}

	private boolean checkColumn(int[] column, Bingo theGame) {
		for (int i=0; i<column.length; i++) {
			if (!theGame.isBallDrawn(column[i]))
				return false;
		}
		return true;
	}

	private String checkColumns(BingoCard card, Bingo theGame) {
		if (checkColumn(card.BColumn, theGame))
			return "5 Down Column B";
		if (checkColumn(card.IColumn, theGame))
			return "5 Down Column I";
		if (checkColumn(card.NColumn, theGame))
			return "5 Down Column N";
		if (checkColumn(card.GColumn, theGame))
			return "5 Down Column G";
		if (checkColumn(card.OColumn, theGame))
			return "5 Down Column O";
		return null;
	}

	private String checkDiagonals(BingoCard card, Bingo theGame) {
		if (theGame.isBallDrawn(card.BColumn[0]) && theGame.isBallDrawn(card.IColumn[1]) &&
				theGame.isBallDrawn(card.NColumn[2]) && theGame.isBallDrawn(card.GColumn[3]) && 
				theGame.isBallDrawn(card.OColumn[4]))
			return "5 Diagonal left down to right";
		if (theGame.isBallDrawn(card.BColumn[4]) && theGame.isBallDrawn(card.IColumn[3]) &&
				theGame.isBallDrawn(card.NColumn[2]) && theGame.isBallDrawn(card.GColumn[1]) && 
				theGame.isBallDrawn(card.OColumn[0]))
			return "5 Diagonal right down to left";;
		return null;
	}

	private String checkRow(int row, BingoCard card, Bingo theGame) {
		if (theGame.isBallDrawn(card.BColumn[row]) && theGame.isBallDrawn(card.IColumn[row]) &&
				theGame.isBallDrawn(card.NColumn[row]) && theGame.isBallDrawn(card.GColumn[row]) && 
				theGame.isBallDrawn(card.OColumn[row]))
			return "5 Across Row " + (row + 1) ;
		return null;
	}

	private String checkRows(BingoCard card, Bingo theGame) {
		for (int i=0; i < card.BColumn.length; i++) {
			String win = checkRow(i, card, theGame);
			if (win != null)
				return win;
		}
		return null;
	}

}
