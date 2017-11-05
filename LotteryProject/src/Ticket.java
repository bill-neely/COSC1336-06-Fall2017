
public class Ticket {
	private int[] numbers;
	
	public Ticket(int howManyNumbers, int lowerBound, int upperBound) {
		this.numbers = Utility.uniqueArrayInt(howManyNumbers, lowerBound, upperBound);
	}
	
	public Ticket(int[] numbers) {
		this.numbers = numbers;
	}

	public int[] numbers() {
		return this.numbers;
	}
	

}
