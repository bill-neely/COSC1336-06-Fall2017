
public class DealerUI {

	public static void main(String[] args) {
		Vehicle[] myCars = listOfCars();
		System.out.println("Make\tModel\tDoors\tPrice");
		System.out.println("----\t-----\t-----\t-----");
		for (Vehicle car : myCars) {
			System.out.print(car.make() + "\t");
			System.out.print(car.model() + "\t");
			System.out.print(car.doors() + "\t");
			System.out.println(car.price());
		}
	}

	private static Vehicle[] listOfCars() {
		// TODO: Move to a repository class
		Vehicle[] cars;
		Vehicle car1 = new Vehicle("Honda", "Pilot", 5, 1000.30f);
		Vehicle car2 = new Vehicle("Toyota", "Prius", 2, 5987.20f);
		cars = new Vehicle[] {car1, car2, car1, car2};
		return cars;
	}

}
     