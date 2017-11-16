	import java.util.ArrayList;

public class ArrayListExamples {

	public static void main(String[] args) {
	      ArrayList<String> myList = new ArrayList<String>();
	      printOut(myList);
	      
	      myList.add("First thing added");
	      printOut(myList);

	      myList.add("Second thing added");
	      myList.add("Third thing added");
	      printOut(myList);
	      
	      myList.add(0, "Fourth thing added");
	      printOut(myList);

	      myList.remove(2);
	      printOut(myList);

	      printWithIndices(myList);    
	      
	      myList.clear();
	      printOut(myList);
	 }

	public static void printWithIndices(ArrayList<String> myList) {
	    System.out.println("");
	    System.out.println("List has size of: " + myList.size());  
	    for (int i = 0; i < myList.size(); i++) {
	      System.out.println("  " + i + " - " + myList.get(i));
	    }
	  }

	public static void printOut(ArrayList<String> myList) {
	    System.out.println("");
	    System.out.println("List has size of: " + myList.size());  
	    for (String element : myList) {
	      System.out.println("  " + element);
	    }
	  }

}
