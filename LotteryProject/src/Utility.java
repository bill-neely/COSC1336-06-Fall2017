
public class Utility {
	
	public static boolean isUnique(int[] arr) {
		   for (int i = 0; i <= arr.length - 2; i++) {
		     for (int j = i + 1; j < arr.length; j++) {
		       if (arr[i] == arr[j]) 
		        return false;
		     }
		   }
		   return true;
		}
}
