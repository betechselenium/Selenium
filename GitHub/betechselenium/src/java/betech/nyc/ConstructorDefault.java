package java.betech.nyc;

public class ConstructorDefault
{
   private int stuID;
   private String stuName;
   private int stuAge;
   ConstructorDefault()
   {
       //Default constructor
       stuID = 100;
       stuName = "New Student";
       stuAge = 18;
   }
   ConstructorDefault(int idNumber, String name, int age)
   {
       //Parameterized constructor
       stuID = idNumber;
       stuName = name;
       stuAge = age;
   }
   //Getter and setter methods
   public int getStuID() {
       return stuID;
   }
   public void setStuID(int stuID) {
       this.stuID = stuID;
   }
   public String getStuName() {
       return stuName;
   }
   public void setStuName(String stuName) {
       this.stuName = stuName;
   }
   public int getStuAge() {
       return stuAge;
   }
   public void setStuAge(int stuAge) {
       this.stuAge = stuAge;
   }
}
 
class TestOverloading
{
   public static void main(String args[])
   {
       //This object creation would call the default constructor
       ConstructorDefault myobj = new ConstructorDefault();
       System.out.println("Student Name is: "+myobj.getStuName());
       System.out.println("Student Age is: "+myobj.getStuAge());
       System.out.println("Student ID is: "+myobj.getStuID());
 
       /*This object creation would call the parameterized
        * constructor ConstructorDefault(int, String, int)*/
       ConstructorDefault myobj2 = new ConstructorDefault(555, "Chaitanya", 25);
       System.out.println("Student Name is: "+myobj2.getStuName());
       System.out.println("Student Age is: "+myobj2.getStuAge());
       System.out.println("Student ID is: "+myobj2.getStuID()); 
  }
}