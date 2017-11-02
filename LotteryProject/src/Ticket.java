
public class Ticket {

	private int[] numbers;

	public Ticket() {
		this.numbers = new int[6];
		do  {
			for (int i = 0; i < this.numbers.length; i++) {
				this.numbers[i] = randBetween(1, 50);
			}
		} while(Utility.isUnique(this.numbers) == false);
	}
	
	public Ticket(int[] numbers) {
		this.numbers = numbers;
	}
	
	public int[] numbers() {
		return this.numbers;
	}

	public static int randBetween(int lower, int upper) {
	    int rand = (int) (Math.random() * ((upper - lower) + 1 ) + lower);
	    return rand;
	  }
	
}
