package classdemo.betech.nyc;
/**
 * 
 */

/**
 * @author Betech
 *
 */
public class SwitchCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String day = "Monday";
		// int day2 = 5.0;
		// double day2 = 5.0;

		// String day = new String ("Monday");
		// String day2 = new String ("Monday");

		// Convert int to String day2
		// if(Integer.toString(day2).equals(day)){
		// Convert String to int day variable
		// if((int)day2==Integer.parseInt(day)){
		//
		// System.out.println("True both are equal");
		// }else {
		// System.osut.println("False");
		// }

		// ===============================================

		int[] numberday = { 1, 2, 3, 4, 5, 6, 7};

		for (int i = 0; i < numberday.length;) {

			int day = numberday[i];
// int day = 8;
			switch (day) {
			case 1:
				System.out.println("Crazy working day start");

				break;

			case 2:

				System.out.println("Oh today is Tuesday");
				break;

			case 3:

				System.out.println("Oh today is Wednesday");

				break;

			case 4:

				System.out.println("Oh today is Thursday");
				break;

			case 5:

				System.out.println("Oh today is Friday");
				break;

			case 6:

				System.out.println("Oh today is Saturday");
				break;

			case 7:

				System.out.println("Oh today is Sunday");
				break;
			default:
				System.out.println("Ther is no weekday" + day);
			}

break;
		}

//		String day = "Monday";

	}

}
