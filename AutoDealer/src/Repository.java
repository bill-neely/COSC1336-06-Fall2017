
public class Repository {

	public static Dealership getDealership() {
		return new Dealership("NeelyCars", getListOfCarLots());
	}
	
	private static CarLot[] getListOfCarLots() {
		CarLot lot1 = new CarLot("Downtown", getListOfVehicles("Downtown"));
		CarLot lot2 = new CarLot("North", getListOfVehicles("North"));
		return new CarLot[] { lot1, lot2 };
	}
	
	private static Vehicle[] getListOfVehicles(String CarLotID) {
		if (CarLotID == "Downtown") {
			Vehicle car1 = new Vehicle("Honda", "Pilot", 5, 1000.30f);
			Vehicle car2 = new Vehicle("Honda", "CRV", 4, 4001.00f);
			Vehicle car3 = new Vehicle("Honda", "Civic", 2, 509.87f);
			Vehicle car4 = new Vehicle("Honda", "Ridgeline", 4, 8976.32f);
			return new Vehicle[] {car1, car2, car3, car4};
		}
		if (CarLotID == "North") {
			Vehicle car1 = new Vehicle("Toyota", "Prius", 5, 1000.30f);
			Vehicle car2 = new Vehicle("Toyota", "Camry", 4, 4001.00f);
			Vehicle car3 = new Vehicle("Toyota", "Tacoma", 2, 509.87f);
			Vehicle car4 = new Vehicle("Toyota", "Tundra", 4, 8976.32f);
			return new Vehicle[] {car1, car2, car3, car4};
		}
		return new Vehicle[0];
	}
	
}
