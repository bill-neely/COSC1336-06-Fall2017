import java.util.ArrayList;

public class Yahtzee {
	
	private boolean inATurn;
	private int turnsLeft;
	private int rollsLeftInTurn;
	private ArrayList<Die> dice;

	public Yahtzee() {
		this.inATurn = false;
		this.turnsLeft = 13;
		this.rollsLeftInTurn = 0;
		this.dice = new ArrayList<Die>();
	}
	
	public void eliminateDie(String dieNumber) {
		int number = Integer.parseInt(dieNumber);
		this.dice.remove	(number - 1);
	}

	public boolean inATurn() {
		return this.inATurn;
	}

	public boolean isNotOver() {
		return (this.turnsLeft > 0);
	}

	public void pickScore() {
		this.inATurn = false;	
		this.rollsLeftInTurn = 0;
		this.dice.clear();
	}

	public void rollAgain() {
		while (this.dice.size() < 5)
			this.dice.add(new Die());
		this.rollsLeftInTurn--;
	}

	public int rollsLeft() {
		return this.rollsLeftInTurn;
	}

	public void startATurn() {
		this.dice.clear();
		this.turnsLeft--;
		this.inATurn = true;
		this.rollsLeftInTurn = 3;
		this.rollAgain();
	}
	
	public int turnsLeft() {
		return this.turnsLeft;
	}

	public ArrayList<Die> Dice() {
		return this.dice;
	}


}
