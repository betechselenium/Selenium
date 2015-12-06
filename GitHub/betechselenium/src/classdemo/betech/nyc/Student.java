package classdemo.betech.nyc;
/**
 * 
 */

/**
 * @author Betech
 *
 */
public class Student {

private String name;
private int rollNumber;
private  long phoneNumber;
private  double gpa;
 
 




//name = "betech";

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getRollNumber() {
	return rollNumber;
}

public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
}

public long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public double getGpa() {
	return gpa;
}

public void setGpa(double gpa) {
	this.gpa = gpa;
}

public static int getIresult1() {
	return iresult1;
}

public static void setIresult1(int iresult1) {
	Student.iresult1 = iresult1;
}

public static int iresult1 = 9;

//Class name always Noun and it should Upper camecase
//Method name always verb adn it should be lower CameCase


public String getResult(String result){

	return result;
}

//private class abc{
//	
//}

}

