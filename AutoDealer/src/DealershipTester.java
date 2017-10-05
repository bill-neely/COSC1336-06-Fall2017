
public class DealershipTester {

	public static void main(String[] args) {
		Dealership myDealer = new Dealership("NeelyCars", listOfCarLots());
		System.out.println(myDealer.dealerName() == "NeelyCars");
		System.out.println(myDealer.CarLots().length == listOfCarLots().length);
	}

	private static CarLot[] listOfCarLots() {
		return new CarLot[] {new CarLot("test", new Vehicle[0])};
	}
}
