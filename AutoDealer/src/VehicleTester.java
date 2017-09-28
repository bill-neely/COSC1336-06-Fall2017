
public class VehicleTester {

	public static void main(String[] args) {
		Vehicle myCar = new Vehicle("Honda", "Pilot", 5, 2985.98f);
		System.out.println(myCar.make() == "Honda");
		System.out.println(myCar.model() == "Pilot");
		System.out.println(myCar.doors() == 5);
		System.out.println(myCar.price() == 2985.98f);
	}

}
