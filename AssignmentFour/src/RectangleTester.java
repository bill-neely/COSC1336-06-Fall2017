
public class RectangleTester {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(4, 8);
	    System.out.println(rec1.area() == 32);
	    System.out.println(rec1.perimeter() == 24);
	    System.out.println(rec1.diagonal() == 8.944272f);
	    System.out.println(rec1.isSquare() == false);

	    Rectangle rec2 = new Rectangle(12, 12);
	    System.out.println(rec2.area() == 144);
	    System.out.println(rec2.perimeter() == 48);
	    System.out.println(rec2.diagonal() == 16.970562f);
	    System.out.println(rec2.isSquare() == true);
	}

}
