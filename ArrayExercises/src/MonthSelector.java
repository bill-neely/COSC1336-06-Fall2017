import java.util.Scanner;
public class MonthSelector {

	public static void main(String[] args) {
		String monthName[] = new String[] {"January", "February", "March", "April","May",
				"Jun", "July", "Aug", "Sep", "Oct","Nov", "Dec"};
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a month Number");
		int number = Integer.parseInt(scan.nextLine());
		
		System.out.println(monthName[number - 1]);
	}

}
