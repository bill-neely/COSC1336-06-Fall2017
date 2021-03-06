
public class ShoppingCart {

	private Vehicle[] vehicles;
	private int numberOfCars; 
	
	public ShoppingCart() {
		this.vehicles = new Vehicle[20];
		this.numberOfCars = 0;
	}

	public Vehicle[] vehicles() {
		return this.vehicles;
	}

	public boolean addVehicle(Vehicle car, int quantity) {
		if (car.removeQty(quantity)) { 
		   this.vehicles[this.numberOfCars] = car.clone(quantity);
		   this.numberOfCars++;
		   return true;
		}
		return false;
	}

	public float BalanceDue() {
		float accum = 0;
		for (int i = 0; i < numberOfCars; i++) {
			accum += this.vehicles[i].price() * this.vehicles[i].quantity();
		}
		return accum;
	}
}
