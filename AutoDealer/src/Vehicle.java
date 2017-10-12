
public class Vehicle {

	private String make;
	private String model;
	private int doors;
	private float price;
	private int quantity;

	public Vehicle(String make, String model, int doors, float price, int quantity) {
		this.make = make;
		this.model = model;
		this.doors = doors;
		this.price = price;
		this.quantity = quantity;
	}

	public String make() {
		return this.make;
	}

	public String model() {
		return this.model;
	}

	public int doors() {
		return this.doors;
	}

	public float price() {
		return this.price;
	}

	public int quantity() {
		return this.quantity;
	}

	public Vehicle clone(int quantity) {
		return new Vehicle(this.make, this.model, this.doors, this.price, quantity);
	}

}
