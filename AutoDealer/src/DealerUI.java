
public class DealerUI {

	public static void main(String[] args) {
		Dealership myDealer = Repository.getDealership();
		boolean keepGoing = true;
		while (keepGoing) {
			displayCarLots(myDealer.CarLots());
			keepGoing = false;
		}
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
     