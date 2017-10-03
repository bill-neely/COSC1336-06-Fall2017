
public class CarLotTester {

	public static void main(String[] args) {
		CarLot myLot = new CarLot("downtown", listOfVehicles());
		System.out.println(myLot.location() == "downtown");
		System.out.println(myLot.VehicleList().length == listOfVehicles().length);
	}

	private static Vehicle[] listOfVehicles() {
		Vehicle car1 = new Vehicle("Honda", "Accord", 2, 34.56f);
		return new Vehicle[] {car1, car1};
	}

}
