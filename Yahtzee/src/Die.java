
public class Die {

	final int sideUp;
	
	public Die() {
		this.sideUp = randBetween(1, 6);
	}

	public Die(int value) {
		sideUp = value;
	}

	public static int randBetween(int lower, int upper) {
		return (int) (Math.random() * ((upper-lower) + 1)) + lower;
	}

}
