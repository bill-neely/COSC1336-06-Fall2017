import java.util.Scanner;

public class DealerUI {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ShoppingCart myCart = new ShoppingCart();
		Dealership myDealer = Repository.getDealership();
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
						System.out.println("How many do you want?");
						String purchaseQty = scan.nextLine();
						int vehicleNum = Integer.parseInt(vehicleID) - 1;
						int qty = Integer.parseInt(purchaseQty);
						myCart.addVehicle(chosenLot.VehicleList()[vehicleNum], qty);
					}
				}
			}
			else {
				keepGoing = false;
			}
		}
		System.out.println("Thank you for shopping.  Your balance is: " + myCart.BalanceDue());
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
		System.out.println("\tMake\tModel\tDoors\tPrice");
		System.out.println("---\t----\t-----\t-----\t-----");
		int i = 1;
		for (Vehicle car : theVehicles) {
			System.out.print(i + "\t");
			System.out.print(car.make() + "\t");
			System.out.print(car.model() + "\t");
			System.out.print(car.doors() + "\t");
			System.out.println(car.price());
			i++;
		}
	}
	
}
     