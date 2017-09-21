
public class PersonTester {

	public static void main(String[] args) {
		Person me = new Person("Bill", "Neely");
		System.out.println(me.getName());  // should print "Bill Neely"
		System.out.println(me.getLastFirst());
		me.setFirstName("Harold");
		System.out.println(me.getLastFirst());
	}

}
