
public class ShoppingCartTester {

	public static void main(String[] args) {
		ShoppingCart myCart = new ShoppingCart();
		System.out.println(myCart.vehicles().length == 20);
		Vehicle car1 = new Vehicle("Honda", "Accord", 4, 1000.00f, 7); 
		myCart.addVehicle(car1, 2);
		System.out.println(myCart.vehicles()[0].make().equals(car1.make()));
		System.out.println(myCart.vehicles()[0].quantity() == 2);
		
		System.out.println(myCart.addVehicle(car1, 4) == true);
		System.out.println(myCart.vehicles()[1].quantity() == 4);
		
		System.out.println(myCart.BalanceDue() == 6000.00f);

		System.out.println(myCart.addVehicle(car1, 4) == false);
	}

}
