package classdemo.betech.nyc;

public class Overloading {

	public static void main(String[] args) {
		System.out.println(add(1,3));
		System.out.println(add(1,3,5));
	}

	
	private static int add(int i, int j) {
		
////		int result = i+j;
////		return result;
		return i+j;
		
	}
	
	private static double add(int i, int j, int k ) {
		
//		int result = i+j;
//		return result;
		return i+j+k;
		
	}
	
	// same name of method different parameter or different data type

}
