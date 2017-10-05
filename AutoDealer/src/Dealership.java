
public class Dealership {
	public String dealerName;
	private CarLot[] CarLots;
	
	public Dealership(String dealerName, CarLot[] listOfCarLots) {
		this.dealerName = dealerName;
		this.CarLots = listOfCarLots;
	}

	public String dealerName() {
		return this.dealerName;
	}

	public CarLot[] CarLots() {
		return this.CarLots;
	}

}
