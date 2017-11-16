import java.util.ArrayList;

public class YahtzeUI {

	public static void main(String[] args) {
		ArrayList<Die> myDice = new ArrayList<Die>(); 
		myDice = getDice(6);
		printOut(myDice);
	}

	private static ArrayList<Die> getDice(int numberToMake) {
		ArrayList<Die> myDice = new ArrayList<Die>();
		for (int i = 0; i < numberToMake; i++) {
			myDice.add(new Die());
		}
		return myDice;
	}
	
	public static void printOut(ArrayList<Die> myList) {
	    System.out.println("");
	    System.out.println("List has size of: " + myList.size());  
	    for (Die element : myList) {
	      System.out.println("  " + element.sideUp);
	    }
	}
}
