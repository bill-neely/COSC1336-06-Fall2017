
public class VehicleTester {

	public static void main(String[] args) {
		Vehicle myCar = new Vehicle("Honda", "Pilot", 5, 2985.98f, 5);
		System.out.println(myCar.make() == "Honda");
		System.out.println(myCar.model() == "Pilot");
		System.out.println(myCar.doors() == 5);
		System.out.println(myCar.price() == 2985.98f);
		System.out.println(myCar.quantity() == 5);
		
		System.out.println(myCar.removeQty(2) == true);
		System.out.println(myCar.quantity() == 3);

		System.out.println(myCar.removeQty(5) == false);
		System.out.println(myCar.quantity() == 3);
				
		Vehicle myCar2 = myCar.clone(2);
		System.out.println(myCar2.quantity() == 2);
		System.out.println(myCar2.make().equals(myCar.make()));
	}

}
