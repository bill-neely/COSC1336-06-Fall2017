
public class Average {
	
	public static void main(String[] args) {
		int[] scores = new int[] {18, 13, 10, 19, 87, 21};
		int accum = 0;
		for (int score : scores) {
			accum += score;
		}
		float avg = accum / scores.length;
		System.out.println("The average is: " + avg);
	}
}
