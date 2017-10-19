import java.util.Scanner;
import java.text.NumberFormat;

public class DealerUI {

	private static Scanner scan = new Scanner(System.in);
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		Dealership myDealer = Repository.getDealership();
		// create an askString() method
		System.out.println("Welcome to " + myDealer.dealerName + ". What is your name?");
		String customerName = scan.nextLine();
		System.out.println("Hello " + customerName + ".  Enjoy your shopping experience");
		ShoppingCart myCart = new ShoppingCart();
		boolean keepGoing = true;
		while (keepGoing) {
			displayCarLots(myDealer.CarLots());
			System.out.println("Please pick a Lot:");
			String lotNumber = scan.nextLine();
			if (!lotNumber.equals("exit")) {
				if (validChoice(lotNumber, myDealer.CarLots().length)) {
					int lotID = Integer.parseInt(lotNumber) - 1;
					CarLot chosenLot = myDealer.CarLots()[lotID];
					System.out.println("You picked lot: " + chosenLot.location());
					displayVehicles(chosenLot.VehicleList());
					System.out.println("Please pick a vehicle");
					String vehicleID = scan.nextLine();
					if (validChoice(vehicleID, chosenLot.VehicleList().length)) {
						int vehicleNum = Integer.parseInt(vehicleID) - 1;
						int qty = askForInt("How many do you want?");
						if (!myCart.addVehicle(chosenLot.VehicleList()[vehicleNum], qty)) {
							System.out.println("I'm sorry, we don't have that many.");
						}
					}
				}
			}
			else {
				keepGoing = false;
			}
		}

		System.out.println("Your balance is: " + formatter.format(myCart.BalanceDue()));
		System.out.println("Thank for shopping, " + customerName + ". Please come again.");
		scan.close();
	}
	
	private static int askForInt(String prompt) {
		System.out.println(prompt);
		String answer = scan.nextLine();
		return Integer.parseInt(answer);
	}
	
	private static boolean validChoice(String lotNumber, int upperLimit) {
		// TODO: Make sure lotNumber is an Integer
		if (Integer.parseInt(lotNumber) > 0 && Integer.parseInt(lotNumber) < upperLimit + 1) {
			return true;
		}
		return false;
	}


	private static void displayCarLots(CarLot[] theLots) {
		for (int i = 0; i < theLots.length; i++) {
			System.out.print((i + 1) + " - ");
			System.out.println(theLots[i].location());
		}
	}
	
	private static void displayVehicles(Vehicle[] theVehicles) {
		System.out.print(padRight("Option", 6) + "\t");
		System.out.print(padRight("Make", 10) + "\t");
		System.out.print(padRight("Model", 10) + "\t");
		System.out.print(padRight("Doors", 5) + "\t");
		System.out.print(padRight("Price", 12) + "\t");
		System.out.println(padRight("Qty", 5));
		//System.out.println("---\t----\t-----\t-----\t-----\t---");
		int i = 1;
		for (Vehicle car : theVehicles) {
			System.out.print(i + "\t");
			System.out.print(padRight(car.make(), 10) + "\t");
			System.out.print(padRight(car.model(), 10) + "\t");
			System.out.print(padRight(car.doors(), 5) + "\t");
			System.out.print(padRight(formatter.format(car.price()),12) + "\t");
			System.out.println(padRight(car.quantity(), 5));
			i++;
		}
	}

	public static String padRight(String phrase, int length) {
		if (phrase.length() >= length) 
			return phrase.substring(0, length);
		String spaces = ""; 
		for (int i = 1; i <= length - phrase.length(); i++)
			spaces += " ";
		return phrase + spaces;
	}

	public static String padRight(float number, int length) {
		return padRight(Float.toString(number), length);
	}

	public static String padRight(int number, int length) {
		return padRight(Integer.toString(number), length);
	}
	
}

     