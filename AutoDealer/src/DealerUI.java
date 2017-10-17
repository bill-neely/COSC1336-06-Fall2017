import java.util.Scanner;

public class DealerUI {

	private static Scanner scan = new Scanner(System.in);
	
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
		System.out.println("Your balance is: " + myCart.BalanceDue());
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
		System.out.println("\tMake\tModel\tDoors\tPrice\tQty");
		System.out.println("---\t----\t-----\t-----\t-----\t---");
		int i = 1;
		for (Vehicle car : theVehicles) {
			System.out.print(i + "\t");
			System.out.print(car.make() + "\t");
			System.out.print(car.model() + "\t");
			System.out.print(car.doors() + "\t");
			System.out.print(car.price() + "\t");
			System.out.println(car.quantity());
			i++;
		}
	}
	
}
     