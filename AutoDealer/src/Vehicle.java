
public class Vehicle {

	private String make;
	private String model;
	private int doors;
	private float price;

	public Vehicle(String make, String model, int doors, float price) {
		this.make = make;
		this.model = model;
		this.doors = doors;
		this.price = price;
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

}
