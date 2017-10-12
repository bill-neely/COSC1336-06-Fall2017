import java.util.Scanner;

public class DealerUI {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Dealership myDealer = Repository.getDealership();
		boolean keepGoing = true;
		while (keepGoing) {
			displayCarLots(myDealer.CarLots());
			System.out.println("Please pick a Lot:");
			String lotNumber = scan.nextLine();
			if (!lotNumber.equals("exit")) {
				if (validChoice(lotNumber, myDealer.CarLots().length)) {
					int lotID = Integer.parseInt(lotNumber) - 1;
					System.out.println("You picked lot: " + myDealer.CarLots()[lotID].location());
					displayVehicles(myDealer.CarLots()[lotID].VehicleList());
				}
			}
			else {
				keepGoing = false;
			}
		}
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
		System.out.println("Make\tModel\tDoors\tPrice");
		System.out.println("----\t-----\t-----\t-----");
		for (Vehicle car : theVehicles) {
			System.out.print(car.make() + "\t");
			System.out.print(car.model() + "\t");
			System.out.print(car.doors() + "\t");
			System.out.println(car.price());
		}
	}
	
}
     