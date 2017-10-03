
public class CarLot {

	private String location;
	private Vehicle[] VehicleList;

	public CarLot(String location, Vehicle[] vehiclesOnLot) {
		this.location = location;
		this.VehicleList = vehiclesOnLot;
	}

	public String location() {
		return this.location;
	}

	public Vehicle[] VehicleList() {
		return this.VehicleList;
	}

}
