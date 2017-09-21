
public class Person {
	private String firstName;
	private String lastName;
	
	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public String getLastFirst() {
		return this.lastName + ", " + this.firstName;
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
}
